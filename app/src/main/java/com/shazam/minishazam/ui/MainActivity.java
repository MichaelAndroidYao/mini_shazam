/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shazam.minishazam.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.google.common.collect.Lists;
import com.shazam.minishazam.ChartManager;
import com.shazam.minishazam.R;
import com.shazam.minishazam.event.ChartsDownloadedEvent;
import com.shazam.minishazam.event.ChartsDownloadedFailedEvent;
import com.shazam.minishazam.event.HideDialogEvent;
import com.shazam.minishazam.event.ShowDialogEvent;
import com.shazam.minishazam.model.Chart;
import com.shazam.minishazam.service.ShazamServiceManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Displays the list of tracks in this months Charts * <p/>
 *
 * @author Michael Akakpo
 */
public class MainActivity extends EventBaseActivity {

    private static final Logger LOG_TAG = LoggerFactory.getLogger(MainActivity.class);

    @Inject
    ShazamServiceManager mShazamServiceManager;

    @Inject
    ChartManager mChartManager;

    @InjectView(R.id.recycler_view_list)
    RecyclerView mRecyclerView;

    @InjectView(R.id.activity_view_music_toolbar)
    Toolbar mViewMusicToolbar;

    private TrackRecyclerAdapter mTrackRecyclerAdapter;

    // Key for Serialising the Charts in the ChartManager
    private static final String sCHART_TRACKS = "chart_tracks";
    // Key for Serialising individual chart items in the ChartManager
    private static final String sCURRENT_TRACK = "current_track";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        LOG_TAG.info("onCreate");

        // Set up the App bar
        setSupportActionBar(mViewMusicToolbar);

        // Initialise adapter with initial empty chart manager
        mTrackRecyclerAdapter = new TrackRecyclerAdapter(this, mChartManager.getCharts());
        // Set Adapter on the RecyclerView
        mRecyclerView.setAdapter(mTrackRecyclerAdapter);
        // Display the chart items as a list
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Allow the RecyclerView items to intercept touch events
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new ClickListener() {
            /** Handles user's click */
            @Override
            public void onClick(View view, int position) {
                // Handle the click on the chart item
                viewChartItemDetail(position);
            }

            /** Handles user's long press */
            @Override
            public void onLongClick(View view, int position) {
                // handle the long press on a chart item e.g. to display a context menu
            }
        }));
        /* Saving the results from the fetch so we can minimise battery drain.
         * If we have instance state saved then load chart data into the adapter
         * and save us from making another call to the service, otherwise hit our
         * endpoint and retrieve the charts from the server
         */
        if (savedInstanceState != null) {
            LOG_TAG.info("Loading Instance state: Not the first time loading charts");
            // Retrieve the saved chart list
            List<Chart> restoredCharts = savedInstanceState.getParcelableArrayList(sCHART_TRACKS);

            //   LOG_TAG.info("Restored: {}, chart items", restoredCharts.size());

            updateChart(restoredCharts);
        } else {

            //   LOG_TAG.info("First time downloading charts...");
            LOG_TAG.info("Chart Manager size before download: {}", mChartManager.getCharts().size());
            mShazamServiceManager.getCharts();
        }
    }

    /* Saving the charts to reduce the need to fetch them
         * from the server each time the configuration changes */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        LOG_TAG.info("onSaveInstanceState");
        if (mChartManager != null) {
            LOG_TAG.info("Serialising charts....");
            List<Chart> savedCharts = mTrackRecyclerAdapter.getCharts();
            LOG_TAG.info("Saving {} chart items...", savedCharts.size());

            outState.putParcelableArrayList(sCHART_TRACKS, Lists.newArrayList(savedCharts));
        }
        super.onSaveInstanceState(outState);
    }

    /* Response for single click on chart items in the RecyclerView */
    private void viewChartItemDetail(int position) {
        //   LOG_TAG.debug("View item detail at: {}",  position);

        Chart chartItem = mTrackRecyclerAdapter.getCharts().get(position);

        Intent viewDetailIntent = new Intent(this, ChartDetailActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(sCURRENT_TRACK, chartItem);

        viewDetailIntent.putExtras(bundle);

        startActivity(viewDetailIntent);
    }


    // TODO - handle no internet connection errors when loading data
// REF: http://stackoverflow.com/questions/20786593/how-should-i-handle-no-internet-connection-with-retrofit-on-android

    /* Upon successfully downloading the Shazam charts the UI should be updated */
    public void onEvent(ChartsDownloadedEvent event) {
        LOG_TAG.info("Chart downloaded successfully...");
        // The Chart download was a success, so now update the UI
        updateChart(mChartManager.getCharts());
    }

    /* In the event the download failed the error should be logged and handled */
    public void onEvent(ChartsDownloadedFailedEvent event) {
        // The Chart download failed, log the error
        LOG_TAG.error("Retrofit Error on Callback: {}", event.getResponseError());
    }

    /* Update the list of chart items in the adapter */
    private void updateChart(List<Chart> charts) {

        mTrackRecyclerAdapter.addItemsToList(charts);

    }

    @Override
    public void onEvent(ShowDialogEvent event) {
        super.onEvent(event);
    }

    @Override
    public void onEvent(HideDialogEvent event) {
        super.onEvent(event);
    }

    /**
     * {@link GestureDetector} TouchListener for intercepting touch events on the RecyclerView
     * It allows the children in the view hierarchy to independently decide
     * how they will intercept the events correctly.
     */
    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        // Gesture detector
        private final GestureDetector gestureDetector;
        private final ClickListener mClickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.mClickListener = clickListener;

            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                /**
                 * @inheritDoc
                 */
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                /**
                 * @inheritDoc
                 */
                @Override
                public void onLongPress(MotionEvent e) {
                    // Get the X and Y coordinates of the child view that was clicked
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mClickListener != null) {
                        mClickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        /**
         * @inheritDoc
         */
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());

            if (child != null && mClickListener != null && gestureDetector.onTouchEvent(e)) {
                mClickListener.onClick(child, rv.getChildAdapterPosition(child));
            }

            return false;
        }

        /**
         * @inheritDoc
         */
        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        /**
         * @inheritDoc
         */
        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    /**
     * The click and long press listener for when items in the chart are selected
     */
    public interface ClickListener {

        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}