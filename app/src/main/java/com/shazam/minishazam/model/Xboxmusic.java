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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */
@Generated("org.jsonschema2pojo")
public class Xboxmusic {

    private List<Action> actions = new ArrayList<Action>();
    private String previewurl;
    private String coverarturl;
    private String trackid;
    private String productid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The actions
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     *
     * @param actions
     * The actions
     */
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     *
     * @return
     * The previewurl
     */
    public String getPreviewurl() {
        return previewurl;
    }

    /**
     *
     * @param previewurl
     * The previewurl
     */
    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl;
    }

    /**
     *
     * @return
     * The coverarturl
     */
    public String getCoverarturl() {
        return coverarturl;
    }

    /**
     *
     * @param coverarturl
     * The coverarturl
     */
    public void setCoverarturl(String coverarturl) {
        this.coverarturl = coverarturl;
    }

    /**
     *
     * @return
     * The trackid
     */
    public String getTrackid() {
        return trackid;
    }

    /**
     *
     * @param trackid
     * The trackid
     */
    public void setTrackid(String trackid) {
        this.trackid = trackid;
    }

    /**
     *
     * @return
     * The productid
     */
    public String getProductid() {
        return productid;
    }

    /**
     *
     * @param productid
     * The productid
     */
    public void setProductid(String productid) {
        this.productid = productid;
    }


    class Action {

        private String type;
        private String uri;

        Action(
                String type,
                String uri) {
            this.type = type;
            this.uri = uri;
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
         * @return The uri
         */
        public String getUri() {
            return uri;
        }

        /**
         * @param uri The uri
         */
        public void setUri(String uri) {
            this.uri = uri;
        }
    }



}
