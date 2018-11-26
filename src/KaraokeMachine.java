import model.Artist;
import model.Song;
import model.SongLibrary;

import java.io.BufferedReader;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.IOException;
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
                  System.out.printf("%s added! %n%n", song);
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
      System.out.printf("There are %d songs available. " +
                        "Here are your options: %n",
                        songLibrary.getSongCount());
      for (Map.Entry<String,String> option: menu.entrySet()) {
         System.out.printf("%s - %s %n", option.getKey(), option.getValue());
      }
      System.out.print("What would you like to do?  ");
      String userChoice = inputReader.readLine();
      return userChoice.trim().toLowerCase();
   }

   private Song promptNewSong() throws IOException {
      System.out.print("Enter the artist's name: ");
      String artist = inputReader.readLine();
      System.out.print("Enter the title: ");
      String title = inputReader.readLine();
      System.out.print("Enter the video URL: ");
      String videoURL = inputReader.readLine();
      return new Song(title, new Artist(artist), videoURL);
   }

}
