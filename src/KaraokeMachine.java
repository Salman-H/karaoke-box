import model.Artist;
import model.Song;
import model.SongLibrary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;


public class KaraokeMachine {
   private SongLibrary songLibrary;
   private BufferedReader inputReader;
   private Map<String,String> menu;
   private Queue<Song> songQueue;

   public KaraokeMachine(SongLibrary songLibrary) {
      this.songLibrary = songLibrary;
      inputReader = new BufferedReader(new InputStreamReader(System.in));
      menu = new HashMap<String,String>();
      menu.put("add   ", "Add new song to library");
      menu.put("choose", "Choose a song to queue");
      menu.put("play  ", "Play next song in the queue");
      menu.put("quit  ", "Exit program");
      /*
       * prohibits null elements and faster than LinkedList
       * https://stackoverflow.com/questions/6129805/what-is-the-fastest-java-collection-with-the-basic-functionality-of-a-queue
       */
      songQueue = new ArrayDeque<>();
   }

   public void run() {
      String choice = "";
      do {
         try {
            choice = getUserInput();
            Song song = null;
            switch (choice) {
               case "add":
                  song = promptNewSong();
                  songLibrary.addSong(song);
                  break;
               case "choose":
                  song = promptSongSelection();
                  songQueue.add(song);
                  System.out.printf("%nYou chose: %s %n", song);
               case "play":
                  playNextSong();
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
      System.out.printf("%nThere are %d songs available in the song library " +
                        "and %d songs currently queued." +
                        " Here are your options: %n%n",
                        songLibrary.getSongCount(),
                        songQueue.size());

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

   private Song promptSongSelection() throws IOException {
      songLibrary.printArtists();
      System.out.print("Select artist number: ");
      String artistNumberAsString = inputReader.readLine().trim();
      int artistNumber = Integer.parseInt(artistNumberAsString);

      Artist artist = songLibrary.getArtists().get(artistNumber-1);
      artist.printInfo();
      System.out.print("Select song number: ");
      String songNumberAsString = inputReader.readLine().trim();
      int songNumber = Integer.parseInt(songNumberAsString);

      return songLibrary.getSongs().get(songNumber-1);
   }

   private void playNextSong() {
      Song nextSong = songQueue.poll();
      if (nextSong != null) {
         System.out.printf("%n%n Open %s to hear %s by %s %n%n",
                           nextSong.getVideoUrl(),
                           nextSong.getTitle(),
                           nextSong.getArtist().getName());
      }
      else {
         System.out.println("No songs in the queue." +
                            " Choose songs from the menu to queue.");
      }
   }

}
