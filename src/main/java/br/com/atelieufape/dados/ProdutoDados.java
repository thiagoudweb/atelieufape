package br.com.atelieufape.dados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atelieufape.negocio.basico.ProdutoEntity;

//Autor: Luiza Marques
//Esta classe é responsável por gerar o repositório onde serão guardados os produtos.
@Repository
public interface ProdutoDados extends JpaRepository<ProdutoEntity, Long> {
	
	Optional<ProdutoEntity> findByNome (String nome);

	@SuppressWarnings("unchecked")
	ProdutoEntity save(ProdutoEntity produto);

	default boolean exists(ProdutoEntity produto) {
        if (produto.getId() != null) {
            return existsById(produto.getId());
        } else if (produto.getNome() != null) {
            return findByNome(produto.getNome()).isPresent();
        }
        return false;
    }

	void delete(ProdutoEntity produto);
	
	List<ProdutoEntity> findAll();

}