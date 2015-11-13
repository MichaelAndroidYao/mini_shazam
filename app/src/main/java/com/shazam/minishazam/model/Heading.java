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

package com.shazam.minishazam.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Chart Heading
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */
public class Heading implements Parcelable {

    private static final long serialVersionUID = 88866757645457L;

    @SerializedName("title")
    @Expose
    private
    String title;
    @SerializedName("subtitle")
    @Expose
    private
    String subtitle;

    public Heading() {
        // No args constructor
    }

    // Packaging up the parcel: only interested in certain fields
    public Heading(Parcel input) {
        title = input.readString();
        subtitle = input.readString();
    }

    public Heading(String title,
                   String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    /**
     * @return The title
     */
    @NonNull
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subtitle);
    }

    /**
     * @inheritDoc
     */
    public static final Parcelable.Creator<Heading> CREATOR
            = new Parcelable.Creator<Heading>() {
        public Heading createFromParcel(Parcel in) {
            return new Heading(in);
        }

        public Heading[] newArray(int size) {
            return new Heading[size];
        }
    };
}
