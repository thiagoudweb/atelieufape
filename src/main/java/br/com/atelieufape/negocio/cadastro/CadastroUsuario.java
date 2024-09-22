package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.UsuarioDados;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;
// Autor: Thiago Silva
// Essa classe é responsável por salvar o cadastro inicial do usuário. Tem suas lógicas básicas de validação.
@Service
public class CadastroUsuario implements ContratoCadastroUsuario {

	// construtor //
	@Autowired
	private UsuarioDados usuarioDados;

	public CadastroUsuario(UsuarioDados usuarioDados) {
		this.usuarioDados = usuarioDados;
	}

	// metodos opersonalizados//
	@Override
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {

		Optional<UsuarioEntity> verificarCpf = usuarioDados.findByCpf(usuario.getCpf());

		if (verificarCpf.isPresent()) {
			throw new CadastroUsuarioException("Erro! O usuário ja esta cadastrado no sistema!");
		} else {
			return usuarioDados.save(usuario);
		}

	}

//	@Override
//	public void removerUsuario(UsuarioEntity usuario) {
//
//		if (usuarioDados.existsById(usuario.getId())) {
//
//			usuarioDados.deleteById(usuario.getId());
//		} else {
//			throw new CadastroUsuarioException("Erro ao tentar remover usuário");
//		}
//
//	}

	@Override
	public UsuarioEntity atualizarUsuario(UsuarioEntity usuario) {

		Optional<UsuarioEntity> verificarCpf = usuarioDados.findById(usuario.getId());

		if (verificarCpf.isPresent()) {
			return usuarioDados.save(usuario);
		}

		else {

			throw new CadastroUsuarioException("Usuário não encontrado");
		}

	}

	@Override
	public void deletarUsuario(Long ID) {

		Optional<UsuarioEntity> verificarUsuario = usuarioDados.findById(ID);

		if (verificarUsuario.isPresent()) {
			usuarioDados.deleteById(ID);
		}

		else {
			throw new CadastroUsuarioException("Usuário não encontrado!");
		}
	}

	@Override
	public List<UsuarioEntity> listarUsuarios() {

		try {
			List<UsuarioEntity> usuarios = usuarioDados.findAll();

			return usuarios;

		} catch (CadastroUsuarioException e) {

			throw new CadastroUsuarioException("Não existe usuários cadastrados!");
		}
	}

	@Override
	public UsuarioEntity buscarUsuarioPorID(Long id) {

		Optional<UsuarioEntity> usuarioBuscado = usuarioDados.findById(id);

		if (usuarioBuscado.isPresent()) {
			return usuarioBuscado.get();
		}

		else {

			throw new CadastroUsuarioException("Usuario não encontrado!");
		}

	}

}
