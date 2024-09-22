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
import br.com.atelieufape.negocio.cadastro.exception.AtualizarUsuarioException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.cadastro.exception.UsuarioException;
import br.com.atelieufape.negocio.fachada.Fachada;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private Fachada fachada;

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
		try {
			fachada.cadastrarUsuario(usuario);
			return ResponseEntity.ok("Usuário cadastrado com sucesso!");
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PatchMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {

		try {

			UsuarioEntity user = usuario;
			user.setId(id);
			fachada.atualizarUsuario(user);
			return ResponseEntity.ok("O Usuario" + user.getNome() + "Atualizado");

		} catch (UsuarioException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarUsuarioPorID(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(fachada.buscarUsuarioPorID(id));
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletarUsuarioPorID(@PathVariable Long id) {

		try {

			fachada.removerUsuarioPorID(id);
			return ResponseEntity.ok("Usuario deletado com sucesso!");

		} catch (UsuarioException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuarios() {
		try {
			return ResponseEntity.ok(fachada.listarUsuarios());
		} catch (UsuarioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
