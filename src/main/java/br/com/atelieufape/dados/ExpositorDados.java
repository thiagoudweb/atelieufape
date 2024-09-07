package br.com.atelieufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;

public interface ExpositorDados extends JpaRepository<UsuarioExpositorEntity, Long > {

}
