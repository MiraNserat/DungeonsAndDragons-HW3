package players;

import GameBoard.GameBoard;
import GameBoard.Position;
import combat.Combat;
import combat.CombatResult;
import enemies.Enemy;
import java.util.List;
import java.util.Random;


public class Mage extends Player{
    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;
    private Random random;

    public Mage(String name, int healthPool, int attack, int defense, Position position, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange) {
        super(name, healthPool, attack, defense, position);
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
        this.random = new Random();
    }

    public int getManaPool() {
        return manaPool;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public int getAbilityRange() {
        return abilityRange;
    }

    @Override
    public void onGameTick() {
        currentMana = Math.min(manaPool, currentMana + getLevel());
    }

    @Override
    public CombatResult castAbility(GameBoard board, List<Enemy> enemies) {
        if (currentMana < manaCost) {
            CombatResult result = new CombatResult(getName(), getName(), 0, 0, 0, false);
            result.addMessage(getName() + " tried to use Blizzard, but did not have enough mana.");
            return result;
        }

        currentMana = currentMana - manaCost;

        CombatResult finalResult = new CombatResult(getName(), getName(), 0, 0, 0, false);
        finalResult.addMessage(getName() + " used Blizzard.");

        int hits = 0;

        while (hits < hitsCount && hasEnemyInRange(enemies)) {
            Enemy target = randomEnemyInRange(enemies);

            if (target != null) {
                CombatResult hitResult = Combat.abilityAttack(this, target, spellPower);

                for (String message : hitResult.getMessages()) {
                    finalResult.addMessage(message);
                }

                hits = hits + 1;
            }
        }

        return finalResult;
    }

    private boolean hasEnemyInRange(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (!enemy.isDead() && getPosition().range(enemy.getPosition()) < abilityRange) {
                return true;
            }
        }
        return false;
    }

    private Enemy randomEnemyInRange(List<Enemy> enemies) {
        List<Enemy> enemiesInRange = new java.util.ArrayList<>();

        for (Enemy enemy : enemies) {
            if (!enemy.isDead() && getPosition().range(enemy.getPosition()) < abilityRange) {
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
        manaPool = manaPool + 25 * getLevel();
        currentMana = Math.min(currentMana + manaPool / 4, manaPool);
        spellPower = spellPower + 10 * getLevel();
    }

    @Override
    public String description() {
        return super.description() + " Mana: " + currentMana + "/" + manaPool + " Spell Power: " + spellPower;
    }
}
