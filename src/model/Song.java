package model;

public class Song {
   private String title;
   private Artist artist;
   private String videoUrl;

   public Song(String title, Artist artist, String videoUrl) {
      this.title = title;
      this.artist = artist;
      this.videoUrl = videoUrl;
   }

   public String getTitle() {
      return title;
   }

   public Artist getArtist() {
      return artist;
   }

   public String getVideoUrl() {
      return videoUrl;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (obj instanceof Song) {
         // songs same only if both their titles and artist names are same
         Song otherSong = (Song) obj;
         return otherSong.getTitle().equalsIgnoreCase(this.title) &&
                otherSong.getArtist().getName().equalsIgnoreCase(this.artist.getName());
      }
      return false;
   }

   @Override
   public String toString() {
      return String.format("Song: %s by %s", title.toUpperCase(),
              artist.getName().toUpperCase());
   }
}
