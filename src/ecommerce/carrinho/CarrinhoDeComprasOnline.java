package ecommerce.carrinho;

import java.util.ArrayList;
import java.util.List;

import ecommerce.produtos.EProduto;


public class CarrinhoDeComprasOnline implements CarrinhoDeCompras {
    private List<EProduto> itens = new ArrayList<>();

    @Override
    public void adicionarProduto(EProduto produto) {
        itens.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    @Override
    public void finalizarCompra() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio. Nenhuma compra realizada.");
        } else {
            System.out.println("Compra finalizada. Itens no carrinho:");
            for (EProduto produto : itens) {
                produto.descricao();
            }
            itens.clear();
        }
    }


}
