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

    private String getUserInput() throws IOException {
        System.out.printf("There are %d songs available. Here are your options: %n",
                            songLibrary.getSongCount());
        for (Map.Entry<String,String> option: menu.entrySet()) {
            System.out.printf("%s - % s", option.getKey(), option.getValue());
        }
        System.out.print("What would you like to do?");
        String userChoice = inputReader.readLine();

        return userChoice.trim().toLowerCase();
    }

}
