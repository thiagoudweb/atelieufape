package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.ProdutoCarrinhoDados;
import br.com.atelieufape.negocio.basico.ItemCarrinhoCompraEntity;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoVazioException;
import br.com.atelieufape.negocio.cadastro.exception.ItemCarrinhoNaoDisponivelException;
import br.com.atelieufape.negocio.cadastro.exception.ProdutoNaoEncontradoException;
import br.com.atelieufape.negocio.cadastro.exception.QuantidadeProdutosInvalidaException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProdutosCarrinho;

@Service
public class CadastroProdutosCarrinhoUsuario implements ContratoCadastroProdutosCarrinho {

    @Autowired
    private ProdutoCarrinhoDados produtosCarrinho;

    @Override
    public ItemCarrinhoCompraEntity salvarProdutosCarrinho(ItemCarrinhoCompraEntity item) {
        Optional<ItemCarrinhoCompraEntity> itemExistente = produtosCarrinho.findByProdutoIdAndCarrinhoId(
                item.getProduto().getId(), item.getCarrinho().getId());

        if (itemExistente.isPresent()) {
            ItemCarrinhoCompraEntity itemAtualizado = itemExistente.get();
            itemAtualizado.setQuantidade(
                    itemAtualizado.getQuantidade() + item.getQuantidade());
            return produtosCarrinho.save(itemAtualizado);
        } else {
            item.setPrecoUnitario(item.getProduto().getPreco());
            return produtosCarrinho.save(item);
        }
    }

    @Override
    public void deletarProdutosCarrinho(Long id) throws CarrinhoVazioException {

        Optional<ItemCarrinhoCompraEntity> itemBd = produtosCarrinho.findById(id);
        if (itemBd.isPresent() && itemBd.get().getCarrinho() != null) {
            produtosCarrinho.deleteById(id);
        } else {
            throw new CarrinhoVazioException("Produto não está no carrinho");
        }
    }

    @Override
    public void deletarUnidadeDeProdutos(Long id, int quantRemover) throws QuantidadeProdutosInvalidaException {

        Optional<ItemCarrinhoCompraEntity> itemBd = produtosCarrinho.findById(id);

        if (itemBd.isPresent() && itemBd.get().getCarrinho() != null) {

            ItemCarrinhoCompraEntity itemAtualizado = itemBd.get();
            int quantidadeAtual = itemAtualizado.getQuantidade();

            if (quantRemover <= 0) {
                throw new QuantidadeProdutosInvalidaException("Quantidade inválida!");
            } else if (quantRemover >= quantidadeAtual) {
                deletarProdutosCarrinho(id);
            } else {
                itemAtualizado.setQuantidade(quantidadeAtual - quantRemover);
                produtosCarrinho.save(itemAtualizado);
            }
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado no carrinho");
        }

    }

    @Override
    public ItemCarrinhoCompraEntity atualizarProdutosCarrinho(ItemCarrinhoCompraEntity item)
            throws ItemCarrinhoNaoDisponivelException {

        Optional<ItemCarrinhoCompraEntity> itemBd = produtosCarrinho.findById(item.getId());
        if (itemBd.isPresent() && itemBd.get().getCarrinho() != null) {
            return produtosCarrinho.save(item);
        } else {
            throw new ItemCarrinhoNaoDisponivelException("Item selecionado não disponível no carrinho");
        }
    }

    @Override
    public List<ItemCarrinhoCompraEntity> listarProdutosCarrinho(Long carrinhoId) throws CarrinhoVazioException {

        List<ItemCarrinhoCompraEntity> listaProdutos = produtosCarrinho.findByCarrinhoId(carrinhoId);
        if (listaProdutos.isEmpty()) {
            throw new CarrinhoVazioException("O seu carrinho está vazio");
        } else {
            return listaProdutos;
        }
    }

    @Override
    public ItemCarrinhoCompraEntity buscarPorProdutoECarrinho(Long produtoId, Long carrinhoId) {
        Optional<ItemCarrinhoCompraEntity> item = produtosCarrinho.findByProdutoIdAndCarrinhoId(produtoId, carrinhoId);
        return item.orElse(null);
    }
}
