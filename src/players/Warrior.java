package players;

import GameBoard.GameBoard;
import GameBoard.Position;
import combat.Combat;
import combat.CombatResult;
import enemies.Enemy;
import java.util.List;
import java.util.Random;


public class Warrior extends Player{
    private int abilityCooldown;
    private int remainingCooldown;
    private Random random;

    public Warrior(String name, int healthPool, int attack, int defense, Position position, int abilityCooldown) {
        super(name, healthPool, attack, defense, position);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
        this.random = new Random();
    }

    public int getAbilityCooldown() {
        return abilityCooldown;
    }

    public int getRemainingCooldown() {
        return remainingCooldown;
    }

    @Override
    public void onGameTick() {
        if (remainingCooldown > 0) {
            remainingCooldown = remainingCooldown - 1;
        }
    }

    @Override
    public CombatResult castAbility(GameBoard board, List<Enemy> enemies) {
        if (remainingCooldown > 0) {
            CombatResult result = new CombatResult(getName(), getName(), 0, 0, 0, false);
            result.addMessage(getName() + " tried to use Avenger's Shield but ability is on cooldown.");
            return result;
        }
        Enemy target = randomEnemyInRange(enemies);
        if (target == null) {
            CombatResult result = new CombatResult(getName(), getName(), 0, 0, 0, false);
            result.addMessage(getName() + " tried to use Avenger's Shield, but there were no enemies in range.");
            return result;
        }
        remainingCooldown = abilityCooldown;
        int damage = getHealthPool() / 10;
        heal(10 * getDefense());
        CombatResult result = Combat.abilityAttack(this, target, damage);
        result.addMessage(getName() + " used Avenger's Shield.");
        return result;
    }


    private Enemy randomEnemyInRange(List<Enemy> enemies) {
        List<Enemy> enemiesInRange = new java.util.ArrayList<>();
        for (Enemy enemy : enemies) {
            if (!enemy.isDead() && getPosition().range(enemy.getPosition()) < 3) {
                enemiesInRange.add(enemy);
            }
        }
        if (enemiesInRange.isEmpty()) {
            return null;
        }
        int index = random.nextInt(enemiesInRange.size());
        return enemiesInRange.get(index);
    }

    @Override
    protected void levelUp() {
        super.levelUp();
        remainingCooldown = 0;
        increaseHealthPool(5 * getLevel());
        increaseAttack(2 * getLevel());
        increaseDefense(getLevel());
    }

    @Override
    public String description() {
        return super.description() + " Cooldown: " + remainingCooldown + "/" + abilityCooldown;
    }
}
