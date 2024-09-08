package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_USUARIO")
public class UsuarioEntity extends UsuarioAbstract {

	public UsuarioEntity(String nome, String sobrenome, String cpf, String rg, String login, String senha,
			String email) {
		super(nome, sobrenome, cpf, rg, login, senha, email);

	}

}
