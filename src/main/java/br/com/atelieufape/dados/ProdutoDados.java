package br.com.atelieufape.dados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.ProdutoEntity;

public interface ProdutoDados extends JpaRepository<ProdutoEntity, Long> {
	
	Optional<ProdutoEntity> findByNome (String nome);

	@SuppressWarnings("unchecked")
	ProdutoEntity save(ProdutoEntity produto);

	boolean exists(ProdutoEntity produto);

	void delete(ProdutoEntity produto);
	
	List<ProdutoEntity> findAll();

}