package br.com.atelieufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;

public interface ProdutoCarrinhoDados extends JpaRepository<ProdutosCarrinhoEntity, Long> {
	
}
