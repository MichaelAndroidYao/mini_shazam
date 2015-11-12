package com.shazam.minishazam.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shazam.minishazam.R;
import com.shazam.minishazam.model.Chart;

/**
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * <p/>
 * The Media player portion of the {@link NowPlayingActivity}
 */
public class NowPlayingMediaPlayerFragment extends Fragment {

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
