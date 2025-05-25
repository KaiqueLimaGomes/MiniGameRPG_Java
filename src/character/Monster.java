package character;

import java.util.Random;

public class Monster extends Character {

    public Monster(String name, int level, int health, int attack, int defense) {
        super(name, level, health, attack, defense);
        // Não precisa inicializar atributos duplicados!
    }

    public static Monster gerarMonstroAleatorio(int nivelArea) {
        Random rand = new Random();
        String[] nomes;
        int minLevel, maxLevel;

        switch (nivelArea) {
            case 1:
                nomes = new String[]{"Slime", "Lobo", "Goblin", "Rato Gigante"};
                minLevel = 1; maxLevel = 20;
                break;
            case 2:
                nomes = new String[]{"Goblin", "Esqueleto", "Bandido", "Morcego"};
                minLevel = 21; maxLevel = 40;
                break;
            case 3:
                nomes = new String[]{"Orc", "Zumbi", "Bandido", "Esqueleto"};
                minLevel = 41; maxLevel = 60;
                break;
            case 4:
                nomes = new String[]{"Orc", "Troll", "Bandido", "Minotauro"};
                minLevel = 61; maxLevel = 80;
                break;
            case 5:
                nomes = new String[]{"Dragão", "Esqueleto Ancião", "Gigante", "Demônio"};
                minLevel = 81; maxLevel = 100;
                break;
            default:
                nomes = new String[]{"Slime"};
                minLevel = 1; maxLevel = 10;
        }

        String nome = nomes[rand.nextInt(nomes.length)];
        int level = minLevel + rand.nextInt(maxLevel - minLevel + 1);
        int health = 30 + level * 3 + rand.nextInt(20);
        int attack = 5 + level / 2 + rand.nextInt(5);
        int defense = 2 + level / 5 + rand.nextInt(4);

        return new Monster(nome, level, health, attack, defense);
    }

    @Override
    public int defender() {
        return this.defensePower;
    }
}
