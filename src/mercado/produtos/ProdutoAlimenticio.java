package mercado.produtos;

public class ProdutoAlimenticio extends Produto {
    private String dataValidade;

    public ProdutoAlimenticio(String nome, double preco, String dataValidade) {
        super(nome, preco);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Produto Alimentício: " +
                "Nome: " + getNome() +
                ", Preço: " + getPreco() +
                ", Data de Validade: " + dataValidade;
    }
}
