import model.Song;
import model.SongLibrary;

import java.util.ArrayList;
import java.util.List;

public class Karaoke {
    public static void main(String[] args) {

        // Test creating new song and storing it
        Song mainstreet = new Song("Mainstreet",
                "Bob Seger",
                "https://youtu.be/6X9KNmOvGas");
        // Create new song library
        SongLibrary classicRock = new SongLibrary();

        // Store song
        System.out.printf("Adding %s %n", mainstreet);
        classicRock.addSong(mainstreet);
    }
}
