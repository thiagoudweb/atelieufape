package br.com.atelieufape;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;

//Autor: Thiago Silva
//Teste unitário: Aqui eu testo o cadastro do usuario, testando apenas os objetos que moldam as entidades do usuario.
public class UsuarioTesteUnitario {

	private ContratoCadastroUsuario usuario;

	@Test
	public void cadastrarUsuario() {
		Long idUsuario = 2L;
		UsuarioEntity usuarioTest = new UsuarioEntity();
		usuarioTest.setId(idUsuario);
		usuarioTest.setNome("Usuário Teste");

		UsuarioEntity teste = usuario.cadastrarUsuario(usuarioTest);
		assertNotNull(teste);
	}

	@Test
	public void atualizarUsuario() {
		Long idUsuario = 2L;
		UsuarioEntity usuarioTest = new UsuarioEntity();
		usuarioTest.setId(idUsuario);
		usuarioTest.setNome("Usuário Teste");

		UsuarioEntity teste = usuario.atualizarUsuario(usuarioTest);
		assertNotNull(teste);
	}

	@Test
	public void deletarUsuario() {

		Long idUsuario = 2L;
		UsuarioEntity usuarioTest = new UsuarioEntity();
		usuarioTest.setId(idUsuario);
		usuarioTest.setNome("Usuário Teste");

		UsuarioEntity teste = usuario.cadastrarUsuario(usuarioTest);
		usuario.deletarUsuario(idUsuario);
		assertNotNull(teste);
	}

	@Test
	public void listarUsuario() {

		Long idUsuario = 2L;
		UsuarioEntity usuarioTest = new UsuarioEntity();
		usuarioTest.setId(idUsuario);
		usuarioTest.setNome("Usuário Teste");
		UsuarioEntity teste = usuario.cadastrarUsuario(usuarioTest);
		List<UsuarioEntity> testeListagem = usuario.listarUsuarios();

		assertNotNull(testeListagem);
	}

	public void deletarUsuarioPorId() {
		Long idUsuario = 2L;
		UsuarioEntity usuarioTest = new UsuarioEntity();
		usuarioTest.setId(idUsuario);
		usuarioTest.setNome("Usuário Teste");

		UsuarioEntity teste = usuario.cadastrarUsuario(usuarioTest);
		usuario.buscarUsuarioPorID(idUsuario);
	}

}
