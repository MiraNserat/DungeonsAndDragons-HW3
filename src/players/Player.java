package players;
import GameBoard.GameBoard;
import GameBoard.Position;
import combat.CombatResult;
import enemies.Enemy;
import units.Unit;
import java.util.List;
import GameBoard.OccupantVisitor;

public abstract  class Player extends Unit {
    private int experience;
    private int level;

    public Player(String name, int healthPool, int attack, int defense, Position position) {
        super(name, healthPool, attack, defense, position, '@');
        this.experience = 0;
        this.level = 1;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public void gainExperience(int xp) {
        experience = experience + xp;

        while (experience >= 50 * level) {
            levelUp();
        }
    }

    protected void levelUp() {
        experience = experience - 50 * level;
        level = level + 1;

        increaseHealthPool(10 * level);
        setHealthToFull();
        increaseAttack(4 * level);
        increaseDefense(level);
    }

    public abstract CombatResult castAbility(GameBoard board, List<Enemy> enemies);

    @Override
    public String description() {
        return super.description() + " Level: " + level + " Experience: " + experience + "/" + (50 * level);
    }
    @Override
    public void accept(OccupantVisitor visitor) {
        visitor.visit(this);
    }
}
