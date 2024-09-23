package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
// Autor: Thiago Silva
// Essa classe é responsável por instanciar e iniciar o objeto usuario comum no sistema!
@Entity
@Table(name = "TABELA_USUARIO")
public class UsuarioEntity extends UsuarioAbstract {

	public UsuarioEntity(String nome, String sobrenome, String cpf, String rg, String senha, String email, Long id) {
		super(nome, sobrenome, cpf, rg, senha, email, id);

	}

	public UsuarioEntity() {
		super();
	}

}
