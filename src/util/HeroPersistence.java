package util;

import character.Hero;
import character.Mage;
import character.Warrior;
import character.Archer;
import java.io.*;
import java.util.Scanner;

public class HeroPersistence {

    public static void salvar(Hero hero) throws IOException {
        try (FileWriter writer = new FileWriter("personagem.txt")) {
            writer.write(hero.getHeroClass() + "\n");
            writer.write(hero.getName() + "\n");
            writer.write(hero.getMaxHealth() + "\n");
            writer.write(hero.getHealth() + "\n");
            writer.write(hero.getAttackPower() + "\n");
            writer.write(hero.getDefensePower() + "\n");
            writer.write(hero.getMana() + "\n");
            writer.write(hero.getLevel() + "\n");
            writer.write(hero.getExperience() + "\n");
            writer.write(hero.getExpToNextLevel() + "\n");
        }
    }

    public static Hero carregar() throws IOException {
        try (Scanner fileScanner = new Scanner(new File("personagem.txt"))) {
            String classe = fileScanner.nextLine();
            String nome = fileScanner.nextLine();
            int vidaMax = Integer.parseInt(fileScanner.nextLine());
            int vida = Integer.parseInt(fileScanner.nextLine());
            int ataque = Integer.parseInt(fileScanner.nextLine());
            int defesa = Integer.parseInt(fileScanner.nextLine());
            int mana = Integer.parseInt(fileScanner.nextLine());
            int nivel = Integer.parseInt(fileScanner.nextLine());
            int experiencia = Integer.parseInt(fileScanner.nextLine());
            int expProxNivel = Integer.parseInt(fileScanner.nextLine());

            Hero hero;
            switch (classe) {
                case "Mago":
                    hero = new Mage(nome);
                    break;
                case "Guerreiro":
                    hero = new Warrior(nome);
                    break;
                case "Arqueiro":
                    hero = new Archer(nome);
                    break;
                default:
                    throw new IOException("Classe desconhecida.");
            }

            hero.setMaxHealth(vidaMax);
            hero.setHealth(vida);
            hero.setAttackPower(ataque);
            hero.setDefensePower(defesa);
            hero.setMana(mana);
            hero.setLevel(nivel);
            hero.setExperience(experiencia);
            hero.setExpToNextLevel(expProxNivel);

            return hero;
        }
    }
}
