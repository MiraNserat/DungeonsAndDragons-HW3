package GameManager;
import java.util.*;
import GameBoard.*;
import enemies.EnemyFactory;
import players.Player;
import players.PlayerFactory;
import units.Occupant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Loader {

    public GameBoard LoadLevel(int levelNumber, Player player) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get
                ("levels_dir", "level" + levelNumber + ".txt"));

        if(lines.isEmpty())
            throw new IllegalArgumentException("The file is empty");

        int rows = lines.size();
        int cols = lines.get(0).length();
        Cell[][] gameTiles = new Cell[rows][cols];

        for(int i = 0; i < rows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < cols; j++) {
                char c = line.charAt(j);
                Position p = new Position(i, j);

                if(c == '#')
                    gameTiles[i][j] = new Wall(p);
                else{
                    Floor floor = new Floor(p);
                    Occupant occ = null;
                    if(c != '.' ) {
                        if (c == '@')
                            occ = player;
                        else {
                            EnemyFactory enemy = new EnemyFactory();
                            occ = enemy.createEnemy(c, p);
                        }
                    }
                    floor.setOccupant(occ);
                    gameTiles[i][j] = floor;
                }


            }
        }

        return new GameBoard(gameTiles);

    }
}
