/* Copyright (C) 2013 The Android Open Source Project
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
package com.shazam.minishazam.event;

import retrofit.RetrofitError;

/**
 * This class represents the event if the service/Retrofit attempted to
 * download the Shazam Charts but was unsuccessful.
 * <p/>
 * Allows for Error handling
 *
 * @author michaelakakpo
 */

public class ChartsDownloadedFailedEvent {
    private final RetrofitError mRefrofitResponseError;

    public ChartsDownloadedFailedEvent(RetrofitError error) {
        mRefrofitResponseError = error;
    }

    public RetrofitError getResponseError() {
        return mRefrofitResponseError;
    }
}
