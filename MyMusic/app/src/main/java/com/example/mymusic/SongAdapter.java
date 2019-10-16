package com.example.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    private int resourceId;

    public SongAdapter(Context context, int resource, List<Song> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NotNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song song = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView songName = (TextView)view.findViewById(R.id.song_name);
        TextView albumName = (TextView)view.findViewById(R.id.album_name);
        songName.setText(song.getSongName());
        albumName.setText(song.getAlbumName());
        return view;
    }
}
