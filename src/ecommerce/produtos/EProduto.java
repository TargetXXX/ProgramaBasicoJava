package ecommerce.produtos;

public abstract class EProduto {
    private String nome;
    private double preco;

    public EProduto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract void descricao();
}
