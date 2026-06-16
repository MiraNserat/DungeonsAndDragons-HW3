package enemies;
import GameBoard.GameBoard;
import GameBoard.Position;
import combat.CombatResult;
import players.Player;
import units.Unit;

public abstract class Enemy extends Unit{
    private int experienceValue;

    public Enemy(String name, int healthPool, int attack, int defense, Position position, char tile, int experienceValue) {
        super(name, healthPool, attack, defense, position, tile);
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public abstract CombatResult onEnemyTurn(GameBoard board, Player player);

    @Override
    public String description() {
        return super.description() +
                " Experience Value: " + experienceValue;
    }
}
