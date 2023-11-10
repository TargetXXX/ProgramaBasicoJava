package ecommerce.produtos;

public class ProdutoVestuario extends EProduto {
    private String tamanho;

    public ProdutoVestuario(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
    }

    @Override
    public void descricao() {
        System.out.println("Produto de Vestuário: " + getNome() + " - Tamanho: " + tamanho + " - Preço: $" + getPreco());
    }
}