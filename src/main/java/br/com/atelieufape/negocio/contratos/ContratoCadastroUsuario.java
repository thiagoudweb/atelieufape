package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.UsuarioEntity;

public interface ContratoCadastroUsuario {

	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario);

	public void RemoverUsuario(UsuarioEntity usuario);

	public UsuarioEntity AtualizarUsuario(UsuarioEntity usuario);

	public List<UsuarioEntity> ListarUsuarios ();

	public UsuarioEntity BuscarUsuarioPorID(Long id);

}
