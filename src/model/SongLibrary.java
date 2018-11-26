package model;

import java.util.ArrayList;
import java.util.List;

public class SongLibrary {
   private List<Song> songs;
   private List<Artist> artists;

   public SongLibrary() {
      songs = new ArrayList<>();
      artists = new ArrayList<>();
   }

   public void addSong(Song song) {
      songs.add(song);
      song.getArtist().addSong(song);
      artists.add(song.getArtist());
   }

   public int getSongCount() {
      return songs.size();
   }

   public List<Artist> getArtists() {
      return artists;
   }

   public List<Song> getSongsForArtist(Artist artist) {
      return artist.getSongs();
   }

   public void displaySongsByArtist() {
      artists.forEach(System.out::println);
   }
}
