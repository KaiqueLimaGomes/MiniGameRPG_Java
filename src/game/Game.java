package game;

import java.util.Scanner;
import character.Mage;
import character.Warrior;
import character.Archer;
import character.Hero;
import util.HeroPersistence; // Import HeroPersistence for loading/saving hero
import java.io.File; // Import File for file operations
import java.io.IOException;

public class Game {
    private static final Scanner scanner = new Scanner(System.in); // Scanner global

    // Método para iniciar o jogo
    public void start() {
        Hero player;
        File saveFile = new File("personagem.txt");

        if (saveFile.exists()) {
            // Tenta carregar o personagem salvo
            try {
                player = HeroPersistence.carregar();
                System.out.println("Bem-vindo de volta, " + player.getName() + "!");
            } catch (IOException e) {
                player = selecionarPersonagem();
                try {
                    HeroPersistence.salvar(player);
                } catch (IOException ex) {
                    System.out.println("Erro ao salvar personagem: " + ex.getMessage());
                }
            }
        } else {
            // Se não existe arquivo salvo, cria novo personagem
            player = selecionarPersonagem();
            try {
                HeroPersistence.salvar(player);
                System.out.println("-----------------------");
                System.out.println("Personagem salvo com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao salvar personagem: " + e.getMessage());
            }
        }

        System.out.println("----------------------");
        System.out.println("Vamos iniciar sua aventura Grande " + player.getHeroClass() + " " + player.getName() + "!");
        System.out.println("Você está pronto para enfrentar os desafios que virão pela frente.");
        // Continue o jogo...
        // scanner.close(); // Só feche no final do programa, se desejar
    }

    // Metodo para entrar com nome do jogador e escolher o personagem
    public static Hero selecionarPersonagem() {
        System.out.print("Digite o nome do seu Herói: ");
        String nomeJogador = scanner.nextLine();

        while (true) {
            System.out.println(nomeJogador + ", escolha a classe do seu personagem:");
            System.out.println("1. Mago");
            System.out.println("2. Guerreiro");
            System.out.println("3. Arqueiro");
            System.out.print("Digite o número da classe escolhida: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            System.out.println("----------------------");

            switch (choice) {
                case 1:
                    Mage mage = new Mage(nomeJogador);
                    System.out.println("Parabéns " + nomeJogador + ", você escolheu a classe Mago para o seu Herói. " +
                            "\nOs atributos iniciais são:\n" +
                            "Vida: " + mage.getMaxHealth() +
                            ", Ataque: " + mage.getAttackPower() +
                            ", Defesa: " + mage.getDefensePower() +
                            ", Mana: " + mage.getMana());
                    return mage;
                case 2:
                    Warrior warrior = new Warrior(nomeJogador);
                    System.out.println(
                            "Parabéns " + nomeJogador + ", você escolheu a classe Guerreiro para o seu Herói. " +
                                    "\nOs atributos iniciais são:\n" +
                                    "Vida: " + warrior.getMaxHealth() +
                                    ", Ataque: " + warrior.getAttackPower() +
                                    ", Defesa: " + warrior.getDefensePower() +
                                    ", Mana: " + warrior.getMana());
                    return warrior;
                case 3:
                    Archer archer = new Archer(nomeJogador);
                    System.out.println(
                            "Parabéns " + nomeJogador + ", você escolheu a classe Arqueiro para o seu Herói. " +
                                    "\nOs atributos iniciais são:\n" +
                                    "Vida: " + archer.getMaxHealth() +
                                    ", Ataque: " + archer.getAttackPower() +
                                    ", Defesa: " + archer.getDefensePower() +
                                    ", Mana: " + archer.getMana());
                    return archer;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
