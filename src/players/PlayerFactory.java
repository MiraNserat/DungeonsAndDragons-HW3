package players;
import GameBoard.Position;
import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {
    public static List<Player> createPlayers(Position position) {
        List<Player> players = new ArrayList<>();

        players.add(new Warrior("Jon Snow", 300, 30, 4, position, 3));
        players.add(new Warrior("The Hound", 400, 20, 6, position, 5));
        players.add(new Mage("Melisandre", 100, 5, 1, position, 300, 30, 15, 5, 6));
        players.add(new Mage("Thoros of Myr", 250, 25, 4, position, 150, 20, 20, 3, 4));
        players.add(new Rogue("Arya Stark", 150, 40, 2, position, 20));
        players.add(new Rogue("Bronn", 250, 35, 3, position, 50));

        return players;
    }

    public static Player createPlayer(int index, Position position) {
        List<Player> players = createPlayers(position);
        if (index < 0 || index >= players.size()) {
            throw new IllegalArgumentException("Invalid player index");
        }
        return players.get(index);
    }
}
