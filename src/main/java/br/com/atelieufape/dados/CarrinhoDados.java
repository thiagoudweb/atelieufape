package br.com.atelieufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.CarrinhoEntity;

public interface CarrinhoDados extends JpaRepository<CarrinhoEntity, Long> {

}
