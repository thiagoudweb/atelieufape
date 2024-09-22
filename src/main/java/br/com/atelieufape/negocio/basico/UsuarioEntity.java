package br.com.atelieufape.negocio.basico;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.atelieufape.negocio.contratos.UsuarioAbstract;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_USUARIO")
public class UsuarioEntity extends UsuarioAbstract {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrinho_id", referencedColumnName = "id")
	@JsonManagedReference
	private CarrinhoEntity carrinho;

	public UsuarioEntity(String nome, String sobrenome, String cpf, String rg, String senha, String email, Long id) {
		super(nome, sobrenome, cpf, rg, senha, email, id);

	}

	public UsuarioEntity() {
		super();
	}

	public CarrinhoEntity getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoEntity carrinho) {
		this.carrinho = carrinho;
	}

}
