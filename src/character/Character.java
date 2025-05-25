package character;

public abstract class Character {
    protected String name;
    protected int health, maxHealth;
    protected int attackPower;
    protected int defensePower;
    protected int level;
    protected int mana;

    public Character(String name, int level, int maxHealth, int attackPower, int defensePower) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth; // Default max health
        this.health = maxHealth; // Initialize health to maxHealth
        this.attackPower = attackPower; // Default attack power
        this.defensePower = defensePower; // Default defense power
    }

    // Getters and Setters
    public String getName() {
        return this.name;
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

    public int getLevel() {
        return this.level;
    }

    public int getMana(){
        return this.mana;
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

    public abstract int defender();

    // funções de personagem
    public void receberDano(int dano) {
        int defesa = this.defender();
        int danoFinal = dano - defesa;

        if (danoFinal <= 0) {
            danoFinal = 0;
            System.out.println("O ataque foi nulo! " + this.name + " não sofreu dano." + " Dano: " + danoFinal);
        } else if (danoFinal < defesa) {
            System.out.println("O ataque foi pouco efetivo contra " + this.name + "!" + " Dano: " + danoFinal);
        } else if (danoFinal > defesa * 2) {
            System.out.println("O ataque foi super efetivo em " + this.name + "!" + " Dano: " + danoFinal);
        } else {
            System.out.println(this.name + " recebeu " + danoFinal + " de dano.");
        }

        this.health -= danoFinal;
        if (this.health < 0)
            this.health = 0;
    }

    public int atacar() {
        // Retorna o valor de ataque padrão do personagem
        return this.attackPower;
    }
}
