package com.e.musicvideo_player;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    private final List<MusicVideoModel> Datalist;
    private final itemClickListener itemCLickListener;

    public MyAdapter(List<MusicVideoModel> datalist, itemClickListener itemCLickListener) {
        Datalist = datalist;
        this.itemCLickListener = itemCLickListener;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.judul.setText(Datalist.get(position).getJudul());
        holder.play.setOnClickListener(v -> {
            holder.play.setEnabled(false);
            mediaPlayer = MediaPlayer.create(Datalist.get(position).getContext(), Datalist.get(position).getMusic());
            try {
                mediaPlayer.prepare();
            } catch (IllegalStateException | IOException ex) {
                ex.printStackTrace();
            }
            mediaPlayer.start();
        });
        holder.stop.setOnClickListener(v -> {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            holder.play.setEnabled(true);
            holder.stop.setEnabled(false);
        });
        Glide.with(holder.gambar_music).load(Datalist.get(position)).into(holder.gambar_music);
        holder.itemView.setOnClickListener(v -> itemCLickListener.onItemClick(Datalist.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    public interface itemClickListener {
        void onItemClick(MusicVideoModel musicVideoModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar_music;
        Button play, stop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judullagu);
            gambar_music = itemView.findViewById(R.id.image);
            play = itemView.findViewById(R.id.playbtn);
            stop = itemView.findViewById(R.id.stopbtn);

        }

    }
}
