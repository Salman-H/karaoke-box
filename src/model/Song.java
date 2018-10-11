package model;

public class Song {

    private String title;
    private String artist;
    private String videoUrl;

    public Song(String title, String artist, String videoUrl) {
        this.title = title;
        this.artist = artist;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    @Override
    public String toString() {
        return String.format("Song: %s by %s", title, artist);
    }
}
