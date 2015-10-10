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

package com.shazam.minishazam;

import android.os.Parcel;
import android.os.Parcelable;

import com.shazam.minishazam.model.Chart;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains up to date list of Chart list for the month
 *
 * @author michaelakakpo
 * @version 1/10/15
 */
public class ChartManager implements Parcelable {

    private List<Chart> mCharts = new ArrayList<>();

    public ChartManager() {
        // no args empty contructor
    }

    // Packaging up the parcel: only interested in certain fields
    public ChartManager(Parcel input) {
        mCharts = input.readArrayList(Chart.class.getClassLoader());
    }

    public List<Chart> getCharts() {
        return mCharts;
    }

    public void setCharts(List<Chart> mCharts) {
        this.mCharts = mCharts;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(mCharts);
    }

    /**
     * @inheritDoc
     */
    public static final Parcelable.Creator<ChartManager> CREATOR
            = new Parcelable.Creator<ChartManager>() {
        public ChartManager createFromParcel(Parcel in) {

            return new ChartManager(in);
        }

        public ChartManager[] newArray(int size) {
            return new ChartManager[size];
        }
    };
}
