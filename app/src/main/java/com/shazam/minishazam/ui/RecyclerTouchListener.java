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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * {@link GestureDetector} TouchListener for intercepting touch events on the RecyclerView
 * It allows the children in the view hierarchy to independently decide
 * how they will intercept the events correctly.
 */
class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    // Gesture detector
    private final GestureDetector gestureDetector;
    private final ClickListener mClickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.mClickListener = clickListener;

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            /**
             * @inheritDoc
             */
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            /**
             * @inheritDoc
             */
            @Override
            public void onLongPress(MotionEvent e) {
                // Get the X and Y coordinates of the child view that was clicked
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && mClickListener != null) {
                    mClickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());

        if (child != null && mClickListener != null && gestureDetector.onTouchEvent(e)) {
            mClickListener.onClick(child, rv.getChildAdapterPosition(child));
        }

        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}

/**
 * The click and long press listener for when items in the chart are selected
 */
interface ClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}