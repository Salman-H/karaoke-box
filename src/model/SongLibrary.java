package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongLibrary {
   private List<Song> songs;
   private List<Artist> artists;
   private Map<String, Artist> artistMap;

   public SongLibrary() {
      songs = new ArrayList<>();
      artists = new ArrayList<>();
      artistMap = new HashMap<>();
   }

   public List<Song> getSongs() {
      return songs;
   }

   public void addSong(Song song) {
      if (!songs.contains(song)) {
         songs.add(song);
         Artist artist = song.getArtist();
         if (!artist.getSongs().contains(song)) artist.addSong(song);
         if (!artists.contains(artist)) artists.add(artist);
         System.out.printf("%n%s added! %n%n", song);
      }
      else System.out.printf("%n%s is already in library! %n%n", song);
   }

   public int getSongCount() {
      return songs.size();
   }

   public List<Artist> getArtists() {
      return artists;
   }

   /* Returns specified artist from library or creates a new one if artist
    * with that name doesn't exist */
   public Artist getArtist(String name) {
      if (!artistMap.containsKey(name.toLowerCase())) {
         artistMap.put(name.toLowerCase(), new Artist(name));
      }
      return artistMap.get(name.toLowerCase());
   }

   public void printArtists() {
      if (!artists.isEmpty()) {
         System.out.print("\nAvailable artists: \n\n");
         int count = 1;
         for (Artist artist: artists) {
            System.out.printf("%d)  %s %n",
                    count, artist.getName().toUpperCase());
            count++;
         }
      }
      else {
         System.out.println("None added.");
      }
   }

   public List<Song> getSongsForArtist(Artist artist) {
      return artist.getSongs();
   }

   public void displaySongsByArtist() {
      artists.forEach(System.out::println);
   }
}
