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
package com.shazam.minishazam.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shazam.minishazam.model.Chart;

import java.util.List;

/**
 * List of Chart items from Shazam server response will contain {@link Chart}
 *
 * @author michaelakakpo
 * @version 16/08/15.
 */
public class GetRecentChartsResponse {

    @SerializedName("chart")
    @Expose
    private
    List<Chart> chart;

    @Override
    public String toString() {
        return "chart:[{" +
                "]";
    }

    // Return a list of the items in the chart
    public List<Chart> getChartsResponse() {
        return chart;
    }
}

