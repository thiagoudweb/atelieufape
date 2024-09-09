package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_EXPOSITOR")
public class UsuarioExpositorEntity extends UsuarioAbstract {

	public UsuarioExpositorEntity(String nome, String sobrenome, String cpf, String rg, String login, String senha,
			String email) {
		super(nome, sobrenome, cpf, rg, login, senha, email);

	}

	@Column(unique = true, nullable = false)
	private String nomeLoja;
	@Column(unique = true, nullable = false)
	private String emailLoja;
	@Column(nullable = false)
	private double saldoLoja;

	// metodos especiais //
	
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getEmailLoja() {
		return emailLoja;
	}
	public void setEmailLoja(String emailLoja) {
		this.emailLoja = emailLoja;
	}
	public double getSaldoLoja() {
		return saldoLoja;
	}
	public void setSaldoLoja(double saldoLoja) {
		this.saldoLoja = saldoLoja;
	}
}
