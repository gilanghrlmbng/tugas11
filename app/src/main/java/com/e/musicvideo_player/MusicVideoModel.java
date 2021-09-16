package com.e.musicvideo_player;

import android.content.Context;

public class MusicVideoModel {

    private String judul;
    private int images;
    private int video;
    private int music;
    private Context context;

    public MusicVideoModel(String judul, int images, int video, int music) {
        this.judul = judul;
        this.images = images;
        this.video = video;
        this.music = music;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }


}
