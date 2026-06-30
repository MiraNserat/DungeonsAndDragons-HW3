package enemies;
import GameBoard.GameBoard;
import GameBoard.Position;
import combat.CombatResult;
import players.Player;
import java.util.Random;

public class Monster extends Enemy {
    private int visionRange;
    private Random random;

    public Monster(String name, int healthPool, int attack, int defense, Position position, char tile, int experienceValue, int visionRange) {
        super(name, healthPool, attack, defense, position, tile, experienceValue);
        this.visionRange = visionRange;
        this.random = new Random();
    }

    public int getVisionRange() {
        return visionRange;
    }

    @Override
    public CombatResult onEnemyTurn(GameBoard board, Player player) {
        Position targetPosition;

        if (getPosition().range(player.getPosition()) < visionRange) {
            targetPosition = chasePlayer(player);
        } else {
            targetPosition = randomMove();
        }

        board.moveUnit(this, targetPosition);

        return null;
    }

    private Position chasePlayer(Player player) {
        int dx = getPosition().getX() - player.getPosition().getX();
        int dy = getPosition().getY() - player.getPosition().getY();

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                return new Position(getPosition().getX() - 1, getPosition().getY());
            } else {
                return new Position(getPosition().getX() + 1, getPosition().getY());
            }
        } else {
            if (dy > 0) {
                return new Position(getPosition().getX(), getPosition().getY() - 1);
            } else {
                return new Position(getPosition().getX(), getPosition().getY() + 1);
            }
        }
    }

    private Position randomMove() {
        int move = random.nextInt(5);

        if (move == 0) {
            return new Position(getPosition().getX() - 1, getPosition().getY());
        } else if (move == 1) {
            return new Position(getPosition().getX() + 1, getPosition().getY());
        } else if (move == 2) {
            return new Position(getPosition().getX(), getPosition().getY() - 1);
        } else if (move == 3) {
            return new Position(getPosition().getX(), getPosition().getY() + 1);
        } else {
            return getPosition();
        }
    }

    @Override
    public String description() {
        return super.description() + " Vision Range: " + visionRange;
    }
}
