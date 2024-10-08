package br.com.atelieufape.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
@Repository
public interface ExpositorDados extends JpaRepository<UsuarioExpositorEntity, Long> {
    Optional<UsuarioExpositorEntity> findByCpf(String cpf);
    Optional<UsuarioExpositorEntity> findByEmail(String email); 
}