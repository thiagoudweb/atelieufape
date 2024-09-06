package br.com.atelieufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.UsuarioEntity;

public interface UsuarioDados extends JpaRepository<UsuarioEntity, Long> {

}
