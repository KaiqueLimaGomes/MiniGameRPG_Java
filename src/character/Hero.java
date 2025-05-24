package character;

public abstract class Hero extends Character {
    private String heroClass;
    private int level, experience, expToNextLevel; 
    private int mana; // New attribute for mana

    public Hero(String name,int maxHealth, int attackPower, int defensePower , int mana, String heroClass) {
        super(name, maxHealth, attackPower, defensePower);
        this.mana = mana; // Initialize mana
        this.heroClass = heroClass;
        this.level = 1; // Default level
        this.experience = 0; // Default experience
        this.expToNextLevel = 25;
    }


    // Getters and Setters
    public String getHeroClass() {
        return heroClass;
    }
    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }
    public int getExpToNextLevel() {
        return expToNextLevel;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setExpToNextLevel(int expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }
}