package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;

public interface ProdutoCarrinhoDados extends JpaRepository<ProdutosCarrinhoEntity, Long> {
	
	Optional<ProdutosCarrinhoEntity> buscarPorId(Long id);
}
