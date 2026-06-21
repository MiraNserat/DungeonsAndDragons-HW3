import players.*;

import java.util.ArrayList;
import java.util.List;

public class CLI {
    public void Start(){

        // print the player menu

    }

    private void SelectPlayer(){

        System.out.println("Select a player from the menu");

        List<Player> players = new ArrayList<>();
        players.add(new Warrior());
        players.add(new Rogue());
        players.add(new Mage());

        for(int i = 0; i < players.size(); i++){

        }
    }
}
