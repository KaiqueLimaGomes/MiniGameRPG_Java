package character;

public class Mage extends Hero {

    public Mage(String name) {
        super(name, 1, 80, 13, 5, 100, "Mago"); // vida, ataque, defesa, mana, classe

    }

    @Override
    public void subirNivel() {
        while (this.getExperience() >= this.getExpToNextLevel()) {
            this.setExperience(this.getExperience() - this.getExpToNextLevel());
            this.setLevel(this.getLevel() + 1);
            this.setExpToNextLevel((int) Math.ceil(this.getExpToNextLevel() * 1.5));

            // Mago ganha mais vida e ataque
            this.setMaxHealth(this.getMaxHealth() + 1);
            this.setAttackPower(this.getAttackPower() + 3);
            this.setDefensePower(this.getDefensePower() + 1);
            this.setMana(this.getMana() + 5);

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
