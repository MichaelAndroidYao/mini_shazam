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
package com.shazam.minishazam.ui;

import android.app.ProgressDialog;

import com.shazam.minishazam.event.HideDialogEvent;
import com.shazam.minishazam.event.ShowDialogEvent;

import de.greenrobot.event.EventBus;

/**
 * Base class for all events to be registered and unregistered
 *
 * @author michaelakakpo
 * @version 16/08/15.
 */
public class EventBaseActivity extends BaseActivity {

    private ProgressDialog mLoading;

    // Register/unregister for events from the EventBus common to all activities

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    void onEvent(ShowDialogEvent event) {
        mLoading = ProgressDialog.show(this, "Loading", "loading...", true);
    }

    void onEvent(HideDialogEvent event) {
        if (mLoading == null) {
            return;
        }
        mLoading.dismiss();
        mLoading = null;
    }
}
