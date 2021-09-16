package com.e.musicvideo_player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Video_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Video_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private VideoView videoView;
    private MediaController mediaController;
    private Button playVideo;
    private String mParam1;

    public Video_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Video_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Video_Fragment newInstance(int param1) {
        Video_Fragment fragment = new Video_Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        videoView = v.findViewById(R.id.video);
        playVideo = v.findViewById(R.id.btnplayvideo);
        mediaController = new MediaController(getActivity());
        playVideo.setOnClickListener(v1 -> {
            videoView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + mParam1);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
            //Menjalankan Video
            videoView.start();
        });
        return v;
    }
}