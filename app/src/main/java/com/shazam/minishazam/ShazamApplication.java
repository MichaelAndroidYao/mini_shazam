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

package com.shazam.minishazam;

import android.app.Application;
import android.content.Context;

import com.shazam.minishazam.inject.MyShazamModule;

import dagger.ObjectGraph;

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 16/08/15.
 */
public class ShazamApplication extends Application {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(new MyShazamModule(this));
    }

    // 1. The bridge between the injected dependencies and the Object graph created from them
    /*@Component(modules = MyShazamModule.class)*/


    // 2. Define abstract method implementation of the component
  /*   public interface ShazamComponent {

        ShazamService getShazamService();
           ShazamServiceManager getShazamServiceManager()

        // This will generate an implementation e.g.

    }*/

    // 3. Building the component & consume component generated by Dagger.
        /* ShazamComponent component = Dagger_ShazamComponent.builder()
            .module([name of module])
            .build();
       ShazamService mShazamService = component.mShazamService()
       ShazamServiceManager mShazamServiceManager mShazamServiceManager()=
        */

    public static ShazamApplication get(Context context) {
        return (ShazamApplication) context.getApplicationContext();
    }

    public final void inject(Object object) {
        mObjectGraph.inject(object);
    }
}
