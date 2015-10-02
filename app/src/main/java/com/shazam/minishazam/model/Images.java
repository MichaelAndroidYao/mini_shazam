package com.shazam.minishazam.model;/*
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

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */
public class Images implements Parcelable {

    private static final long serialVersionUID = 98866757645457L;

    @SerializedName("default")
    @Expose
    private String _default;

    public Images(String _default) {
        this._default = _default;
    }

    // Packaging up the parcel: only interested in certain fields
    public Images(Parcel input) {
        _default = input.readString();
    }

    /**
     * @return The _default
     */
    public String getDefault() {
        return _default;
    }

    /**
     * @param _default The default
     */
    public void setDefault(String _default) {
        this._default = _default;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_default);
    }

    /**
     * @inheritDoc
     */
    public static final Parcelable.Creator<Images> CREATOR
            = new Parcelable.Creator<Images>() {
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        public Images[] newArray(int size) {
            return new Images[size];
        }
    };
}
