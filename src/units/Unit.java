package units;
import GameBoard.Position;

public abstract class Unit implements Occupant {
    private String name;
    private Health health;
    private int attack;
    private int defense;
    private Position position;
    private char tile;

    public Unit(String name, int healthPool, int attack, int defense, Position position, char tile) {
        this.name = name;
        this.health = new Health(healthPool);
        this.attack = attack;
        this.defense = defense;
        this.position = position;
        this.tile = tile;
    }

    public String getName() {
        return name;
    }

    public Health getHealth() {
        return health;
    }

    public int getHealthPool() {
        return health.getHealthPool();
    }

    public int getHealthAmount() {
        return health.getHealthAmount();
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public char getTile() {
        return tile;
    }

    public void takeDamage(int damage) {
        health.takeDamage(damage);
    }

    public void heal(int amount) {
        health.heal(amount);
    }

    public boolean isDead() {
        return health.isDead();
    }

    protected void increaseAttack(int amount) {
        if (amount > 0) {
            attack = attack + amount;
        }
    }

    protected void increaseDefense(int amount) {
        if (amount > 0) {
            defense = defense + amount;
        }
    }

    protected void increaseHealthPool(int amount) {
        health.increasePool(amount);
    }

    protected void setHealthToFull() {
        health.setToFullHealth();
    }

    public void onGameTick() {
    }

    public String description() {
        return name +
                " Health: " + health.getHealthAmount() + "/" + health.getHealthPool() +
                " Attack: " + attack +
                " Defense: " + defense;
    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }

}
