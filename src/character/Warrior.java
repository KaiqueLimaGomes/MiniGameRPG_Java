package character;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 120, 10, 5, 50, "Guerreiro"); // vida, ataque, defesa, mana, classe
    }

    /*@Override
    public int useSkill() {
        if (getMana() >= 15) {
            setMana(getMana() - 15);
            int damage = getAttackPower() + 20;
            System.out.println(getName() + " usou um golpe poderoso! Dano: " + damage);
            return damage;
        } else {
            System.out.println(getName() + " está sem mana!");
            return 0;
        }
    }*/
    
}
