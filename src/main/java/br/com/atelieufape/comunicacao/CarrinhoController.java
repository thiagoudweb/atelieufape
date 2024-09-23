package br.com.atelieufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoNaoEncontradoException;
import br.com.atelieufape.negocio.fachada.Fachada;

// Autor: Thiago Silva
// Controller responsável por fazer toda as operações que envolve o carrinho de compra, como adicionar produtos, remover, apagar itens e esvaziar carrinho.
@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private Fachada fachada;

	@PostMapping("/addProdutoCarrinho/{idProduto}")
	public ResponseEntity<?> adicionarProdutoCarrinho(@PathVariable Long idProduto, @RequestParam int quantidade,
			@RequestParam Long idUsuario) {
		try {
			fachada.adicionarProdutoCarrinho(idProduto, quantidade, idUsuario);
			return ResponseEntity.ok("Produto adicionado ao carrinho");
		} catch (CarrinhoException | CadastroProdutoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/pegarCarrinho/{id}")
	public ResponseEntity<?> pegarCarrinho(@PathVariable Long id) {

		try {

			fachada.pegarCarrinho(id);

			return ResponseEntity.ok("carrinho aqui ó");
		} catch (CarrinhoNaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/listarProdutosCarrinho/{id}")
	public ResponseEntity<?> listarProdutos(@PathVariable Long id) {
		try {
			List<ProdutosCarrinhoEntity> produtos = fachada.listarProdutosCarrinho(id);

			if (produtos.isEmpty()) {
				return ResponseEntity.ok("O carrinho está vazio.");
			}

			return ResponseEntity.ok(produtos);

		} catch (CarrinhoNaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}