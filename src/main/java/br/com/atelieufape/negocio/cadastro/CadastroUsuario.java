package br.com.atelieufape.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.atelieufape.dados.UsuarioDados;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

public class CadastroUsuario implements ContratoCadastroUsuario {

	@Autowired
	private UsuarioDados usuarioDados;

	@Override
	public void cadastrarUsuario(UsuarioEntity usuario) {

	}

	@Override
	public void RemoverUsuario(UsuarioEntity usuario) {

	}

	@Override
	public void AtualizarUsuario(UsuarioEntity usuario) {

	}

	@Override
	public void DeletarUsuario(UsuarioEntity usuario) {

	}

	@Override
	public UsuarioEntity BuscarUsuario(UsuarioEntity usuario) {

		return usuario;
	}

	// metodos especiais //
	public UsuarioDados getUsuarioDados() {
		return usuarioDados;
	}

	public void setUsuarioDados(UsuarioDados usuarioDados) {
		this.usuarioDados = usuarioDados;
	}

}
