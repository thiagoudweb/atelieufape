package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.UsuarioEntity;

public interface ContratoCadastroUsuario {

	public void cadastrarUsuario(UsuarioEntity usuario);

	public void RemoverUsuario(UsuarioEntity usuario);

	public void AtualizarUsuario(UsuarioEntity usuario);

	public void DeletarUsuario(Long ID);
	
	public List<UsuarioEntity> ListarUsuarios ();

	public UsuarioEntity BuscarUsuarioPorID(Long id);

}
