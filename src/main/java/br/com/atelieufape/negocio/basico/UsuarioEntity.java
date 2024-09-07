package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(name = " TABELA_USUARIO")
public class UsuarioEntity extends UsuarioAbstract {
	
	public UsuarioEntity(String nome, String sobrenome, String cpf, String rg, String login, String senha) {
		super(nome, sobrenome, cpf, rg, login, senha);
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
