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
 */ // Streams
public class Streams extends ShazamObject {

    private Applemusicradio applemusicradio;
    private Deezer deezer;
    private Rhapsody rhapsody;
    private Rdio rdio;
    private Spotify spotify;

    public Streams(Applemusicradio applemusicradio,
                   Deezer deezer,
                   Rhapsody rhapsody,
                   Rdio rdio,
                   Spotify spotify) {
        this.applemusicradio = applemusicradio;
        this.deezer = deezer;
        this.rhapsody = rhapsody;
        this.rdio = rdio;
        this.spotify = spotify;
    }

    /**
     * @return The applemusicradio
     */
    public Applemusicradio getApplemusicradio() {
        return applemusicradio;
    }

    /**
     * @param applemusicradio The applemusicradio
     */
    public void setApplemusicradio(Applemusicradio applemusicradio) {
        this.applemusicradio = applemusicradio;
    }

    /**
     * @return The deezer
     */
    public Deezer getDeezer() {
        return deezer;
    }

    /**
     * @param deezer The deezer
     */
    public void setDeezer(Deezer deezer) {
        this.deezer = deezer;
    }

    /**
     * @return The rhapsody
     */
    public Rhapsody getRhapsody() {
        return rhapsody;
    }

    /**
     * @param rhapsody The rhapsody
     */
    public void setRhapsody(Rhapsody rhapsody) {
        this.rhapsody = rhapsody;
    }

    /**
     * @return The rdio
     */
    public Rdio getRdio() {
        return rdio;
    }

    /**
     * @param rdio The rdio
     */
    public void setRdio(Rdio rdio) {
        this.rdio = rdio;
    }

    /**
     * @return The spotify
     */
    public Spotify getSpotify() {
        return spotify;
    }

    /**
     * @param spotify The spotify
     */
    public void setSpotify(Spotify spotify) {
        this.spotify = spotify;
    }

}
