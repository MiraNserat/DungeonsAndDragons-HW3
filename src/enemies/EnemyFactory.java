package enemies;
import GameBoard.Position;

public class EnemyFactory {
    public static Enemy createEnemy(char tile, Position position) {

        // Monsters
        if (tile == 's') {
            return new Monster("Gold Cloak", 80, 8, 3, position, 's', 25, 3);
        }

        else if (tile == 'k') {
            return new Monster("Knight", 200, 14, 8, position, 'k', 50, 4);
        }

        else if (tile == 'q') {
            return new Monster("Queen's Guard", 400, 20, 15, position, 'q', 100, 5);
        }

        else if (tile == 'z') {
            return new Monster("Wright", 600, 30, 15, position, 'z', 100, 3);
        }

        else if (tile == 'b') {
            return new Monster("Bear", 1000, 75, 30, position, 'b', 250, 4);
        }

        else if (tile == 'g') {
            return new Monster("Giant", 1500, 100, 40, position, 'g', 500, 5);
        }

        else if (tile == 'w') {
            return new Monster("White Walker", 2000, 150, 50, position, 'w', 1000, 6);
        }

        else if (tile == 'M') {
            return new Monster("The Mountain", 1000, 60, 25, position, 'M', 500, 6);
        }

        else if (tile == 'C') {
            return new Monster("Queen Cersei", 100, 10, 10, position, 'C', 1000, 1);
        }

        else if (tile == 'K') {
            return new Monster("Night's King", 5000, 300, 150, position, 'K', 5000, 8);
        }

        // Traps
        else if (tile == 'B') {
            return new Trap("Bonus Trap", 1, 1, 1, position, 'B', 250, 1, 5);
        }

        else if (tile == 'Q') {
            return new Trap("Queen's Trap", 250, 50, 10, position, 'Q', 100, 3, 7);
        }

        else if (tile == 'D') {
            return new Trap("Death Trap", 500, 100, 20, position, 'D', 250, 1, 10);
        }

        else {
            throw new IllegalArgumentException("Unknown enemy tile: " + tile);
        }
    }
}
