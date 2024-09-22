package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
@Repository
public interface ProdutoCarrinhoDados extends JpaRepository<ProdutosCarrinhoEntity, Long> {
	
//	Optional<ProdutosCarrinhoEntity> buscarPorId(Long id);
}
