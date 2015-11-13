/*
 * Copyright (C) 2013 The Android Open Source Project
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
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shazam.minishazam.ChartManager;
import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;
import com.shazam.minishazam.model.Heading;
import com.shazam.minishazam.model.Images;
import com.shazam.minishazam.service.ShazamServiceManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Displays the list of tracks in this months Charts * <p/>
 *
 * @author michaelakakpo
 * @version 08/10/15.
 */
public class ChartListFragment extends Fragment {

    private static final Logger LOG_TAG = LoggerFactory.getLogger(ChartListFragment.class);

    private MainActivity mCurrentActivity;
    private ShazamServiceManager mShazamServiceManager;
    private ChartManager mChartManager;

    TrackRecyclerAdapter mTrackRecyclerAdapter;

    // @InjectView(R.id.recycler_view_list)
    private RecyclerView mRecyclerView;

    // Key for Serialising the Charts in the ChartManager
    private static final String sCHART_TRACKS = "chart_tracks";
    // Key for Serialising individual chart items in the ChartManager
    private static final String sCURRENT_TRACK = "current_track";

    public ChartListFragment() {
    /* No args constructor */
    }

    public static ChartListFragment newInstance() {
        return new ChartListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        /* This makes sure that the container activity is MainActivity
        If not, it throws an exception */
        try {
            this.mCurrentActivity = (MainActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(mCurrentActivity.toString()
                    + " must extend MainActivity");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG_TAG.info("onCreate");
        setRetainInstance(true);
        // Initialise the service manager and chart manager before the view is drawn
        this.mShazamServiceManager = mCurrentActivity.mShazamServiceManager;
        this.mChartManager = mCurrentActivity.mChartManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LOG_TAG.info("onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_chart_list, container, false);

        // Initialise adapter with initial empty chart manager
        mTrackRecyclerAdapter = new TrackRecyclerAdapter(getActivity(), mChartManager.getCharts());

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_list);

        // Set Adapter on the RecyclerView
        mRecyclerView.setAdapter(mTrackRecyclerAdapter);
        // Display the chart items as a list
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Allow the RecyclerView items to intercept touch events
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mRecyclerView, new ClickListener() {
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

        return rootView;
    }

    public List<Chart> getData() {

        List<Chart> ls = new ArrayList<>();

        for (int currentChartItem = 0; currentChartItem < 6; currentChartItem++) {

            Chart chartItem = new Chart();

            Heading heading = new Heading();
            heading.setSubtitle("test subtitle");
            heading.setTitle("Test ttile");
            Images images = new Images("https://upload.wikimedia.org/wikipedia/en/a/ac/Fan_of_a_Fan_The_Album.jpg");

            chartItem.setImages(images);
            chartItem.setHeading(heading);

            ls.add(chartItem);

        }
        return ls;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LOG_TAG.info("onViewCreated");
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LOG_TAG.info("onActivityCreated");

    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        LOG_TAG.info("onViewStateRestored");

//        if (savedInstanceState != null) {
//            LOG_TAG.info("reload from the bundle ");
//            // Retrieve the saved chart list
//            List<Chart> restoredCharts = savedInstanceState.getParcelableArrayList(sCHART_TRACKS);
//
////            LOG_TAG.info("Restored: {}, chart items", restoredCharts.size());
//
//            mTrackRecyclerAdapter.addItemsToList(restoredCharts);
//
//        } else {
//            LOG_TAG.info("Chart Manager size before download: {}", mChartManager.getCharts().size());
//            // Load the content
//            loadData();
//        }

        loadData();
    }

    @Override
    public void onResume() {
        super.onResume();
        LOG_TAG.info("onActivityCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        LOG_TAG.info("onActivityCreated");

    }

    /* Saving the results from the fetch so we can minimise battery drain.
     * If we have instance state saved then load chart data into the adapter
     * and save us from making another call to the service, otherwise hit our
     * endpoint and retrieve the charts from the server
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LOG_TAG.info("onSaveInstanceState");
//        if (mChartManager != null) {
//            LOG_TAG.info("Serialising charts....");
//            List<Chart> savedCharts = mTrackRecyclerAdapter.getCharts();
//            LOG_TAG.info("Saving {} chart items...", savedCharts.size());
//
//            outState.putParcelableArrayList(sCHART_TRACKS, Lists.newArrayList(savedCharts));
//        }
//        super.onSaveInstanceState(outState);

    }

    @Override
    public void onStop() {
        super.onStop();
        LOG_TAG.info("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LOG_TAG.info("onDestroy");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LOG_TAG.info("onDestroyView");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        LOG_TAG.info("onDetach");
    }


    // Check if network connection is present then attempt to load Shazam chart list
    private void loadData() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // Asynchronously load the cakes (not blocking the main thread)

            mShazamServiceManager.getCharts(); // TODO: dependency injection for fragments dagger / butterknife

            Toast.makeText(getActivity(), "Fetching data", Toast.LENGTH_SHORT).show();
        } else {
            // let user know the connection is not available

            Toast.makeText(getActivity(), "No internet connection", Toast.LENGTH_LONG).show();
            LOG_TAG.info("No network connection available");
            // snackbar as notification there is no internet

        }
    }

    /* Response for single click on chart items in the RecyclerView */
    private void viewChartItemDetail(int position) {
        LOG_TAG.debug("View item detail at: {}", position);

        // Extract the Chart item at position clicked
        Chart chartItem = mTrackRecyclerAdapter.getCharts().get(position);

        LOG_TAG.info("selectedChart ", "chart item" + chartItem.getImages().getDefault());
        LOG_TAG.info("selectedChart ", "chart item" + chartItem.getImages().getDefault());
        LOG_TAG.info("selectedChart ", "chart item" + chartItem.getImages().getDefault());

        // Store the item in a bundle and send to {@link ChartDetailActivity} for viewing
//        Intent viewDetailIntent = new Intent(getActivity(), ChartDetailActivity.class);
        Intent viewDetailIntent = new Intent(getActivity(), NowPlayingActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(sCURRENT_TRACK, chartItem);

        viewDetailIntent.putExtras(bundle);

        startActivity(viewDetailIntent);
    }


}
