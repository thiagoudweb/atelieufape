package br.com.atelieufape.comunicacao;

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

import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.cadastro.exception.UsuarioException;
import br.com.atelieufape.negocio.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private Fachada fachada;

    @Operation(summary = "Cadastra um novo usuário", description = "Cadastra um novo usuário no sistema.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso."),
			@ApiResponse(responseCode = "400", description = "Erro ao cadastrar o usuário.", content = @Content)
	})
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
		try {
			CarrinhoEntity carrinho = new CarrinhoEntity();
			usuario.setCarrinho(carrinho);

			fachada.cadastrarUsuario(usuario);
			return ResponseEntity.ok("Usuário cadastrado com sucesso!");
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @Operation(summary = "Atualiza um usuário.", description = "Atualiza um usuário específico pelo ID.")
 	@ApiResponses(value = {
 			@ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso."),
 			@ApiResponse(responseCode = "400", description = "Erro ao atualizar o usuário.", content = @Content)
 	})
	@PatchMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {

		try {

			UsuarioEntity user = usuario;
			user.setId(id);
			fachada.atualizarUsuario(user);
			return ResponseEntity.ok("O Usuario " + user.getNome() + " foi atualizado");

		} catch (UsuarioException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @Operation(summary = "Busca um usuário por ID", description = "Retorna os detalhes de um usuário específico pelo seu ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class))),
			@ApiResponse(responseCode = "400", description = "Usuário não encontrado.", content = @Content)
	})
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarUsuarioPorID(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(fachada.buscarUsuarioPorID(id));
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @Operation(summary = "Remove um usuário.", description = "Remove um usuário específico pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário removido com sucesso."),
			@ApiResponse(responseCode = "400", description = "Erro ao remover o usuário.", content = @Content)
	})
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarUsuarioPorID(@PathVariable Long id) {

		try {

			fachada.removerUsuarioPorID(id);
			return ResponseEntity.ok("Usuario deletado com sucesso!");

		} catch (UsuarioException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @Operation(summary = "Lista todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados.")
   	@ApiResponse(responseCode = "200", description = "Lista de expositores retornada com sucesso.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraEntity.class)))
	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuarios() {
		try {
			return ResponseEntity.ok(fachada.listarUsuarios());
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
