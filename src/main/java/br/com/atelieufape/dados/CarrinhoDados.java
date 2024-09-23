package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atelieufape.negocio.basico.CarrinhoEntity;
@Repository
public interface CarrinhoDados extends JpaRepository<CarrinhoEntity, Long> {

	public Optional<CarrinhoEntity> findByusuarioCarrinho_Id (Long iDusuario);
}
