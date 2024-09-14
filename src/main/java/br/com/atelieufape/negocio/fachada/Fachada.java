package br.com.atelieufape.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.cadastro.CadastroUsuario;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroExpositor;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class Fachada {
	
	@Autowired
	private ContratoCadastroUsuario cadastroUsuario;
	
	@Autowired
	private ContratoCadastroExpositor cadastroExpositor;
	
	//@Autowired
	//private ContratoCarrinhoUsuario cadastroCarrinhoUsuario;
	
	//Usuario
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {
		return this.cadastroUsuario.cadastrarUsuario(usuario);
	}
	
	public void RemoverUsuario(UsuarioEntity usuario) {
		this.cadastroUsuario.RemoverUsuario(usuario);
	}
	
	public UsuarioEntity AtualizarUsuario(UsuarioEntity usuario) throws CadastroUsuarioException{
		return cadastroUsuario.AtualizarUsuario(usuario);
	}
	
	public List<UsuarioEntity> ListarUsuarios(){
		return this.cadastroUsuario.ListarUsuarios();
	}
	
	public UsuarioEntity BuscarUsuarioPorID(Long id) throws CadastroUsuarioException{
		return this.cadastroUsuario.BuscarUsuarioPorID(id);		
	}

	//Expositor
	public UsuarioExpositorEntity cadastrarExpositor(UsuarioExpositorEntity expositor) throws CadastroExpositorException {
		return this.cadastroExpositor.cadastrarExpositor(expositor);
	}
	
	public void RemoverExpositor(UsuarioExpositorEntity expositor) {
		this.cadastroExpositor.RemoverExpositor(expositor);
	}
	
	public UsuarioExpositorEntity AtualizarExpositor(UsuarioExpositorEntity expositor) throws CadastroExpositorException{
		return cadastroExpositor.AtualizarExpositor(expositor);
	}
	
	public List<UsuarioExpositorEntity> ListarExpositores(){
		return this.cadastroExpositor.ListarExpositores();
	}
	
	public UsuarioExpositorEntity BuscarUsuarioExpositorPorID(Long id) throws CadastroExpositorException{
		return this.cadastroExpositor.BuscarUsuarioExpositorPorID(id);		
	}
	
}


