package character;

public abstract class Hero extends Character {
    private String heroClass;
    private int level;
    private int experience;

    public Hero(String name, String heroClass) {
        super(name);
        this.heroClass = heroClass;
        this.level = 1; // Default level
        this.experience = 0; // Default experience
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
    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
}