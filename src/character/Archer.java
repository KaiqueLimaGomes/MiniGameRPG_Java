package character;

public class Archer extends Hero {
    public Archer(String name) {
        super(name, 90, 10, 2, 80, "Arqueiro"); // vida, ataque, defesa, mana, classe
    }

    /*@Override
    public int useSkill() {
        if (getMana() >= 15) {
            setMana(getMana() - 15);
            int damage = getAttackPower() + 20;
            System.out.println(getName() + " disparou uma flecha mágica! Dano: " + damage);
            return damage;
        } else {
            System.out.println(getName() + " está sem mana!");
            return 0;
        }
    }*/
    
}
