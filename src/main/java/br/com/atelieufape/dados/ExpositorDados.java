package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;

public interface ExpositorDados extends JpaRepository<UsuarioExpositorEntity, Long > {
	
	Optional<UsuarioExpositorEntity> existsByCpf (String cpf);

}
