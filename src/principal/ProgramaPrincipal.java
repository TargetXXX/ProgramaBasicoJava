package principal;

import java.util.Scanner;

import ecommerce.ProgramaECommerce;
import faculdade.ProgramaFaculdade;
import mercado.ProgramaMercado;
import rpg.ProgramaRPG;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            exibirMenu();
            opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    executarProgramaFaculdade(scanner);
                    break;
                case 2:
                    executarProgramaMercado(scanner);
                    break;
                case 3:
                    executarProgramaECommerce(scanner);
                    break;
                case 4:
                    executarProgramaRpg(scanner);
                    break;
                case 0:
                    System.out.println("Programa fechado.");
                    break;
                default:
                    System.out.println("Erro: Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Escolha um programa:");
        System.out.println("1 - Programa Faculdade");
        System.out.println("2 - Programa Mercado");
        System.out.println("3 - Programa E-Commerce");
        System.out.println("4 - Programa Rpg");
        System.out.println("0 - Sair");
    }

    private static int obterOpcao(Scanner scanner) {
        int opcao = -1;

        try {
            if (scanner.hasNextLine()) {
                opcao = Integer.parseInt(scanner.nextLine());
            } else {
                System.out.println("Erro: Não há mais entradas disponíveis.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Digite um número.");
        }

        return opcao;
    }

    private static void executarProgramaFaculdade(Scanner scanner) {
        ProgramaFaculdade.main(new String[]{});
        aguardarEnter(scanner);
    }

    private static void executarProgramaMercado(Scanner scanner) {
        ProgramaMercado.main(new String[]{});
        aguardarEnter(scanner);
    }
    
    private static void executarProgramaECommerce(Scanner scanner) {
        ProgramaECommerce.main(new String[]{});
        aguardarEnter(scanner);
    }
    
    private static void executarProgramaRpg(Scanner scanner) {
        ProgramaRPG.main(new String[]{});
        aguardarEnter(scanner);
    }

    private static void aguardarEnter(Scanner scanner) {
        System.out.println("\nPressione Enter para continuar...");
        try {
            Thread.sleep(100);
            scanner.nextLine();
        } catch (InterruptedException e) {
            
        }
    }

}
