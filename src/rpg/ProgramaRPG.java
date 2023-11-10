package rpg;

import rpg.personagens.BombaMan;
import rpg.personagens.Jogavel;
import rpg.personagens.Personagem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaRPG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean jogarNovamente = true;

        while (jogarNovamente) {
            System.out.println("Bem-vindo ao RPG com 2 jogadores!");

            Personagem jogador1 = criarPersonagem(scanner, 1);
            Personagem jogador2 = criarPersonagem(scanner, 2);

            System.out.println("Personagens iniciais:");
            System.out.println(jogador1);
            System.out.println(jogador2);

            while (jogador1.estaVivo() && jogador2.estaVivo()) {
                realizarAcao(scanner, jogador1, jogador2);
                if (jogador2.estaVivo()) {
                    realizarAcao(scanner, jogador2, jogador1);
                }
            }

            if (!jogador1.estaVivo() && !jogador2.estaVivo()) {
                System.out.println("Jogo empatou!");
            } else if (!jogador2.estaVivo()) {
                System.out.println("Jogador 1 venceu o jogo!");
            } else {
                System.out.println("Jogador 2 venceu o jogo!");
            }

            jogarNovamente = perguntarJogarNovamente(scanner);
        }

        scanner.close();
    }

    public static Personagem criarPersonagem(Scanner scanner, int numeroJogador) {
        System.out.println("Jogador " + numeroJogador + ", crie seu personagem:");
        System.out.println("Digite o nome do personagem: ");
        String nome = scanner.next();

        int vida = obterInteiroValido(scanner, "Digite a quantidade de vida do personagem: ");
        int poder = obterInteiroValido(scanner, "Digite o poder de ataque do personagem: ");

        return new BombaMan(nome, vida, poder);
    }

    public static int obterInteiroValido(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
    }

    public static void realizarAcao(Scanner scanner, Personagem atacante, Personagem alvo) {
        System.out.println("Jogador " + atacante.getNome() + ", é a sua vez de agir.");
        System.out.println("Escolha uma ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("0 - Sair");

        int acao = obterInteiroValido(scanner, "Escolha uma ação (1 para Atacar, 2 para Defender, 0 para Sair):");

        Jogavel atacanteJogavel = (Jogavel) atacante;

        if (acao == 1) {
            atacanteJogavel.atacar(alvo);
        } else if (acao == 2) {
            atacanteJogavel.defender();
        } else if (acao == 0) {
            System.out.println("Jogo encerrado.");
            scanner.close();
            System.exit(0);
        } else {
            System.out.println("Ação inválida. Nenhuma ação realizada.");
        }
    }

    public static boolean perguntarJogarNovamente(Scanner scanner) {
        System.out.println("Deseja jogar novamente? (Digite 's' para sim, qualquer outra coisa para sair)");
        String opcao = scanner.next().toLowerCase();
        if (!opcao.equals("s")) {
            System.out.println("Jogo encerrado.");
            scanner.close();
            System.exit(0);
            return false;
        }
        return true;
    }
}
