package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "TABELA_EXPOSITOR")
public class UsuarioExpositorEntity extends UsuarioAbstract {

	public UsuarioExpositorEntity(String nome, String sobrenome, String cpf, String rg, String login, String senha, String email) {
		super(nome, sobrenome, cpf, rg, login, senha, email);
		
	}
	@Column(unique = true, nullable = false)
	private String nomeLoja;
	@Column(unique = true, nullable = false)
	private String emailLoja;
	@Column(nullable = false)
	private double saldoLoja;
	
	
}
