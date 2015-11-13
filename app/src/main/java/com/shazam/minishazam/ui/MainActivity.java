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

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.shazam.minishazam.ChartManager;
import com.shazam.minishazam.R;
import com.shazam.minishazam.event.ChartsDownloadedEvent;
import com.shazam.minishazam.event.ChartsDownloadedFailedEvent;
import com.shazam.minishazam.event.HideDialogEvent;
import com.shazam.minishazam.event.LoadDataEvent;
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
 * Displays the chart list
 *
 * @author Michael Akakpo
 */
public class MainActivity extends EventBaseActivity {

    private static final Logger LOG_TAG = LoggerFactory.getLogger(MainActivity.class);

    private ProgressDialog mLoading;

    @Inject
    ShazamServiceManager mShazamServiceManager;

    @Inject
    ChartManager mChartManager;

    private ChartListFragment mChartListFragment;

    @InjectView(R.id.activity_view_music_toolbar)
    Toolbar mViewMusicToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        LOG_TAG.info("onCreate");

        // Set up the App bar
        setSupportActionBar(mViewMusicToolbar);

        // Check if the fragment has been added previously
        if (savedInstanceState == null) {
            if (mChartListFragment == null) {
                // Activity starting first time
                mChartListFragment = ChartListFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, mChartListFragment, "chart_list_fragment")
                        .commit();
            } else {
                LOG_TAG.info("Fragment retained");
                mChartListFragment = (ChartListFragment) getSupportFragmentManager()
                        .findFragmentByTag("chart_list_fragment");
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LOG_TAG.info("onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LOG_TAG.info("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LOG_TAG.info("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LOG_TAG.info("onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LOG_TAG.info("onDestroy()");
        if (mChartListFragment != null) {
            // Remove reference to fragment upon activity being destroyed
            mChartListFragment = null;
        }
    }

    // TODO - handle no internet connection errors when loading data
// REF: http://stackoverflow.com/questions/20786593/how-should-i-handle-no-internet-connection-with-retrofit-on-android

    /* Upon successfully downloading the Shazam charts the UI should be updated */
    void onEvent(ChartsDownloadedEvent event) {
        LOG_TAG.info("Chart downloaded successfully...");
        // The Chart download was a success, so now update the UI with the charts in the manager
        if (mChartManager != null) {
            updateChart(mChartManager.getCharts());
        }
//        Toast.makeText(this, "charts downloaded successfully: " + mChartManager.getCharts().size(), Toast.LENGTH_LONG).show();
    }

    /* In the event the download failed the error should be logged and handled */
    void onEvent(ChartsDownloadedFailedEvent event) {
        // The Chart download failed, log the error
        Toast.makeText(this, "charts download failed: ", Toast.LENGTH_LONG).show();
        LOG_TAG.error("Retrofit Error on Callback: {}", event.getResponseError());
    }

    void onEvent(LoadDataEvent event) {
        super.onEvent(event);
        Toast.makeText(this, "lading that event ", Toast.LENGTH_LONG).show();

    }

    /* Update the list of chart items in the adapter */
    private void updateChart(List<Chart> charts) {
        if (mChartListFragment != null) {
            if (mChartListFragment.mTrackRecyclerAdapter != null) {
                mChartListFragment.mTrackRecyclerAdapter.addItemsToList(charts);
            }
        }

    }

    @Override
    public void onEvent(ShowDialogEvent event) {
        super.onEvent(event);
        // mLoading = ProgressDialog.show(this, "", "", true);

    }

    @Override
    public void onEvent(HideDialogEvent event) {
        super.onEvent(event);
    }
}