package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.UsuarioDados;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class CadastroUsuario implements ContratoCadastroUsuario {

	@Autowired
	private UsuarioDados usuarioDados;

	@Override
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {

		if (usuarioDados.existsById(usuario.getId()) != true) {

			return usuarioDados.save(usuario);
		}

		else {
			throw new CadastroUsuarioException("Erro! O usuário ja esta cadastrado no sistema!");
		}

	}

	@Override
	public void RemoverUsuario(UsuarioEntity usuario) {

		if (usuarioDados.existsById(usuario.getId())) {

			usuarioDados.deleteById(usuario.getId());
		}

		else {
			throw new CadastroUsuarioException("Erro ao tentar remover usuário");
		}

	}

	@Override
	public UsuarioEntity AtualizarUsuario(UsuarioEntity usuario) {

		if (usuarioDados.existsById(usuario.getId())) {
			return usuarioDados.save(usuario);
		}

		else {

			throw new CadastroUsuarioException("Usuário não encontrado");
		}

	}

	@Override
	public void DeletarUsuario(Long ID) {

		if (usuarioDados.existsById(ID)) {
			usuarioDados.deleteById(ID);
		}

		else {
			throw new CadastroUsuarioException("Usuário não encontrado!");
		}
	}

	@Override
	public List<UsuarioEntity> ListarUsuarios() {

		try {
			List<UsuarioEntity> usuarios = usuarioDados.findAll();

			return usuarios;

		} catch (Exception e) {

			throw new CadastroUsuarioException("Usuario ja existe!");
		}
	}

	@Override
	public UsuarioEntity BuscarUsuarioPorID(Long id) {

		Optional<UsuarioEntity> usuarioBuscado = usuarioDados.findById(id);

		if (usuarioBuscado.isPresent()) {
			return usuarioBuscado.get();
		}

		else {
			throw new CadastroUsuarioException("Usuario não encontrado!");
		}

	}

	// metodos especiais //
	public UsuarioDados getUsuarioDados() {
		return usuarioDados;
	}

	public void setUsuarioDados(UsuarioDados usuarioDados) {
		this.usuarioDados = usuarioDados;
	}

}
