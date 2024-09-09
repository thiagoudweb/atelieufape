package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.UsuarioEntity;

public interface UsuarioDados extends JpaRepository<UsuarioEntity, Long> {
	
	Optional<UsuarioEntity> findByCpf (String cpf);
}
