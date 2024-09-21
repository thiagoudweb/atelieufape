package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atelieufape.negocio.basico.UsuarioEntity;
@Repository
public interface UsuarioDados extends JpaRepository<UsuarioEntity, Long> {
	
	Optional<UsuarioEntity> findByCpf (String cpf);
}
