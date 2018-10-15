import model.SongLibrary;

import java.io.BufferedReader;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.Map;


public class KaraokeMachine {
    private SongLibrary songLibrary;
    private BufferedReader userInput;
    private Map<String,String> menu;

    public KaraokeMachine(SongLibrary songLibrary) {
        this.songLibrary = songLibrary;
        userInput = new BufferedReader(new InputStreamReader(System.in));
        menu = new HashMap<String,String>();
    }
}
