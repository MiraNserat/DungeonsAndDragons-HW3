package enemies;
import GameBoard.GameBoard;
import GameBoard.Position;
import combat.Combat;
import combat.CombatResult;
import players.Player;

public class Trap extends Enemy{
    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;

    public Trap(String name, int healthPool, int attack, int defense, Position position, char tile, int experienceValue, int visibilityTime, int invisibilityTime) {
        super(name, healthPool, attack, defense, position, tile, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
    }

    public int getVisibilityTime() {
        return visibilityTime;
    }

    public int getInvisibilityTime() {
        return invisibilityTime;
    }

    public int getTicksCount() {
        return ticksCount;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public CombatResult onEnemyTurn(GameBoard board, Player player) {
        visible = ticksCount < visibilityTime;

        if (ticksCount == visibilityTime + invisibilityTime) {
            ticksCount = 0;
        } else {
            ticksCount = ticksCount + 1;
        }

        if (getPosition().range(player.getPosition()) < 2) {
            return Combat.attack(this, player);
        }

        return null;
    }

    @Override
    public String toString() {
        if (visible) {
            return String.valueOf(getTile());
        } else {
            return ".";
        }
    }

    @Override
    public String description() {
        return super.description() + " Visibility Time: " + visibilityTime + " Invisibility Time: " + invisibilityTime + " Ticks Count: " + ticksCount + " Visible: " + visible;
    }
}
