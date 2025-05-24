package character;

public abstract class Character {
    protected String name;
    protected int health , maxHealth;
    protected int attackPower;
    protected int defensePower;

    public Character(String name, int maxHealth, int attackPower, int defensePower) {
        this.name = name;
        this.maxHealth = maxHealth; // Default max health
        this.health = maxHealth; // Initialize health to maxHealth
        this.attackPower = attackPower; // Default attack power
        this.defensePower = defensePower; // Default defense power
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public int getDefensePower() {
        return defensePower;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    
    

}
