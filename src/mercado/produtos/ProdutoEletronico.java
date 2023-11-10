package mercado.produtos;

public class ProdutoEletronico extends Produto {
    private String marca;

    public ProdutoEletronico(String nome, double preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
    	
    	if(marca != null && !marca.isEmpty()) {
    		this.marca = marca;
    		return;
    	}
    	
    	System.err.println("Erro: Marca inválida");
        
    }

    @Override
    public String toString() {
        return "Produto Eletrônico: " +
                "Nome: " + getNome() +
                ", Preço: " + getPreco() +
                ", Marca: " + marca;
    }
}
