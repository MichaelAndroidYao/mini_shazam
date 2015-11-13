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

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.shazam.minishazam.ui.ChartDetailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the MainActivity loading the Charts
 * NOTE: Using @ActivityTestRule (by Jake Wharton) is preferred to stop extending 'gross ActivityInstrumentationTestCase2'
 * For this example, just a quick sample test has been included.
 *
 * @author michaelakakpo
 * @version 20/08/15.
 */
@RunWith(AndroidJUnit4.class)
public class ChartDetailActivityTest {

    @Rule
    public ActivityTestRule<ChartDetailActivity> mChartDetailActivityRule =
            new ActivityTestRule<>(ChartDetailActivity.class, true, false);

    @Test
    public void test_demonstrateIntentPrep() {
    }

}
