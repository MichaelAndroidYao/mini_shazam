package com.shazam.minishazam.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;


/**
 * The album cover for the {@link NowPlayingActivity}
 *
 * @author michaelakakpo
 * @version 09/11/15.
 */
public class NowPlayingAlbumDetailsFragment extends Fragment {

    // The selectedChart item
    private static final String sCURRENT_TRACK = "current_track";

    private Chart mSelectedChart;

    /**
     * Factory method to create a new instance of this fragment
     *
     * @param nowPlayingItem - currently selected item to be played
     * @return A new instance of the fragment
     */
    public static Fragment newInstance(Chart nowPlayingItem) {
        NowPlayingAlbumDetailsFragment fragment = new NowPlayingAlbumDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(sCURRENT_TRACK, nowPlayingItem);
        fragment.setArguments(args);
        return fragment;
    }

    public NowPlayingAlbumDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mSelectedChart = getArguments().getParcelable(sCURRENT_TRACK);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_now_playing_album_details, container, false);

        TextView trackTitle = (TextView) rootView.findViewById(R.id.txt_now_playing_track_title);
        TextView trackArtist = (TextView) rootView.findViewById(R.id.txt_now_playing_album_artist);

        // Retrieve the relevant fields from the {@link NowPlayingActivity} Activity
        String title = this.mSelectedChart.getHeading().getTitle();
        String artist = this.mSelectedChart.getHeading().getSubtitle();

        // Set the details views accordingly
        trackTitle.setSelected(true);
        trackTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        trackTitle.setSingleLine(true);
        trackTitle.setText(title);
        trackArtist.setText(artist);

        return rootView;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }

}