package br.com.atelieufape.comunicacao;

import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.fachada.Fachada;
import br.com.atelieufape.negocio.cadastro.exception.CompraDuplicadaException;
import br.com.atelieufape.negocio.cadastro.exception.CompraNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins = "http://localhost:3000/")
public class CompraController {

    @Autowired
    private Fachada fachada;

    @Operation(summary = "Cadastra uma nova compra", description = "Cadastra uma nova compra no sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Compra cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Compra já existe", content = @Content)
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarCompra(
            @Parameter(description = "Detalhes da nova compra", required = true) @RequestBody CompraEntity compra) {
        try {
            fachada.cadastrarCompra(compra);
            return ResponseEntity.ok("Compra cadastrada com sucesso!");
        } catch (CompraDuplicadaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Busca uma compra por ID", description = "Retorna os detalhes de uma compra específica pelo seu ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Compra encontrada", 
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class))),
        @ApiResponse(responseCode = "400", description = "Compra não encontrada", content = @Content)
    })
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarCompraPorID(
            @Parameter(description = "ID da compra", required = true) @PathVariable Long id) {
        try {
            CompraEntity compra = fachada.buscarCompraPorID(id);
            return ResponseEntity.ok(compra);
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Lista todas as compras", description = "Retorna uma lista com todas as compras cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de compras retornada com sucesso", 
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class)))
    @GetMapping("/listar")
    public ResponseEntity<List<CompraEntity>> listarCompras() {
        List<CompraEntity> compras = fachada.listarCompras();
        return ResponseEntity.ok(compras);
    }

    @Operation(summary = "Remove uma compra", description = "Remove uma compra específica pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Compra removida com sucesso"),
        @ApiResponse(responseCode = "400", description = "Compra não encontrada", content = @Content)
    })
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerCompra(
            @Parameter(description = "ID da compra a ser removida", required = true) @PathVariable Long id) {
        try {
            fachada.removerCompra(id);
            return ResponseEntity.ok("Compra removida com sucesso!");
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
