import model.Artist;
import model.Song;
import model.SongLibrary;

import java.io.BufferedReader;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class KaraokeMachine {
   private SongLibrary songLibrary;
   private BufferedReader inputReader;
   private Map<String,String> menu;

   public KaraokeMachine(SongLibrary songLibrary) {
      this.songLibrary = songLibrary;
      inputReader = new BufferedReader(new InputStreamReader(System.in));
      menu = new HashMap<String,String>();
      menu.put("add", "Add new song to library");
      menu.put("quit", "Exit program");
   }

   public void run() {
      String choice = "";
      do {
         try {
            choice = getUserInput();
            switch (choice) {
               case "add":
                  Song song = promptNewSong();
                  songLibrary.addSong(song);
                  break;
               case "quit":
                  System.out.println("Thanks for singing!");
                  break;
               default:
                  System.out.printf("Choice not recognized: %s. " +
                                    "Try again. %n%n%n", choice);
            }
         }
         catch(IOException ioe) {
            System.out.println("Problem with input!");
            ioe.printStackTrace();
         }
      }
      while (!choice.equalsIgnoreCase("quit"));
   }

   private String getUserInput() throws IOException {
      System.out.printf("%nThere are %d songs available. " +
                        "Here are your options: %n%n",
                        songLibrary.getSongCount());

      for (Map.Entry<String,String> option: menu.entrySet()) {
         System.out.printf("%s - %s %n", option.getKey(), option.getValue());
      }
      System.out.print("\nWhat would you like to do?  ");
      String userChoice = inputReader.readLine();
      return userChoice.trim().toLowerCase();
   }

   private Song promptNewSong() throws IOException {
      System.out.print("\nEnter the artist's name: ");
      String artist = inputReader.readLine().trim().toLowerCase();
      System.out.print("Enter the title: ");
      String title = inputReader.readLine().trim().toLowerCase();
      System.out.print("Enter the video URL: ");
      String videoURL = inputReader.readLine().trim().toLowerCase();
      /* Do not create a new Artist instance if artist of
       * this song already exists in the song library */
      return new Song(title.toUpperCase(),
                      songLibrary.getArtist(artist),
                      videoURL);
   }

}
