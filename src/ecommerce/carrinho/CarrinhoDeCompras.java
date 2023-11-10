package ecommerce.carrinho;

import ecommerce.produtos.EProduto;

public interface CarrinhoDeCompras {
    void adicionarProduto(EProduto produto);

    void finalizarCompra();
}
