/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;
import com.squareup.picasso.Picasso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * Displays a single row in the list of songs in the {@link MainActivity}
 * <p/>
 * Utilises the {@link Picasso} library for the loading of images into the ImageView.
 *
 * @author Michael Akakpo
 * @version 2015.06.20
 */
public class TrackRecyclerAdapter extends RecyclerView.Adapter<TrackRecyclerAdapter.MyViewHolder> {

    private static final Logger LOG_TAG = LoggerFactory.getLogger(TrackRecyclerAdapter.class);
    private LayoutInflater mInflater;
    private List<Chart> mData = Collections.emptyList();
    private Context mContext;

    private TrackRecyclerAdapter() {
        // No args constructor
    }

    public TrackRecyclerAdapter(Context context, List<Chart> chartsFromManager) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mData = chartsFromManager;
    }

    /**
     * inheritDoc
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LOG_TAG.info("onCreateViewHolder: ");

        View view = mInflater.inflate(R.layout.recycler_track_item, parent, false);

        return new MyViewHolder(view);
    }

    /**
     * ViewHolder image set using Picasso library.
     * All image processing handled by the chained static methods in the Picasso library.
     *
     * NOTE: could have used Glide Library (better caching and more flexible and customisable API)
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LOG_TAG.info("onBindViewHolder(), item Position: {} ", position);
        Chart current = mData.get(position);
        holder.getTitle().setText(current.getHeading().getTitle());
        holder.getArtist().setText(current.getHeading().getSubtitle());

         /* Load the Chart cover art asynchronously, process the image on the fly and apply to the View holder */
        Picasso.with(mContext)
                .load(current.getImages().getDefault())
                .resize(256, 256) // TODO - Use the default params not hardcoded fields
                .centerCrop()
                .noPlaceholder()
                .noFade()
//                .error(R.drawable.ic_launcher_fab48) // TODO - find img for placeholder & for error
                .tag(holder)
                .into(holder.getCover());
    }

    /**
     * inheritDoc
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public List<Chart> getCharts() {
        return mData;
    }

    /* Add the items from the updated chart to the list and notify any observers and refresh the changes */
    public void addItemsToList(List<Chart> restoredCharts) {
        if (restoredCharts != null) {
            mData.clear();
            mData.addAll(restoredCharts);
            notifyDataSetChanged();
        }
    }

    /**
     * ViewHolder representing chart item
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView artist;
        final TextView title;
        final ImageView cover;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txt_item_title);
            artist = (TextView) itemView.findViewById(R.id.txt_item_artist);
            cover = (ImageView) itemView.findViewById(R.id.img_item_track_cover);
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getArtist() {
            return artist;
        }

        public ImageView getCover() {
            return cover;
        }

    }

}
