package br.com.atelieufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import br.com.atelieufape.negocio.basico.ItemCarrinhoCompraEntity;

public interface ProdutoCarrinhoDados extends JpaRepository<ItemCarrinhoCompraEntity, Long> {
    Optional<ItemCarrinhoCompraEntity> findByProdutoIdAndCarrinhoId(Long produtoId, Long carrinhoId);
    List<ItemCarrinhoCompraEntity> findByCarrinhoId(Long carrinhoId);
}
