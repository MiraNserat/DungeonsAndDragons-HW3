package units;

public class Health {
    private int healthPool;
    private int healthAmount;

    public Health(int healthPool) {
        this.healthPool = healthPool;
        this.healthAmount = healthPool;
    }

    public int getHealthPool() {
        return healthPool;
    }

    public int getHealthAmount() {
        return healthAmount;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            healthAmount = healthAmount - damage;
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            healthAmount = Math.min(healthAmount + amount, healthPool);
        }
    }

    public void increasePool(int amount) {
        if (amount > 0) {
            healthPool = healthPool + amount;
        }
    }

    public void setHealthAmount(int amount) {
        if (amount < 0) {
            healthAmount = 0;
        } else {
            healthAmount = Math.min(amount, healthPool);
        }
    }

    public void setToFullHealth() {
        healthAmount = healthPool;
    }

    public boolean isDead() {
        return healthAmount <= 0;
    }
}
