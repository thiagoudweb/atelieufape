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
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.ExpositorCpfDuplicadoException;
import br.com.atelieufape.negocio.cadastro.exception.ExpositorEmailDuplicadoException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/expositor")
public class ExpositorController {

    @Autowired
    private Fachada fachada;

    @Operation(summary = "Cadastra um novo expositor", description = "Cadastra um novo usuário como expositor no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expositor cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar o expositor.", content = @Content)
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarExpositor(@RequestBody UsuarioExpositorEntity expositor) {
        try {
            fachada.cadastrarExpositor(expositor);
            return ResponseEntity.ok("Expositor cadastrado com sucesso!");
        } catch (ExpositorCpfDuplicadoException | ExpositorEmailDuplicadoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Erro desconhecido: " + e.getMessage());
        }
    }

    @Operation(summary = "Cadastra um novo produto para o expositor", description = "Cadastra um novo produto associado a um expositor.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Erro ao cadastrar o produto.", content = @Content)
    })
    @PostMapping("/cadastrarProduto")
    public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutoEntity produto) {
        try {
            fachada.cadastrarProduto(produto);
            return ResponseEntity.ok("Produto cadastrado com sucesso!");
        } catch (CadastroProdutoException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar o produto!");
        }
    }

    @Operation(summary = "Busca um expositor por ID", description = "Retorna os detalhes de um expositor específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expositor encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class))),
            @ApiResponse(responseCode = "400", description = "Expositor não encontrado.", content = @Content)
    })
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarUsuarioExpositorPorID(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(fachada.buscarUsuarioExpositorPorID(id));
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Lista todos os expositores", description = "Retorna uma lista com todos os expositores cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de expositores retornada com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class)))
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioExpositorEntity>> listarExpositores() {
        return ResponseEntity.ok(fachada.listarExpositores());
    }

    @Operation(summary = "Atualiza um expositor.", description = "Atualiza um expositor específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expositor atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar o expositor.", content = @Content)
    })
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarExpositor(@PathVariable Long id,
            @RequestBody UsuarioExpositorEntity expositor) {
        try {
            expositor.setId(id);
            fachada.atualizarExpositor(expositor);
            return ResponseEntity.ok("Expositor atualizado com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Remove um expositor.", description = "Remove um expositor específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expositor removido com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao remover o expositor.", content = @Content)
    })
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerExpositor(@PathVariable Long id) {
        try {
            UsuarioExpositorEntity expositor = fachada.buscarUsuarioExpositorPorID(id);
            fachada.removerExpositor(expositor);
            return ResponseEntity.ok("Expositor removido com sucesso!");
        } catch (CadastroExpositorException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
