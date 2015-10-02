package com.shazam.minishazam;

import android.app.Application;
import android.content.Context;

/**
 * Created by michaelakakpo on 09/06/15.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MyApplication getInstance() {

        return sInstance;
    }

    public static Context getAppContext() {
        // returns the application context
        return sInstance.getApplicationContext();
    }
}

