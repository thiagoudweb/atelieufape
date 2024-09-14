package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_EXPOSITOR")
public class UsuarioExpositorEntity extends UsuarioAbstract {

	// Construtor padrão

	public UsuarioExpositorEntity(String nome, String sobrenome, String cpf, String rg, String senha,
			String email) {
		super(nome, sobrenome, cpf, rg, senha, email);

	}

	private String nomeLoja;
	private String emailLoja;
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
