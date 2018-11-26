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
    public String toString() {
        return String.format("Song: %s by %s", title, artist.getName());
    }
}
