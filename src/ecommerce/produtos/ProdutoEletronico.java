package ecommerce.produtos;

public class ProdutoEletronico extends EProduto {
    private String marca;

    public ProdutoEletronico(String nome, double preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    @Override
    public void descricao() {
        System.out.println("Produto Eletrônico: " + getNome() + " - Marca: " + marca + " - Preço: $" + getPreco());
    }
}
