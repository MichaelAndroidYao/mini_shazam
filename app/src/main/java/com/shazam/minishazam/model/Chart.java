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

package com.shazam.minishazam.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")

/** Chart POJO representing the Chart items to be displayed in the list.
 * It is composed of the other POJOs to represent the JSON response from the server
 *
 * @author michaelakakpo
 */

public class Chart implements Parcelable {

    private static final long serialVersionUID = 78866757645457L;

    private static final Logger LOG_TAG = LoggerFactory.getLogger(Chart.class);

    @SerializedName("type")
    private String type;
    @SerializedName("key")
    private String key;
    @SerializedName("heading")
    @Expose
    private Heading heading;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("stores")
    private Stores stores;
    @SerializedName("streams")
    private Streams streams;
    @SerializedName("artists")
    private Artists[] artists;
    @SerializedName("share")
    private Share share;
    @SerializedName("urlparams")
    private Urlparams urlparams;

    public Chart() {
        // Empty constructor
    }

    // Packaging up the parcel: only interested in certain fields
    public Chart(Parcel input) {
        heading = input.readParcelable(Heading.class.getClassLoader());
        images = input.readParcelable(Images.class.getClassLoader());
    }

    public Chart(String type,
                 String key,
                 Heading heading,
                 Images images,
                 Stores stores,
                 Streams streams,
                 Artists[] artists,
                 Share share,
                 Urlparams urlparams) {
        this.type = type;
        this.key = key;
        this.heading = heading;
        this.images = images;
        this.stores = stores;
        this.streams = streams;
        this.artists = artists;
        this.share = share;
        this.urlparams = urlparams;

    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return The heading
     */
    public Heading getHeading() {
        return heading;
    }

    /**
     * @param heading The heading
     */
    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    /**
     * @return The images
     */
    public Images getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     * @return The stores
     */
    public Stores getStores() {
        return stores;
    }

    /**
     * @param stores The stores
     */
    public void setStores(Stores stores) {
        this.stores = stores;
    }

    /**
     * @return The streams
     */
    public Streams getStreams() {
        return streams;
    }

    /**
     * @param streams The streams
     */
    public void setStreams(Streams streams) {
        this.streams = streams;
    }

    /**
     * @return The artists
     */
    public Artists[] getArtists() {
        return artists;
    }

    /**
     * @param artists The artists
     */
    public void setArtists(Artists[] artists) {
        this.artists = artists;
    }

    /**
     * @return The share
     */
    public Share getShare() {
        return share;
    }

    /**
     * @param share The share
     */
    public void setShare(Share share) {
        this.share = share;
    }

    /**
     * @return The urlparams
     */
    public Urlparams getUrlparams() {
        return urlparams;
    }

    /**
     * @param urlparams The urlparams
     */
    public void setUrlparams(Urlparams urlparams) {
        this.urlparams = urlparams;
    }

    @Override
    public String toString() {
        return "chart:[{" +
                "heading" + heading +
                "images" + images +
                "]";
    }

    /**
     * @inheritDoc
     */
    @Override
    public int describeContents() {
        LOG_TAG.info("Describe contents: ");
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        LOG_TAG.info("Write to parcel: ");
        dest.writeParcelable(heading, flags);
        dest.writeParcelable(images, flags);
    }

    /**
     * @inheritDoc
     */
    public static final Parcelable.Creator<Chart> CREATOR
            = new Parcelable.Creator<Chart>() {
        public Chart createFromParcel(Parcel in) {

            LOG_TAG.info("create for parcel: Chart");
            return new Chart(in);
        }

        public Chart[] newArray(int size) {
            return new Chart[size];
        }
    };
}





















