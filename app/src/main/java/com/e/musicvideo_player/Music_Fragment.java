package com.e.musicvideo_player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Music_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Music_Fragment extends Fragment implements MyAdapter.itemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private final ArrayList<MusicVideoModel> Datalist = new ArrayList<>();
    private Button Play, Stop;
    private MediaPlayer mediaPlayer;

    public Music_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Music_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Music_Fragment newInstance() {
        Music_Fragment fragment = new Music_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_music, container, false);
        ListData();
        AdapterRecyclerview(v);

        return v;
    }

    private void AdapterRecyclerview(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(Datalist, this);
        recyclerView.setAdapter(myAdapter);

    }

    private void ListData() {
        Datalist.add(new MusicVideoModel("Rich Brian - 100 Degrees", R.drawable.degrees, R.raw.richbrian, R.raw.hundreddegress));
        Datalist.add(new MusicVideoModel("Post Malone - Sunflower", R.drawable.sunflower, R.raw.postmalonesunflower, R.raw.sunflower));
        Datalist.add(new MusicVideoModel("BMTH - Follow you", R.drawable.followyou, R.raw.bmth, R.raw.followyou));
    }

    @Override
    public void onItemClick(MusicVideoModel musicVideoModel) {
        Fragment fragment = Video_Fragment.newInstance(musicVideoModel.getVideo());

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment, "video_fragment");

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}