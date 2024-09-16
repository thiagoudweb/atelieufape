package br.com.atelieufape.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.cadastro.exception.AtualizarUsuarioException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroExpositor;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProduto;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class Fachada {

	@Autowired
	private ContratoCadastroUsuario cadastroUsuario;

	@Autowired
	private ContratoCadastroExpositor cadastroExpositor;
	
	@Autowired
	private ContratoCadastroProduto cadastroProduto;

	// @Autowired
	// private ContratoCarrinhoUsuario cadastroCarrinhoUsuario;

	// Usuario
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) throws CadastroUsuarioException {
		return this.cadastroUsuario.cadastrarUsuario(usuario);
	}

	public void removerUsuario(UsuarioEntity usuario) {
		this.cadastroUsuario.removerUsuario(usuario);
	}

	public UsuarioEntity atualizarUsuario(UsuarioEntity usuario) throws AtualizarUsuarioException {
		return cadastroUsuario.atualizarUsuario(usuario);
	}

	public List<UsuarioEntity> ListarUsuarios() {
		return this.cadastroUsuario.listarUsuarios();
	}

	public UsuarioEntity buscarUsuarioPorID(Long id) throws CadastroUsuarioException {
		return this.cadastroUsuario.buscarUsuarioPorID(id);
	}

	// Expositor
	public UsuarioExpositorEntity cadastrarExpositor(UsuarioExpositorEntity expositor)
			throws CadastroExpositorException {
		return this.cadastroExpositor.cadastrarExpositor(expositor);
	}

	public void removerExpositor(UsuarioExpositorEntity expositor) {
		this.cadastroExpositor.removerExpositor(expositor);
	}

	public UsuarioExpositorEntity atualizarExpositor(UsuarioExpositorEntity expositor)
			throws CadastroExpositorException {
		return cadastroExpositor.atualizarExpositor(expositor);
	}

	public List<UsuarioExpositorEntity> listarExpositores() {
		return this.cadastroExpositor.listarExpositores();
	}

	public UsuarioExpositorEntity buscarUsuarioExpositorPorID(Long id) throws CadastroExpositorException {
		return this.cadastroExpositor.buscarUsuarioExpositorPorID(id);
	}
	
	//Produto
	public ProdutoEntity cadastrarProduto(ProdutoEntity produto) throws CadastroProdutoException {
		return this.cadastroProduto.cadastrarProduto(produto);
	}
	
	public ProdutoEntity buscarProdutoPorID(Long ID) throws CadastroProdutoException {
		return this.cadastroProduto.buscarProdutoPorId(ID);
	}
	
	public List<ProdutoEntity> listarProdutos() throws CadastroProdutoException{
		return this.cadastroProduto.listarProdutos();
	}
	
	public ProdutoEntity atualizarProduto(ProdutoEntity produto) throws CadastroProdutoException {
		return cadastroProduto.atualizarProduto(produto);
	}
	
	public void removerProduto(ProdutoEntity produto) throws CadastroProdutoException {
		this.cadastroProduto.removerProduto(produto);
	}

}
