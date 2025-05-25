package character;

public abstract class Hero extends Character {
    private String heroClass;
    private int experience, expToNextLevel;
    private int mana; // New attribute for mana

    public Hero(String name, int level, int maxHealth, int attackPower, int defensePower, int mana, String heroClass) {
        super(name, level, maxHealth, attackPower, defensePower); // Pass level as 1 to superclass
        this.mana = mana; // Initialize mana
        this.heroClass = heroClass;
        this.experience = 0; // Default experience
        this.expToNextLevel = 25;
    }

    // Getters and Setters

    // class Character definition (add these methods if missing)

    public int getLevel() {
        return this.level;
    }

    public String getHeroClass() {
        return heroClass;
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

    // funções de herói
    public void ganharExperiencia(int exp) {
        this.experience += exp;
        System.out.println(this.name + " ganhou " + exp + " de experiência!");
        // Aqui você pode adicionar lógica de subir de nível, se desejar
    }

    public int atacar() {
        // ataque com chance de crítico
        double chanceCritico = 0.1; // 10%
        if (Math.random() < chanceCritico) {
            System.out.println(this.name + " acertou um ataque crítico!");
            return this.attackPower * 2;
        }
        return this.attackPower;
    }

    @Override
    public int defender() {
        return this.defensePower;
    }

    public void subirNivel() {
        while (this.experience >= this.expToNextLevel) {
            this.experience -= this.expToNextLevel;
            this.level++;
            this.expToNextLevel = (int)(this.expToNextLevel * 1.5);

            // Valores genéricos, podem ser sobrescritos nas subclasses
            this.maxHealth += 10;
            this.attackPower += 2;
            this.defensePower += 2;
            this.mana += 5;

            this.health = this.maxHealth;
            System.out.println("Parabéns! " + this.name + " subiu para o nível " + this.level + "!");
            System.out.println("Atributos aumentados e vida totalmente recuperada!");
        }
    }

    public void penalidadeMorte(int vidaBase, int ataqueBase, int defesaBase, int manaBase) {
        if (this.level > 1) {
            this.level--;
            System.out.println("\n*** Você perdeu 1 nível! Novo nível: " + this.level + " ***");
        } else {
            System.out.println("\n*** Você já está no nível mínimo (1)! ***");
        }

        // Reduz atributos, mas nunca abaixo do valor base/original
        this.maxHealth = Math.max(this.maxHealth - 10, vidaBase);
        this.attackPower = Math.max(this.attackPower - 2, ataqueBase);
        this.defensePower = Math.max(this.defensePower - 2, defesaBase);
        this.mana = Math.max(this.mana - 5, manaBase);

        // Zera experiência acumulada
        this.experience = 0;

        // Recupera vida para o novo máximo
        this.health = this.maxHealth;

        System.out.println("Você perdeu atributos devido à morte, mas não pode ficar abaixo dos valores iniciais.");
        System.out.println("Seus atributos atuais:");
        System.out.println("Vida: " + this.maxHealth +
                           ", Ataque: " + this.attackPower +
                           ", Defesa: " + this.defensePower +
                           ", Mana: " + this.mana);
    }

}