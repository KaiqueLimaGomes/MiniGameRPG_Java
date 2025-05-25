package character;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 1, 120, 10, 5, 50, "Guerreiro");
    }

    @Override
    public void subirNivel() {
        while (this.getExperience() >= this.getExpToNextLevel()) {
            this.setExperience(this.getExperience() - this.getExpToNextLevel());
            this.setLevel(this.getLevel() + 1);
            this.setExpToNextLevel((int) Math.ceil(this.getExpToNextLevel() * 1.5));

            // Guerreiro ganha mais vida e ataque
            this.setMaxHealth(this.getMaxHealth() + 15);
            this.setAttackPower(this.getAttackPower() + 4);
            this.setDefensePower(this.getDefensePower() + 3);
            this.setMana(this.getMana() + 2);

            this.setHealth(this.getMaxHealth());
            System.out.println("Parabéns! " + this.getName() + " subiu para o nível " + this.getLevel() + "!");
            System.out.println("Atributos de Guerreiro aumentados e vida totalmente recuperada!");
            System.out.println("Esses são seus atributos atuais: " +
                    "\nVida: " + this.getMaxHealth() +
                    ", Ataque: " + this.getAttackPower() +
                    ", Defesa: " + this.getDefensePower() +
                    ", Mana: " + this.getMana());
        }
    }
}
