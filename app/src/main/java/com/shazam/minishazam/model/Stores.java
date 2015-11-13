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
 */
public class Stores extends ShazamObject {

    private Apple apple;
    private Xboxmusic xboxmusic;
    private Itunes itunes;
    private Amazon amazon;
    private Google google;

    public Stores(Apple apple,
                  Xboxmusic xboxmusic,
                  Amazon amazon,
                  Itunes itunes,
                  Google google) {

        this.apple = apple;
        this.xboxmusic = xboxmusic;
        this.amazon = amazon;
        this.itunes = itunes;
        this.google = google;
    }

    /**
     * @return The apple
     */
    public Apple getApple() {
        return apple;
    }

    /**
     * @param apple The apple
     */
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    /**
     * @return The xboxmusic
     */
    public Xboxmusic getXboxmusic() {
        return xboxmusic;
    }

    /**
     * @param xboxmusic The xboxmusic
     */
    public void setXboxmusic(Xboxmusic xboxmusic) {
        this.xboxmusic = xboxmusic;
    }

    /**
     * @return The amazon
     */
    public void setAmazon(Amazon amazon) {
        this.amazon = amazon;
    }

    /**
     * @return The amazon
     */
    public Amazon getAmazon() {
        return amazon;
    }

    /**
     * @return The itunes
     */
    public Itunes getItunes() {
        return itunes;
    }

    /**
     * @param itunes The itunes
     */
    public void setItunes(Itunes itunes) {
        this.itunes = itunes;
    }

    /**
     * @return The google
     */
    public Google getGoogle() {
        return google;
    }

    /**
     * @param google The google
     */
    public void setGoogle(Google google) {
        this.google = google;
    }


}
