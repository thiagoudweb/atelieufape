package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.UsuarioEntity;

public interface ContratoCadastroUsuario {

	public void cadastrarUsuario(UsuarioEntity usuario);

	public void RemoverUsuario(UsuarioEntity usuario);

	public void AtualizarUsuario(UsuarioEntity usuario);

	public void DeletarUsuario(UsuarioEntity usuario);

	public UsuarioEntity BuscarUsuario(UsuarioEntity usuario);

}
