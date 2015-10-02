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

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Base Class for Refrofit Interface initialisation & building the RetrofitAdapter
 *
 * @author michaelakakpo
 * @version 18/08/15.
 */
abstract class ShazamServiceApiBase {

    // Base URL to set as endpoint for {@link RestAdapter}
    private static final String BASE_URL = "http://cdn.shazam.com/shazam";

    ShazamServiceApi getInterface() {
        return getApiBuilder()
                .build()
                .create(ShazamServiceApi.class);
    }

    private static RestAdapter.Builder getApiBuilder() {

        /* Client used to interface with the REST API. It builds upon the base url */
        return new RestAdapter.Builder()
                /* Logging */
                .setLogLevel(RestAdapter.LogLevel.FULL)
                /* Set the BASE URL for Shazam as the endpoint as interfaces will refer only to relative paths */
                .setEndpoint(BASE_URL)
                /* Use OkHttp Client for better performance */
                .setClient(new OkClient(new OkHttpClient()));
    }
}