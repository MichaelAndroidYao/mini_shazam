package com.shazam.minishazam.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;
import com.squareup.picasso.Picasso;


/**
 * The album cover for the {@link NowPlayingActivity}
 */
public class NowPlayingAlbumCoverFragment extends Fragment {
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
        NowPlayingAlbumCoverFragment fragment = new NowPlayingAlbumCoverFragment();
        Bundle args = new Bundle();
        args.putParcelable(sCURRENT_TRACK, nowPlayingItem);
        fragment.setArguments(args);
        return fragment;
    }

    public NowPlayingAlbumCoverFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_now_playing_album_cover, container, false);

        // Album cover
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img_album_cover);

        // Retrieve the album cover from the {@link ViewMusicActivity} activity
        String albumCover = mSelectedChart.getImages().getDefault();

        Picasso.with(getActivity())
                .load(albumCover)
                .noPlaceholder()
                .noFade()
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Touched the album cover", Toast.LENGTH_LONG).show();
            }
        });

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
