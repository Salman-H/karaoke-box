package model;

import java.util.ArrayList;
import java.util.List;

public class SongLibrary {
    private List<Song> songs;

    public SongLibrary() {
        songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public int getSongCount() {
        return songs.size();
    }
}
