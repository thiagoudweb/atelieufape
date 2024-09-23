package br.com.atelieufape.negocio.fachada;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.basico.StatusCompra;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoNaoEncontradoException;
import br.com.atelieufape.negocio.cadastro.exception.CompraNaoPodeSerFinalizadaException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCarrinho;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCompra;
import br.com.atelieufape.negocio.contratos.ContratoCadastroExpositor;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProduto;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProdutosCarrinho;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class Fachada {

	@Autowired
	private ContratoCadastroUsuario cadastroUsuario;

	@Autowired
	private ContratoCadastroExpositor cadastroExpositor;

	@Autowired
	private ContratoCadastroProduto cadastroProduto;

	@Autowired
	private ContratoCadastroCompra cadastroCompra;

	@Autowired
	private ContratoCadastroCarrinho cadastroCarrinho;

	@Autowired
	private ContratoCadastroProdutosCarrinho cadastroProdutoCarrinho;

	// usuario
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) throws CadastroUsuarioException {
		return this.cadastroUsuario.cadastrarUsuario(usuario);
	}

	public void removerUsuarioPorID(Long id) throws CadastroUsuarioException {
		this.cadastroUsuario.deletarUsuario(id);
	}

	public UsuarioEntity atualizarUsuario(UsuarioEntity usuario) throws CadastroUsuarioException {
		return this.cadastroUsuario.atualizarUsuario(usuario);
	}

	public List<UsuarioEntity> listarUsuarios() {
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
		return this.cadastroExpositor.atualizarExpositor(expositor);
	}

	public List<UsuarioExpositorEntity> listarExpositores() {
		return this.cadastroExpositor.listarExpositores();
	}

	public UsuarioExpositorEntity buscarUsuarioExpositorPorID(Long id) throws CadastroExpositorException {
		return this.cadastroExpositor.buscarUsuarioExpositorPorID(id);
	}

	// produto
	public ProdutoEntity cadastrarProduto(ProdutoEntity produto) throws CadastroProdutoException {
		return this.cadastroProduto.cadastrarProduto(produto);
	}

	public ProdutoEntity buscarProdutoPorID(Long id) throws CadastroProdutoException {
		return this.cadastroProduto.buscarProdutoPorId(id);
	}

	public ProdutoEntity buscarProdutoPorNome(String nome) throws CadastroProdutoException {
		return this.cadastroProduto.buscarProdutoPorNome(nome);
	}

	public List<ProdutoEntity> listarProdutos() throws CadastroProdutoException {
		return this.cadastroProduto.listarProdutos();
	}

	public ProdutoEntity atualizarProduto(ProdutoEntity produto) throws CadastroProdutoException {
		return this.cadastroProduto.atualizarProduto(produto);
	}

	public void removerProduto(ProdutoEntity produto) throws CadastroProdutoException {
		this.cadastroProduto.removerProduto(produto);
	}

	// compra

	public CompraEntity finalizarCompra(Long idCarrinho, Long idUsuario) throws CompraNaoPodeSerFinalizadaException {

		CarrinhoEntity carrinhoExistente;
		try {
			carrinhoExistente = cadastroCarrinho.pegarCarrinho(idUsuario);
		} catch (CarrinhoException e) {
			carrinhoExistente = new CarrinhoEntity();
			UsuarioEntity usuario = cadastroUsuario.buscarUsuarioPorID(idUsuario);
			if (usuario == null) {
				throw new CompraNaoPodeSerFinalizadaException("Usuário não encontrado.");
			}
			carrinhoExistente.setUsuarioCarrinho(usuario);
			carrinhoExistente = cadastroCarrinho.salvarCarrinho(carrinhoExistente);
		}

		if (carrinhoExistente.getProdutosCarrinho() == null || carrinhoExistente.getProdutosCarrinho().isEmpty()) {
			throw new CompraNaoPodeSerFinalizadaException("O carrinho está vazio.");
		}

		CompraEntity compra = new CompraEntity();
		compra.setCarrinho(carrinhoExistente);
		compra.setDataCompra(LocalDate.now());
		compra.setValorTotal(compra.calcularValorTotal());
		compra.setStatus(StatusCompra.CONCLUIDA);

		return cadastroCompra.cadastrarCompra(compra);
	}

	public CompraEntity cadastrarCompra(CompraEntity compra) {
		return this.cadastroCompra.cadastrarCompra(compra);
	}

	public CompraEntity buscarCompraPorID(Long id) {
		return this.cadastroCompra.buscarCompraPorId(id);
	}

	public List<CompraEntity> listarCompras() {
		return this.cadastroCompra.listarCompras();
	}

	public CompraEntity atualizarCompra(CompraEntity compra) {
		return this.cadastroCompra.atualizarCompra(compra);
	}

	public void removerCompra(Long id) {
		this.cadastroCompra.removerCompra(id);
	}

	// carrinho
	public CarrinhoEntity adicionarProdutoCarrinho(Long id, int quantidade, Long idUsuario)
			throws CarrinhoException, CadastroProdutoException {

		if (quantidade <= 0) {
			throw new CarrinhoException("A quantidade de produtos selecionados é inválida");
		}

		try {

			CarrinhoEntity veriCarrinhoExistente = cadastroCarrinho.pegarCarrinho(idUsuario);
			ProdutoEntity produtoSelecionado = cadastroProduto.buscarProdutoPorId(id);
			List<ProdutosCarrinhoEntity> produtosUser = veriCarrinhoExistente.getProdutosCarrinho();

			// sessão pra verificar se o produto ja ta no carrinho, pra n ter muitos
			// produtos iguais e atualizar a quantidade apenas

			boolean produtoJaNoCarrinho = false;
			for (ProdutosCarrinhoEntity produtoCarrinhoUsuario : produtosUser) {

				if (produtoCarrinhoUsuario.getProduto().equals(produtoSelecionado)) {
					produtoCarrinhoUsuario
							.setQuantidadeDeProdutos(produtoCarrinhoUsuario.getQuantidadeDeProdutos() + quantidade);
					produtoJaNoCarrinho = true;
					break;

				}
			}
			if (!produtoJaNoCarrinho) {
				ProdutosCarrinhoEntity novoProdutoCarrinho = new ProdutosCarrinhoEntity(produtoSelecionado, quantidade);
				veriCarrinhoExistente.getProdutosCarrinho().add(novoProdutoCarrinho);

			}

			return cadastroCarrinho.salvarCarrinho(veriCarrinhoExistente);

		} catch (CarrinhoException e) {

			// criar um novo carrinho

			ProdutoEntity produtoSelecionado = cadastroProduto.buscarProdutoPorId(id);
			ProdutosCarrinhoEntity novoProdutoCarrinho = new ProdutosCarrinhoEntity(produtoSelecionado, quantidade);
			UsuarioEntity usuarioCadastrado = cadastroUsuario.buscarUsuarioPorID(idUsuario);
			CarrinhoEntity salvarCarrinho = new CarrinhoEntity(novoProdutoCarrinho, usuarioCadastrado);
			return cadastroCarrinho.salvarCarrinho(salvarCarrinho);
		}

	}

	public CarrinhoEntity pegarCarrinho(Long idUsuario) throws CarrinhoNaoEncontradoException {

		try {
			CarrinhoEntity verificarCarrinho = cadastroCarrinho.pegarCarrinho(idUsuario);
			return verificarCarrinho;

		} catch (Exception e) {
			throw new CarrinhoNaoEncontradoException("Carrinho infelizmente não foi encontrado!");
		}

	}

	public List<ProdutosCarrinhoEntity> listarProdutosCarrinho(Long id) throws CarrinhoNaoEncontradoException {
		CarrinhoEntity veriCarrinhoExistente = cadastroCarrinho.pegarCarrinho(id);

		if (veriCarrinhoExistente == null) {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado para o ID do usuário: " + id);
		}

		return veriCarrinhoExistente.getProdutosCarrinho();
	}
	
	

}
