package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.UsuarioDados;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class CadastroUsuario implements ContratoCadastroUsuario {

	@Autowired
	private UsuarioDados usuarioDados;

	@Override
	public void cadastrarUsuario(UsuarioEntity usuario) {

		try {

			if (usuarioDados.existsById(usuario.getId()) != true) {
				usuarioDados.save(usuario);
			}
		} catch (Exception e) {
			throw new RuntimeException("Usuario ja existe!");
		}
	}

	@Override
	public void RemoverUsuario(UsuarioEntity usuario) {
		try {
			if (usuarioDados.existsById(usuario.getId())) {

				usuarioDados.deleteById(usuario.getId());
			}
		} catch (Exception e) {

			throw new RuntimeException("Usuario não econtrado.");
		}
	}

	@Override
	public void AtualizarUsuario(UsuarioEntity usuario) {
		try {

			if (usuarioDados.existsById(usuario.getId())) {
				usuarioDados.save(usuario);
			}
		} catch (Exception e) {
			throw new RuntimeException("Usuario não econtrado.");
		}
	}

	@Override
	public void DeletarUsuario(Long ID) {
		try {

			if (usuarioDados.existsById(ID)) {
				usuarioDados.deleteById(ID);
			}
		} catch (Exception e) {
			throw new RuntimeException("Usuario não econtrado.");
		}
	}

	@Override
	public List<UsuarioEntity> ListarUsuarios() {

		try {
			List<UsuarioEntity> usuarios = usuarioDados.findAll();

			return usuarios;
		} catch (Exception e) {
			throw new RuntimeException("Não há usuários cadastrado.");
		}
	}

	@Override
	public UsuarioEntity BuscarUsuarioPorID(Long id) {
		
		Optional<UsuarioEntity> usuarioBuscado = usuarioDados.findById(id);

		if (usuarioBuscado.isPresent()) {
			return usuarioBuscado.get();
		}

		else {
			throw new RuntimeException("Usuário não encontrado.");
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
