package br.com.atelieufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.fachada.Fachada;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private Fachada fachada;

	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutoEntity produto){
		try {
			fachada.cadastrarProduto(produto);
			return ResponseEntity.ok("Produto cadastrado com sucesso!");
		}catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar o produto!");
		}	
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarProdutoPorID(@PathVariable Long id){
		try {
			return ResponseEntity.ok(fachada.buscarProdutoPorID(id));
		}catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body("Produto não encontrado!");
		}
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProdutoEntity>> listarProdutos() throws CadastroProdutoException{
		return ResponseEntity.ok(fachada.listarProdutos());
	}
	
	@PatchMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarProduto(@PathVariable Long id, 
			@RequestBody ProdutoEntity produto){
		try {
			produto.setId(id);
			fachada.atualizarProduto(produto);
			return ResponseEntity.ok("Produto atualizado com sucesso!");
		}catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao atualizar o produto!");
		}
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<String> removerProduto(@PathVariable Long id){
		try {
			ProdutoEntity produto = fachada.buscarProdutoPorID(id);
			fachada.removerProduto(produto);
			return ResponseEntity.ok("Produto removido com sucesso!");
		}catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao remover o produto!");
		}
	}
}