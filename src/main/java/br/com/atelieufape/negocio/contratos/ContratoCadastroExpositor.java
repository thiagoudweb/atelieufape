package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;

public interface ContratoCadastroExpositor {
	
	public UsuarioExpositorEntity cadastrarExpositor(UsuarioExpositorEntity expositor);
	
	public void RemoverExpositor(UsuarioExpositorEntity expositor);
	
	public UsuarioExpositorEntity AtualizarExpositor(UsuarioExpositorEntity expositor);
	
	public List<UsuarioExpositorEntity> ListarExpositores ();
	
	public UsuarioExpositorEntity BuscarUsuarioExpositorPorID(Long id);
	

}
