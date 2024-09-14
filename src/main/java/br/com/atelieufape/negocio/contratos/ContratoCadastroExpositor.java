package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;

public interface ContratoCadastroExpositor {

	public UsuarioExpositorEntity cadastrarExpositor(UsuarioExpositorEntity expositor);

	public void removerExpositor(UsuarioExpositorEntity expositor);

	public UsuarioExpositorEntity atualizarExpositor(UsuarioExpositorEntity expositor);

	public void deletarExpositor(Long ID);

	public List<UsuarioExpositorEntity> listarExpositores();

	public UsuarioExpositorEntity buscarUsuarioExpositorPorID(Long id);

}
