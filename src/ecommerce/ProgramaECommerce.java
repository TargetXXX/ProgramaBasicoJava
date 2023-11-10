package ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ecommerce.carrinho.CarrinhoDeComprasOnline;
import ecommerce.produtos.EProduto;
import ecommerce.produtos.ProdutoEletronico;
import ecommerce.produtos.ProdutoVestuario;

public class ProgramaECommerce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrinhoDeComprasOnline carrinho = new CarrinhoDeComprasOnline();
        List<EProduto> produtosCadastrados = new ArrayList<>();

        while (true) {
            System.out.println("Bem-vindo ao nosso e-commerce!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Produto ao Carrinho");
            System.out.println("2 - Finalizar Compra");
            System.out.println("3 - Listar Produtos Disponíveis");
            System.out.println("4 - Cadastrar Produto");
            System.out.println("0 - Sair do Programa");

            int opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    adicionarProdutoAoCarrinho(scanner, produtosCadastrados, carrinho);
                    break;
                case 2:
                    carrinho.finalizarCompra();
                    break;
                case 3:
                    listarProdutosDisponiveis(produtosCadastrados);
                    break;
                case 4:
                    cadastrarProduto(scanner, produtosCadastrados);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static int lerInteiro(Scanner scanner) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                valido = true;
            } else {
                System.err.println("Erro: Valor inválido. Digite um número inteiro.");
                scanner.next();
            }
        }

        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                valido = true;
            } else {
                System.err.println("Erro: Valor inválido. Digite um número.");
                scanner.next();
            }
        }

        scanner.nextLine();
        return valor;
    }

    private static void adicionarProdutoAoCarrinho(Scanner scanner, List<EProduto> produtosCadastrados, CarrinhoDeComprasOnline carrinho) {
        if (produtosCadastrados.isEmpty()) {
            System.out.println("Não há produtos cadastrados. Cadastre produtos antes de adicionar ao carrinho.");
            return;
        }

        listarProdutosDisponiveis(produtosCadastrados);
        System.out.println("Escolha um produto pelo ID para adicionar ao carrinho:");

        int idProduto = lerInteiro(scanner);

        if (idProduto >= 0 && idProduto < produtosCadastrados.size()) {
            carrinho.adicionarProduto(produtosCadastrados.get(idProduto));
            System.out.println("Produto adicionado ao carrinho.");
        } else {
            System.out.println("ID de produto inválido.");
        }
    }

    private static void listarProdutosDisponiveis(List<EProduto> produtosCadastrados) {
        System.out.println("Produtos Disponíveis:");
        for (int i = 0; i < produtosCadastrados.size(); i++) {
            System.out.print("ID: " + i + " - ");
            produtosCadastrados.get(i).descricao();
        }
    }

    private static void cadastrarProduto(Scanner scanner, List<EProduto> produtosCadastrados) {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = lerDouble(scanner);

        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Produto Eletrônico");
        System.out.println("2 - Produto de Vestuário");
        int tipoProduto = lerInteiro(scanner);

        EProduto produto = null;
        if (tipoProduto == 1) {
            System.out.println("Digite a marca do produto eletrônico:");
            String marca = scanner.nextLine();
            produto = new ProdutoEletronico(nome, preco, marca);
        } else if (tipoProduto == 2) {
            System.out.println("Digite o tamanho do produto de vestuário:");
            String tamanho = scanner.nextLine();
            produto = new ProdutoVestuario(nome, preco, tamanho);
        } else {
            System.out.println("Opção inválida. Produto não cadastrado.");
        }

        if (produto != null) {
            produtosCadastrados.add(produto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }
}
