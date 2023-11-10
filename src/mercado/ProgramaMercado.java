package mercado;

import java.util.ArrayList;
import java.util.Scanner;

import mercado.produtos.Produto;
import mercado.produtos.ProdutoAlimenticio;
import mercado.produtos.ProdutoEletronico;

public class ProgramaMercado {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    visualizarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Erro: Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Visualizar Produtos");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Excluir Produto");
        System.out.println("0 - Sair");
    }

    private static int obterOpcao() {
        int opcao = -1;

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida. Digite um número.");
        }

        return opcao;
    }

    private static void adicionarProduto() {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Produto Alimentício");
        System.out.println("2 - Produto Eletrônico");

        int tipoProduto = obterInteiroDoUsuario();

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto:");
        double preco = obterDoubleDoUsuario();

        Produto produto;

        switch (tipoProduto) {
            case 1:
                System.out.println("Digite a data de validade do produto alimentício:");
                String dataValidade = scanner.nextLine();
                produto = new ProdutoAlimenticio(nome, preco, dataValidade);
                break;
            case 2:
                System.out.println("Digite a marca do produto eletrônico:");
                String marca = scanner.nextLine();
                produto = new ProdutoEletronico(nome, preco, marca);
                break;
            default:
                System.out.println("Erro: Opção inválida. Produto não adicionado.");
                return;
        }

        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void visualizarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static void atualizarProduto() {
        System.out.println("Digite o nome do produto a ser atualizado:");
        String nome = scanner.nextLine();

        Produto produto = buscarProdutoPorNome(nome);

        if (produto != null) {
            System.out.println("Digite o novo preço do produto:");
            double novoPreco = obterDoubleDoUsuario();
            produto.setPreco(novoPreco);

            if (produto instanceof ProdutoAlimenticio) {
                System.out.println("Digite a nova data de validade do produto alimentício:");
                String novaDataValidade = scanner.nextLine();
                ((ProdutoAlimenticio) produto).setDataValidade(novaDataValidade);
            } else if (produto instanceof ProdutoEletronico) {
                System.out.println("Digite a nova marca do produto eletrônico:");
                String novaMarca = scanner.nextLine();
                ((ProdutoEletronico) produto).setMarca(novaMarca);
            }

            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

    private static void excluirProduto() {
        System.out.println("Digite o nome do produto a ser excluído:");
        String nome = scanner.nextLine();

        Produto produto = buscarProdutoPorNome(nome);

        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

    private static Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    private static int obterInteiroDoUsuario() {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido.");
            }
        }

        return numero;
    }

    private static double obterDoubleDoUsuario() {
        double numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                numero = Double.parseDouble(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            }
        }

        return numero;
    }
}
