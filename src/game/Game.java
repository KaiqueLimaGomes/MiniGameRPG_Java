package game;

import java.util.Scanner;
import character.Mage;
import character.Hero;

public class Game {
    private static final Scanner scanner = new Scanner(System.in); // Scanner global

    public void start() {
        Hero player = selecionarPersonagem();
        System.out.println("----------------------");
        System.out.println("Vamos iniciar sua aventura Grande " + player.getHeroClass() + " " + player.getName() + "!");
        System.out.println("Você está pronto para enfrentar os desafios que virão pela frente.");
        // Continue o jogo...
        // scanner.close(); // Só feche no final do programa, se desejar
    }

    //Metodo para entrar com nome do jogador e escolher o personagem
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
                    Mage jogadorHeroi = new Mage(nomeJogador);
                    System.out.println("Parabéns " + nomeJogador + ", você escolheu a classe Mago para o seu Herói. " +
                            "\nOs atributos iniciais são:\n" +
                            "Vida: " + jogadorHeroi.getMaxHealth() +
                            ", Ataque: " + jogadorHeroi.getAttackPower() +
                            ", Defesa: " + jogadorHeroi.getDefensePower() +
                            ", Mana: " + jogadorHeroi.getMana());
                    return jogadorHeroi;
                case 2:
                    System.out.println("Guerreiro ainda não implementado.");
                    break;
                case 3:
                    System.out.println("Arqueiro ainda não implementado.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}

