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

import com.google.gson.annotations.SerializedName;

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */
public class Urlparams extends ShazamObject {

    @SerializedName("{tracktitle}")
    private String Tracktitle;
    @SerializedName("{trackartist}")
    private String Trackartist;


    Urlparams(String Tracktitle, String Trackartist) {
        this.Tracktitle = Tracktitle;
        this.Trackartist = Trackartist;
    }

    /**
     * @return The Tracktitle
     */
    public String getTracktitle() {
        return Tracktitle;
    }

    /**
     * @param Tracktitle The {tracktitle}
     */
    public void setTracktitle(String Tracktitle) {
        this.Tracktitle = Tracktitle;
    }

    /**
     * @return The Trackartist
     */
    public String getTrackartist() {
        return Trackartist;
    }

    /**
     * @param Trackartist The {trackartist}
     */
    public void setTrackartist(String Trackartist) {
        this.Trackartist = Trackartist;
    }

}
