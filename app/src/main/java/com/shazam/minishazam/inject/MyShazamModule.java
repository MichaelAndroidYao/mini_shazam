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

package com.shazam.minishazam.inject;

import android.os.Parcel;

import com.shazam.minishazam.ChartManager;
import com.shazam.minishazam.ShazamApplication;
import com.shazam.minishazam.service.ShazamService;
import com.shazam.minishazam.service.ShazamServiceManager;
import com.shazam.minishazam.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * My Application
 *
 * @author michaelakakpo
 * @version 16/08/15.
 */
@Module(injects = {
        MainActivity.class,
}, complete = true)
public class MyShazamModule {

    private final ShazamApplication mShazamApplication;

    // Access to the Application
    public MyShazamModule(ShazamApplication shazamApplication) {
        mShazamApplication = shazamApplication;
    }

    // Shazam Service
    @Provides
    public ShazamService provideShazamService() {
        return new ShazamService();
    }

    // Shazam ServiceManager
    @Provides
    public ShazamServiceManager provideShazamServiceManager(ShazamService service, ChartManager chartManager) {
        return new ShazamServiceManager(service, chartManager);
    }

    // Chart Manager
    @Provides
    @Singleton
    public ChartManager provideChartManager() {
        return new ChartManager(Parcel.obtain());
    }
}
