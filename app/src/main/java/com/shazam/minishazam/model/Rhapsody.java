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
import java.util.List;

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 13/08/15.
 */
// Rhapsody
public class Rhapsody {

    private List<Action> actions = new ArrayList<>();

    public Rhapsody(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * @return The actions
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     * @param actions The actions
     */
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public static class Action {

        private String name;
        private String type;
        private String uri;

        public Action(
                String type,
                String uri) {
            this.type = type;
            this.uri = uri;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
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