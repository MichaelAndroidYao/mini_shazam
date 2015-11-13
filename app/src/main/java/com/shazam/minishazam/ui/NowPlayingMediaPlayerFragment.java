package com.shazam.minishazam.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;

/**
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * <p/>
 * The Media player portion of the {@link NowPlayingActivity}
 */
public class NowPlayingMediaPlayerFragment extends Fragment implements View.OnClickListener {

    // The selectedChart item
    private static final String sCURRENT_TRACK = "current_track";

    private Chart mSelectedChart;

    private OnFragmentInteractionListener mListener;

    /**
     * Factory method to create a new instance of this fragment
     *
     * @param nowPlayingItem - currently selected item to be played
     * @return A new instance of the fragment
     */
    public static Fragment newInstance(Chart nowPlayingItem) {
        NowPlayingMediaPlayerFragment fragment = new NowPlayingMediaPlayerFragment();
        Bundle args = new Bundle();
        args.putParcelable(sCURRENT_TRACK, nowPlayingItem);
        fragment.setArguments(args);
        return fragment;
    }

    public NowPlayingMediaPlayerFragment() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_now_playing_media_player, container, false);

        ImageView btnRepeat = (ImageView) rootView.findViewById(R.id.img_now_playing_repeat);
        btnRepeat.setOnClickListener(this);
        btnRepeat.setTag("repeat");

        ImageView btnFastRewind = (ImageView) rootView.findViewById(R.id.img_now_playing_fast_rewind);
        btnFastRewind.setOnClickListener(this);
        btnFastRewind.setTag("fast_rewind");

        ImageView btnPlay = (ImageView) rootView.findViewById(R.id.img_now_playing_play);
        btnPlay.setOnClickListener(this);
        btnPlay.setTag("play");

        ImageView btnFastForward = (ImageView) rootView.findViewById(R.id.img_now_playing_fast_forward);
        btnFastForward.setOnClickListener(this);
        btnFastForward.setTag("fast_forward");

        ImageView btnShuffle = (ImageView) rootView.findViewById(R.id.img_now_playing_shuffle);
        btnShuffle.setOnClickListener(this);
        btnShuffle.setTag("shuffle");

        return rootView;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Buttons of the media player
    @Override
    public void onClick(View v) {

        String viewTag = v.getTag().toString();
        switch (viewTag) {

            case "repeat":
                Toast.makeText(getActivity(), "Touched: " + viewTag, Toast.LENGTH_LONG).show();

                break;
            case "fast_rewind":
                Toast.makeText(getActivity(), "Touched: " + viewTag, Toast.LENGTH_LONG).show();

                break;
            case "play":
                Toast.makeText(getActivity(), "Touched: " + viewTag, Toast.LENGTH_LONG).show();

                break;
            case "fast_forward":
                Toast.makeText(getActivity(), "Touched: " + viewTag, Toast.LENGTH_LONG).show();

                break;
            case "shuffle":
                Toast.makeText(getActivity(), "Touched: " + viewTag, Toast.LENGTH_LONG).show();

                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void NowPlayingAlbumCoverFragment(Uri uri);
    }

}
