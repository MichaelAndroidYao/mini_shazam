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

package com.shazam.minishazam.service;

import com.shazam.minishazam.response.GetRecentChartsResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * The interface used to make calls on the {@link retrofit.RestAdapter.Builder}
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */
public interface ShazamServiceApi {

    // Get the charts for the past month
    @GET("/v2/en/GB/android/-/chart/recent-music/1month/-/-.json")
    void getCharts(Callback<GetRecentChartsResponse> charts);

}