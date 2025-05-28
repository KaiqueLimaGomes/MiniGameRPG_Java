# Comentário Pessoal
Este projeto tem como objetivo testar meus conhecimentos com a linguagem JAVA, de modo que pudesse pôr em prática minhas habilidades e também aproveitar para reforça meus conhecimentos base de lógica de programação e programação orientada a objetos (POO). Agradeço ao professor Felipe Aguiar - Tech Educator at DIO, que em suas aulas utilizou exemplos de jogos, o que deixou a didática mais interessante e divertida e sempre incentivou que fizéssemos algo a mais para explorar, e este é o resultado da minha exploração!

Se por um acaso, você que jogou quiser deixar uma sugestão, entre em contato comigo através do meu LinkedIn, para podermos trocar uma ideia. Obrigado.

Kaique Lima - <a href="https://www.linkedin.com/in/kaiquelimagomes/" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

# MiniGameRPG (JAVA)

Este projeto é um mini RPG de texto desenvolvido em Java, onde o jogador assume o papel de um herói (Guerreiro, Mago ou Arqueiro) e enfrenta batalhas contra monstros em diferentes áreas e níveis de dificuldade. O jogo possui sistema de evolução de personagem, atributos, experiência, penalidade por morte, salvamento e carregamento de progresso.

## Conteúdo

- Escolha de classe de herói (Guerreiro, Mago ou Arqueiro), cada uma com atributos e progressão únicos.
- Sistema de batalhas por turnos contra monstros gerados aleatoriamente.
- Sistema de experiência, subida de nível e evolução de atributos.
- Penalidade de morte: o herói perde nível e atributos, mas nunca abaixo do valor inicial.
- Menu de exploração com múltiplos eventos por área.
- Salvamento automático do progresso do herói em arquivo.
- Visualização dos status do herói a qualquer momento.

## Funcionalidades de Programação Orientada a Objetos

- **Herança:** As classes `Hero`, `Warrior`, `Mage`, `Archer` e `Monster` herdam de uma classe base `Character`, compartilhando e especializando comportamentos.
- **Encapsulamento:** Os atributos dos personagens são protegidos e acessados/modificados por meio de métodos getters e setters.
- **Polimorfismo:** Métodos como `atacar()` e `defender()` são sobrescritos em subclasses, permitindo comportamentos diferentes para cada tipo de personagem.
- **Abstração:** A classe `Character` é abstrata, servindo como modelo para os personagens do jogo.
- **Manipulação de arquivos:** O progresso do herói é salvo e carregado em arquivos, permitindo persistência dos dados entre sessões.
- **Geração aleatória:** Monstros e eventos são gerados de forma randômica, tornando cada partida única.

## Linguagem utilizada

- **Java** (JDK 21 ou superior)
- Utiliza apenas bibliotecas padrão da linguagem.

## Como jogar

1. Baixe apenas o arquivo zip "JogarAqui", onde o projeto já está compilado. (Apenas para Windows)
2. Extrai os arquivos em um pasta.
3. Executa o arquivo "Iniciar_Jogo", em seguida o jogo irá abrir atráves do CMD (tela preta). 
3. Escolha sua classe, explore áreas, lute contra monstros e evolua seu personagem!

## Outros

- O projeto é totalmente em texto, feito para testar meu aprendizado de lógica, orientação a objetos e manipulação de arquivos em Java.
- Irei continuar atualizando o projeto até possuir graficos semelhantes ao Pokémon de GameBoy, expandido com novas classes, monstros, habilidades e itens.
