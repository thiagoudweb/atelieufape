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

import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private Fachada fachada;

	@Operation(summary = "Cadastra um novo produto", description = "Cadastra um novo produto no sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Erro ao cadastrar o produto.", content = @Content)
    })
	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutoEntity produto){
		try {
			fachada.cadastrarProduto(produto);
			return ResponseEntity.ok("Produto cadastrado com sucesso!");
		}catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar o produto!");
		}	
	}
	
	@Operation(summary = "Busca um produto por ID", description = "Retorna os detalhes de um produto específico pelo seu ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado.", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class))),
        @ApiResponse(responseCode = "400", description = "Produto não encontrado.", content = @Content)
    })
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarProdutoPorID(@PathVariable Long id){
		try {
			return ResponseEntity.ok(fachada.buscarProdutoPorID(id));
		}catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body("Produto não encontrado!");
		}
	}
	
	@Operation(summary = "Busca um produtor por nome", description = "Retorna os detalhes de um produto pelo seu nome.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado.", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class))),
        @ApiResponse(responseCode = "400", description = "Produto não encontrado.", content = @Content)
    })
    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<?> buscarProdutoPorNome(@PathVariable String nome) {
        try {
            ProdutoEntity produto = fachada.buscarProdutoPorNome(nome);
            return ResponseEntity.ok(produto);
        } catch (CadastroProdutoException e) {
            return ResponseEntity.badRequest().body("Produto não encontrado!");
        }
    }
	
	@Operation(summary = "Lista todos os produtos", description = "Retorna uma lista com todos os produtos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso.", 
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class)))
	@GetMapping("/listar")
	public ResponseEntity<List<ProdutoEntity>> listarProdutos() throws CadastroProdutoException{
		return ResponseEntity.ok(fachada.listarProdutos());
	}
	
	@Operation(summary = "Atualiza um produto.", description = "Atualiza um produto específico pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Erro ao atualizar o produto.", content = @Content)
    })
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
	
	@Operation(summary = "Remove um produto.", description = "Remove um produto específico pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto removido com sucesso."),
        @ApiResponse(responseCode = "400", description = "Erro ao remover o produto.", content = @Content)
    })
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