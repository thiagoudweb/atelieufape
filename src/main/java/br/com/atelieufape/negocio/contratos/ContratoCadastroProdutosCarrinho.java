package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.ItemCarrinhoCompraEntity;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoVazioException;
import br.com.atelieufape.negocio.cadastro.exception.ItemCarrinhoNaoDisponivelException;
import br.com.atelieufape.negocio.cadastro.exception.QuantidadeProdutosInvalidaException;

public interface ContratoCadastroProdutosCarrinho {
    ItemCarrinhoCompraEntity salvarProdutosCarrinho(ItemCarrinhoCompraEntity item);

    void deletarProdutosCarrinho(Long id) throws CarrinhoVazioException;

    void deletarUnidadeDeProdutos(Long id, int quantRemover) throws QuantidadeProdutosInvalidaException;

    ItemCarrinhoCompraEntity atualizarProdutosCarrinho(ItemCarrinhoCompraEntity item)
            throws ItemCarrinhoNaoDisponivelException;

    List<ItemCarrinhoCompraEntity> listarProdutosCarrinho(Long carrinhoId) throws CarrinhoVazioException;

    ItemCarrinhoCompraEntity buscarPorProdutoECarrinho(Long produtoId, Long carrinhoId);
}
