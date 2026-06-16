package combat;
import units.Unit;
import java.util.Random;

public class Combat {
    private static final Random random = new Random();

    public static CombatResult attack(Unit attacker, Unit defender) {
        int attackRoll = roll(attacker.getAttack());
        int defenseRoll = roll(defender.getDefense());
        int damage = Math.max(attackRoll - defenseRoll, 0);
        defender.takeDamage(damage);
        CombatResult result = new CombatResult(attacker.getName(), defender.getName(), attackRoll, defenseRoll, damage, defender.isDead());
        result.addMessage(attacker.getName() + " engaged in combat with " + defender.getName() + ".");
        result.addMessage(attacker.getName() + " rolled " + attackRoll + " attack points.");
        result.addMessage(defender.getName() + " rolled " + defenseRoll + " defense points.");
        if (damage > 0) {
            result.addMessage(defender.getName() + " took " + damage + " damage.");
        } else {
            result.addMessage(defender.getName() + " blocked the attack.");
        }
        if (defender.isDead()) {
            result.addMessage(defender.getName() + " died.");
        }
        return result;
    }


    public static CombatResult abilityAttack(Unit attacker, Unit defender, int damage) {
        int defenseRoll = roll(defender.getDefense());
        int finalDamage = Math.max(damage - defenseRoll, 0);
        defender.takeDamage(finalDamage);
        CombatResult result = new CombatResult(attacker.getName(), defender.getName(), damage, defenseRoll, finalDamage, defender.isDead());
        result.addMessage(attacker.getName() + " used an ability on " + defender.getName() + ".");
        result.addMessage(attacker.getName() + " dealt " + damage + " ability damage.");
        result.addMessage(defender.getName() + " rolled " + defenseRoll + " defense points.");
        if (finalDamage > 0) {
            result.addMessage(defender.getName() + " took " + finalDamage + " damage.");
        } else {
            result.addMessage(defender.getName() + " blocked the ability.");
        }
        if (defender.isDead()) {
            result.addMessage(defender.getName() + " died.");
        }
        return result;
    }


    public static int roll(int max) {
        return random.nextInt(max + 1);
    }
}
