package br.com.atelieufape.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoNaoEncontradoException;
import br.com.atelieufape.negocio.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private Fachada fachada;

    @Operation(summary = "Adicionar produto ao carrinho", description = "Adicionar um produto ao carrinho")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto adicionado ao carrinho!"),
        @ApiResponse(responseCode = "400", description = "Produto ja ta no carrinho!", content = @Content(schema = @Schema(implementation = String.class)))
    })
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

    @Operation(summary = "Pegar carrinho por ID", description = "Pega um carrinho existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Carrinho encontrado!"),
        @ApiResponse(responseCode = "400", description = "Cartinho n encontrado!", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/pegarCarrinho/{id}")
    public ResponseEntity<?> pegarCarrinho(@PathVariable Long id) {
        try {
            // Método para pegar o carrinho (ainda não retornado)
            fachada.pegarCarrinho(id);
            return ResponseEntity.ok("Carrinho aqui!");
        } catch (CarrinhoNaoEncontradoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Listar produtos do carrinho", description = "Lista todos os produtos de um carrinho")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produtos do carrinho listados!"),
        @ApiResponse(responseCode = "400", description = "Carrinho n encontrado!", content = @Content(schema = @Schema(implementation = String.class)))
    })
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
