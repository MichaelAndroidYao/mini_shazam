package com.shazam.minishazam;/*
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

import com.shazam.minishazam.response.GetRecentChartsResponse;
import com.shazam.minishazam.service.ShazamService;
import com.shazam.minishazam.service.ShazamServiceApi;
import com.shazam.minishazam.service.ShazamServiceManager;

import retrofit.Callback;

/**
 * Class Description
 *
 * @author michaelakakpo
 * @version 28/08/15.
 */


public class MockShazamService {
// TODO -return mock adapter from base service class
    // [REF: http://makingiants.com/blog/mock-retrofit-service-using-mockrestadapter-and-espresso/]


    public class MockOrderService implements ShazamServiceApi {

        ShazamServiceManager shazamServiceManager;
        ShazamService shazamService;
        private GetRecentChartsResponse getRecentChartsResponse;

        public void mock(GetRecentChartsResponse response){
        //    getRecentChartsResponse = response;

            // Setup MockRestAdapter without delays or possible errors
//            MockRestAdapter mockRestAdapter = MockRestAdapter.from(new RestA());
//            mockRestAdapter.setDelay(0);
//            mockRestAdapter.setErrorPercentage(0);
//            mockRestAdapter.setVariancePercentage(0);

            // Create the mocked service and replace it in
        //    MockOrderService mockOrderService = new MockOrderService();
       //     mockOrderService.getCharts(); = getRecentChartsResponse;

            // Replace the service instance with the mocked one
            // Then every time that the project call Service.getCharts will return what we
            // had in our ShazamService.get() code
        }
        // Retrieve mocks
        @Override
        public void getCharts(Callback<GetRecentChartsResponse> charts) {

        }
    }

}
