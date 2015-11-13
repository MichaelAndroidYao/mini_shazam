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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Displays details of the Chart item
 *
 * @author michaelakakpo
 * @version 20/08/15.
 */
public class ChartDetailActivity extends AppCompatActivity {

    @InjectView(R.id.img_item_track_cover)

    ImageView mTrackCover;
    @InjectView(R.id.txt_item_title)
    TextView mTrackTitle;
    @InjectView(R.id.txt_item_artist)
    TextView mTrackArtist;

    private static final String sCURRENT_TRACK = "current_track";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        ButterKnife.inject(this);

        Chart currentChart = getIntent().getParcelableExtra(sCURRENT_TRACK);

        mTrackTitle.setText(currentChart.getHeading().getTitle());
        mTrackArtist.setText(currentChart.getHeading().getSubtitle());

          /* Load the Chart cover art asynchronously, process the image on the fly and apply to the View holder */
        Picasso.with(this)
                .load(currentChart.getImages().getDefault())
                .resize(256, 256)
                .centerCrop()
                .noPlaceholder()
                .noFade()
//                .error(R.drawable.ic_launcher_fab48)
                .into(mTrackCover);
    }
}
