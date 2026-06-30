package combat;
import java.util.ArrayList;
import java.util.List;

public class CombatResult {
    private String attackerName;
    private String defenderName;
    private int attackRoll;
    private int defenseRoll;
    private int damage;
    private boolean defenderDied;
    private List<String> messages;

    public CombatResult(String attackerName, String defenderName, int attackRoll, int defenseRoll, int damage, boolean defenderDied) {
        this.attackerName = attackerName;
        this.defenderName = defenderName;
        this.attackRoll = attackRoll;
        this.defenseRoll = defenseRoll;
        this.damage = damage;
        this.defenderDied = defenderDied;
        this.messages = new ArrayList<>();
    }

    public String getAttackerName() {
        return attackerName;
    }

    public String getDefenderName() {
        return defenderName;
    }

    public int getAttackRoll() {
        return attackRoll;
    }

    public int getDefenseRoll() {
        return defenseRoll;
    }

    public int getDamage() {
        return damage;
    }

    public boolean defenderDied() {
        return defenderDied;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
