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

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */ // Artists
public class Artists extends ShazamObject {

    private Follow follow;
    private String id;

    public Artists(
            Follow follow,
            String id) {
        this.follow = follow;
        this.id = id;
    }


    /**
     * @return The follow
     */
    public Follow getFollow() {
        return follow;
    }

    /**
     * @param follow The follow
     */
    public void setFollow(Follow follow) {
        this.follow = follow;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    // Follow
    public static class Follow {

        private String followkey;

        public Follow(
                String followKey) {
            this.followkey = followKey;
        }

        /**
         * @return The followkey
         */
        public String getFollowkey() {
            return followkey;
        }

        /**
         * @param followkey The followkey
         */
        public void setFollowkey(String followkey) {
            this.followkey = followkey;
        }

    }

}
