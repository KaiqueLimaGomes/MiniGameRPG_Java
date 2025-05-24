
package character;
public class Mage extends Hero {

    public Mage(String name) {
        super(name, 80, 8, 3, 100, "Mago"); // vida, ataque, defesa, mana, classe

    }

    /*@Override
    public int useSkill() {
        if (mana >= 20) {
            mana -= 20;
            int damage = attack + 25;
            System.out.println(name + " lançou uma bola de fogo! Dano: " + damage);
            return damage;
        } else {
            System.out.println(name + " está sem mana!");
            return 0;
        }
    }*/
}
