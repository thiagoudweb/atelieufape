package br.com.atelieufape.negocio.basico;

import java.util.ArrayList;
import java.util.List;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_EXPOSITOR")
public class UsuarioExpositorEntity extends UsuarioAbstract {

	// Construtor padrão

	public UsuarioExpositorEntity(String nome, String sobrenome, String cpf, String rg, String senha, String email,
			Long id, String nomeLoja, String emailLoja, double saldoLoja) {
		super(nome, sobrenome, cpf, rg, senha, email, id);
		this.nomeLoja = nomeLoja;
		this.emailLoja = emailLoja;
		this.saldoLoja = saldoLoja;
		this.produtosExpositor = new ArrayList<>();

	}

	public UsuarioExpositorEntity() {
		super();
	}

	private String nomeLoja;
	private String emailLoja;
	private double saldoLoja;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProdutoEntity> produtosExpositor;

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
