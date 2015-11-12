package com.shazam.minishazam.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;

/**
 * Activities displays the item being currently played
 */
public class NowPlayingActivity extends AppCompatActivity {

    static final String LOG_TAG = NowPlayingActivity.class.getSimpleName();

    private static final String sCURRENT_TRACK = "current_track";

    /**
     * @inheritDoc
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Log.v(LOG_TAG, "onCreate");

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_view_music_toolbar);
        setSupportActionBar(toolbar);

        // Retrieve the current selected track for playing
        Chart currentChart = getIntent().getParcelableExtra(sCURRENT_TRACK);

        // Initialise the fragments
        Fragment mNowPlayingAlbumCoverFragment = NowPlayingAlbumCoverFragment.newInstance(currentChart);
        Fragment mNowPlayingAlbumDetailsFragment = NowPlayingAlbumDetailsFragment.newInstance(currentChart);
        Fragment mNowPlayingMediaPlayerFragment = NowPlayingMediaPlayerFragment.newInstance(currentChart);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_now_playing_album_cover, mNowPlayingAlbumCoverFragment);
        fragmentTransaction.replace(R.id.fl_now_playing_album_details, mNowPlayingAlbumDetailsFragment);
        fragmentTransaction.replace(R.id.fl_now_playing_media_player, mNowPlayingMediaPlayerFragment);
        fragmentTransaction.commit();
    }
}
