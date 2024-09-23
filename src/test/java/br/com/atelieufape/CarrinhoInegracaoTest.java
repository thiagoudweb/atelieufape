package br.com.atelieufape;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoNaoEncontradoException;
import br.com.atelieufape.negocio.fachada.Fachada;
import jakarta.transaction.Transactional;

// Autor: Thiago Silva
// Teste de integração do carrinho :Aqui eu faço a verificação de todas as funcionalidades do carrinho como um todo, desde add produtos até a removação e etc.
@SpringBootTest
@Transactional
public class CarrinhoInegracaoTest {

	@Autowired
	private Fachada fachada;

	@BeforeEach
	public void salvarCarrinhoTeste() throws CarrinhoException, CadastroProdutoException {
		// Configuração dos dados do teste
		Long idProduto = 1L;
		Long idUsuario = 2L;
		int quantidade = 2;
		// produtp
		ProdutoEntity produtoTest = new ProdutoEntity();
		produtoTest.setId(idProduto);
		produtoTest.setNome("Produto Teste");
		// usuario
		UsuarioEntity usuarioTest = new UsuarioEntity();
		usuarioTest.setId(idUsuario);
		usuarioTest.setNome("Usuário Teste");

		ProdutosCarrinhoEntity produtosTest = new ProdutosCarrinhoEntity();
		produtosTest.setProduto(produtoTest);
		produtosTest.setQuantidadeDeProdutos(quantidade);

		CarrinhoEntity teste = fachada.adicionarProdutoCarrinho(idUsuario, quantidade, idUsuario);

		assertNotNull(teste);

	}

	@Test
	public void pegarCarrinho() throws CarrinhoNaoEncontradoException {
		// usuario
		Long idUsuario = 2L;
		CarrinhoEntity teste = fachada.pegarCarrinho(idUsuario);

		assertNotNull(teste);

	}

	public void listarCarrinho() throws CarrinhoNaoEncontradoException {
		Long idUsuario = 2L;

		List<ProdutosCarrinhoEntity> teste = fachada.listarProdutosCarrinho(idUsuario);
		assertNotNull(teste);
	}

}