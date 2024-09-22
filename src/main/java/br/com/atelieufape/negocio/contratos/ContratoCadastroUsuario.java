package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.UsuarioEntity;
//Autor: Thiago Silva
//Essa classe é responsável por manter um contrato de integridade com a classe de cadastro do usuario, visando a padronização e ecapsulamento do codigo.
public interface ContratoCadastroUsuario {

	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario);

//	public void removerUsuario(UsuarioEntity usuario);

	public UsuarioEntity atualizarUsuario(UsuarioEntity usuario);

	public void deletarUsuario(Long ID);

	public List<UsuarioEntity> listarUsuarios();

	public UsuarioEntity buscarUsuarioPorID(Long id);

}
