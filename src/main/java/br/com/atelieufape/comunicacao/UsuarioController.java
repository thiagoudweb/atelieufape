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
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.cadastro.exception.UsuarioException;
import br.com.atelieufape.negocio.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

//Autor: Thiago Silva
//Controller responsável por fazer o cadastro inicial do usuario, caso ele opte por ser um usuario comum.
@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private Fachada fachada;


	@Operation(summary = "Cadastra usuário", description = "Cadastra um novo usuário no sistema.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Usuário já existe!", content = @Content(schema = @Schema(implementation = String.class))) })
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
		try {
			fachada.cadastrarUsuario(usuario);
			return ResponseEntity.ok("Usuário cadastrado com sucesso!");
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Operation(summary = "Atualiza um usuário", description = "Atualiza os dados de um usuário pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Erro ao atualizar o usuário!", content = @Content(schema = @Schema(implementation = String.class))) })
	@PatchMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {

		try {

			UsuarioEntity user = usuario;
			user.setId(id);
			fachada.atualizarUsuario(user);
			return ResponseEntity.ok("O usuário " + user.getNome() + " foi atualizado");

		} catch (UsuarioException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Operation(summary = "Busca usuário por ID", description = "Busca os dados de um usuário pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Erro ao buscar o usuário!", content = @Content(schema = @Schema(implementation = String.class))) })
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarUsuarioPorID(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(fachada.buscarUsuarioPorID(id));
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Operation(summary = "Deleta usuário", description = "Remove um usuário pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Erro ao deletar o usuário!", content = @Content(schema = @Schema(implementation = String.class))) })
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarUsuarioPorID(@PathVariable Long id) {

		try {

			fachada.removerUsuarioPorID(id);
			return ResponseEntity.ok("Usuário deletado com sucesso!");

		} catch (UsuarioException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Operation(summary = "Lista todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de usuários recuperada com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Erro ao recuperar a lista de usuários!", content = @Content(schema = @Schema(implementation = String.class))) })
	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuarios() {
		try {
			return ResponseEntity.ok(fachada.listarUsuarios());
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
