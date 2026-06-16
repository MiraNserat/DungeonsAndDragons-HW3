package players;
import GameBoard.GameBoard;
import GameBoard.Position;
import combat.Combat;
import combat.CombatResult;
import enemies.Enemy;
import java.util.List;

public class Rogue extends Player{
    private int cost;
    private int currentEnergy;

    public Rogue(String name, int healthPool, int attack, int defense, Position position, int cost) {
        super(name, healthPool, attack, defense, position);
        this.cost = cost;
        this.currentEnergy = 100;
    }

    public int getCost() {
        return cost;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public void onGameTick() {
        currentEnergy = Math.min(currentEnergy + 10, 100);
    }

    @Override
    public CombatResult castAbility(GameBoard board, List<Enemy> enemies) {
        if (currentEnergy < cost) {
            CombatResult result = new CombatResult(getName(), getName(), 0, 0, 0, false);
            result.addMessage(getName() + " tried to use Fan of Knives, but did not have enough energy.");
            return result;
        }
        currentEnergy = currentEnergy - cost;
        CombatResult finalResult = new CombatResult(getName(), getName(), 0, 0, 0, false);
        finalResult.addMessage(getName() + " used Fan of Knives.");

        for (Enemy enemy : enemies) {
            if (!enemy.isDead() && getPosition().range(enemy.getPosition()) < 2) {
                CombatResult hitResult = Combat.abilityAttack(this, enemy, getAttack());
                for (String message : hitResult.getMessages()) {
                    finalResult.addMessage(message);
                }
            }
        }
        return finalResult;
    }

    @Override
    protected void levelUp() {
        super.levelUp();

        currentEnergy = 100;
        increaseAttack(3 * getLevel());
    }

    @Override
    public String description() {
        return super.description() + " Energy: " + currentEnergy + "/100";
    }
}
