package model;

import java.util.ArrayList;
import java.util.List;

public class Artist {
   private String name;
   private List<Song> songs;

   public Artist(String name) {
      this.name = name;
      songs = new ArrayList<>();
   }

   public String getName() {
      return name;
   }

   public List<Song> getSongs() {
      return songs;
   }

   public void addSong(Song song) {
      songs.add(song);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (obj instanceof Artist) {
         Artist other = (Artist) obj;
         return other.getName().equalsIgnoreCase(this.name);
      }
      return false;
   }

   public void printInfo() {
      System.out.printf("%n%s | ", name.toUpperCase());
      if (!songs.isEmpty()) {
         System.out.print("Available songs: \n\n");
         int count = 1;
         for (Song song: songs) {
            System.out.printf("%d)  %s %n%n",
                    count, song.getTitle().toUpperCase());
            count++;
         }
      }
      else {
         System.out.println("No songs added yet.");
      }
   }

   @Override
   public String toString() {
      return String.format("artist: %s %n songs: %s %n", name, songs.toString());
   }
}
