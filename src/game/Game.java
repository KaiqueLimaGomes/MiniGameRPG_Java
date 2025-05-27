package game;

import java.util.Scanner;
import character.Mage;
import character.Warrior;
import character.Archer;
import character.Hero;
import character.Monster;
import util.HeroPersistence; // Import HeroPersistence for loading/saving hero
import java.io.File; // Import File for file operations
import java.io.IOException;
import java.util.Random;

public class Game {
    private static final Scanner scanner = new Scanner(System.in); // Scanner global

    private void salvarHeroi(Hero hero) {
    try {
        HeroPersistence.salvar(hero);
    } catch (IOException e) {
        System.out.println("Erro ao salvar personagem: " + e.getMessage());
    }
}

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

        // Loop principal do jogo
        while (true) {
            menuExploracao(player);

            // Após voltar da exploração, pergunte se deseja explorar novamente ou sair
            System.out.println("\nDeseja explorar novamente? (s/n)");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (!resposta.equals("s")) {
                System.out.println("Obrigado por jogar!");
                break;
            }
        }
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

    // Função de batalha entre herói e monstro
    public boolean batalha(character.Character heroi, character.Character monstro) {
        System.out.println("\n********** BATALHA **********");
        System.out.println("Entre " + heroi.getName() + " (Nível " + heroi.getLevel() + ") e " +
                monstro.getName() + " (Nível " + monstro.getLevel() + ")");
        System.out.println("*****************************\n");

        character.Character atacante, defensor;
        if (heroi.getLevel() >= monstro.getLevel()) {
            atacante = heroi;
            defensor = monstro;
        } else {
            atacante = monstro;
            defensor = heroi;
        }

        while (heroi.getHealth() > 0 && monstro.getHealth() > 0) {
            System.out.println("\n" + atacante.getName() + " ataca!");
            int dano = atacante.atacar();
            defensor.receberDano(dano);
            System.out.println(defensor.getName() + " ficou com " + defensor.getHealth() + " de vida após o ataque!");

            // Verifica se o defensor morreu após o ataque
            if (defensor.getHealth() <= 0) {
                System.out.println(defensor.getName() + " foi derrotado!");
                break;
            }

            // Pausa para interação do jogador
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();

            // Troca atacante e defensor para o próximo turno
            character.Character temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        if (heroi.getHealth() > 0) {
            // Vitória
            System.out.println("\n***** " + heroi.getName().toUpperCase() + " VENCEU A BATALHA! *****\n");
            int xpGanho = monstro.getLevel() * 2;
            if (heroi instanceof Hero) {
                ((Hero) heroi).ganharExperiencia(xpGanho);
                ((Hero) heroi).subirNivel();
                System.out.println(">>> " + heroi.getName() + " ganhou " + xpGanho + " de experiência!\n");
                salvarHeroi((Hero) heroi);
                return false; // Herói não morreu
            }
        } else {
            // Derrota
            System.out.println(monstro.getName() + " venceu a batalha!");

            if (heroi instanceof Hero) {
                Hero heroObj = (Hero) heroi;
                // Chame a penalidade conforme a classe do herói
                if (heroObj instanceof Warrior) {
                    heroObj.penalidadeMorte(120,9, 10, 50);
                } else if (heroObj instanceof Mage) {
                    heroObj.penalidadeMorte(80, 13, 5, 100);
                } else if (heroObj instanceof Archer) {
                    heroObj.penalidadeMorte(90, 10, 7, 70);
                }
                salvarHeroi(heroObj);
                return true; // Herói morreu
            }
            // Interrompe imediatamente a batalha e retorna ao menu de exploração
        }
        // Caso nenhuma das condições acima seja satisfeita, retorna false por padrão
        return false;
    }

    public void menuExploracao(Hero player) {
        try {
            player = HeroPersistence.carregar();
            System.out.println("Personagem carregado com sucesso!");
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o personagem salvo. Continuando com o personagem atual.");
        }

        while (true) {
            System.out.println("\n=== Menu de Exploração ===");
            System.out.println("1. Explorar uma área");
            System.out.println("2. Ver status do herói");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (opcao == 0) {
                System.out.println("Saindo da exploração...");
                break;
            }
            if (opcao == 2) {
                System.out.println("\n===== STATUS DO HERÓI =====");
                System.out.println("Nome: " + player.getName());
                System.out.println("Classe: " + player.getHeroClass());
                System.out.println("Nível: " + player.getLevel());
                System.out.println("Experiência: " + player.getExperience() + "/" + player.getExpToNextLevel());
                System.out.println("Vida: " + player.getHealth() + "/" + player.getMaxHealth());
                System.out.println("Ataque: " + player.getAttackPower());
                System.out.println("Defesa: " + player.getDefensePower());
                System.out.println("Mana: " + player.getMana());
                System.out.println("===========================\n");
                continue;
            }
            if (opcao == 1) {
                System.out.println("Escolha o nível da área para explorar (1 a 5):");
                int nivelArea = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (nivelArea < 1 || nivelArea > 5) {
                    System.out.println("Nível inválido! Escolha entre 1 e 5.");
                    continue;
                }

                Random rand = new Random();
                int eventos = 1 + rand.nextInt(5); // Sorteia entre 1 e 5 eventos

                System.out.println("Você irá enfrentar " + eventos + " evento(s) nesta área!");

                for (int i = 1; i <= eventos; i++) {
                    Monster monstro = Monster.gerarMonstroAleatorio(nivelArea);
                    System.out.println("\n----------------------------------------");
                    System.out.println("Evento " + i + ": Apareceu um " + monstro.getName().toUpperCase() +
                            " (Nível " + monstro.getLevel() + ", Vida: " + monstro.getHealth() +
                            ", Ataque: " + monstro.getAttackPower() + ", Defesa: " + monstro.getDefensePower() + ")");
                    System.out.println("----------------------------------------\n");
                    boolean morreu = batalha(player, monstro);

                    if (morreu) {
                        System.out.println("Seu herói foi derrotado! Voltando ao menu de exploração...");
                        return;
                    }
                }

                player.setHealth(player.getMaxHealth());
                System.out.println("\n*** Parabéns! Você sobreviveu a todos os eventos desta área. ***");
                System.out.println("Sua vida foi totalmente restaurada!\n");
            }
        }
    }
}
