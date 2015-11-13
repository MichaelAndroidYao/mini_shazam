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

package com.shazam.minishazam.event;

import com.shazam.minishazam.response.GetRecentChartsResponse;

/**
 * This class represents the event once the Charts have been downloaded to the device
 *
 * @author michaelakakpo
 * @version 16/08/15.
 */
public class ChartsDownloadedEvent {
    // Acknowledgment that the response is received
    private GetRecentChartsResponse mThisMonthsChartsResponse;

    public ChartsDownloadedEvent(GetRecentChartsResponse thisMonthsChartsResponse) {
        mThisMonthsChartsResponse = thisMonthsChartsResponse;
    }

    public GetRecentChartsResponse getThisMonthsChartsResponse() {
        return mThisMonthsChartsResponse;
    }

    public void setThisMonthsChartsResponse(GetRecentChartsResponse mThisMonthsChartsResponse) {
        this.mThisMonthsChartsResponse = mThisMonthsChartsResponse;
    }
}
