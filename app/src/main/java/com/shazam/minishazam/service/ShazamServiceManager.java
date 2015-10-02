/*  Copyright (C) 2013 The Android Open Source Project
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

package com.shazam.minishazam.service;

import com.shazam.minishazam.ChartManager;
import com.shazam.minishazam.event.ChartsDownloadedEvent;
import com.shazam.minishazam.event.ChartsDownloadedFailedEvent;
import com.shazam.minishazam.event.HideDialogEvent;
import com.shazam.minishazam.event.ShowDialogEvent;
import com.shazam.minishazam.model.Chart;
import com.shazam.minishazam.response.GetRecentChartsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Managing Api calls using the defined Retrofit interface {@link ShazamServiceApi}
 *
 * @author michaelakakpo
 */
public class ShazamServiceManager {

    private static final Logger LOG_TAG = LoggerFactory.getLogger(ShazamServiceManager.class);
    private final ShazamService mShazamService;
    private final ChartManager mChartManager;
    private List<Chart> listOfReturnedChartsFromResponse;

    public ShazamServiceManager(ShazamService shazamService, ChartManager chartManager) {
        mShazamService = shazamService;
        mChartManager = chartManager;
    }

    /**
     * This uses the async callback interface Retrofit provides
     * (the last argument defined in the interface is a Callback, so the request is asynchronous)
     */
    public void getCharts() {
        // Inform user the content is loading
        EventBus.getDefault().post(new ShowDialogEvent());
        // Use the service to retrieve the charts for this month
        mShazamService.getCharts(new Callback<GetRecentChartsResponse>() {
            @Override
            public void success(GetRecentChartsResponse thisMonthsChartsResponse, Response response) {
                EventBus.getDefault().post(new HideDialogEvent());
                // Update the singleton Chart Manager
                listOfReturnedChartsFromResponse = thisMonthsChartsResponse.getChartsResponse();
                mChartManager.setCharts(listOfReturnedChartsFromResponse);

                // LOG_TAG.info("Chart Manager now has {}: after response", mChartManager.getCharts().toString());

                // Notify the UI thread
                EventBus.getDefault().post(new ChartsDownloadedEvent(thisMonthsChartsResponse));
            }

            // TODO - handle errors if network has issues
            @Override
            public void failure(RetrofitError error) {
                // Remove loading screen and capture error
                EventBus.getDefault().post(new HideDialogEvent());
                LOG_TAG.error("Retrofit Error on Callback: {}", error.getMessage());
                EventBus.getDefault().post(new ChartsDownloadedFailedEvent(error));
            }
        });
    }
}
