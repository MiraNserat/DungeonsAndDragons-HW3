import players.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    public void Start(){

        // print the player menu

    }

    private void SelectPlayer(){

        System.out.println("Select a player from the menu");

        List<Player> players = new ArrayList<>();

        for(int i = 0; i < players.size(); i++){

        }

        Scanner player = new Scanner(System.in);
        int index = player.nextInt();
        PlayerFactory createPlayer = new PlayerFactory();
        createPlayer.
    }
}
