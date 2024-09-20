package br.com.atelieufape.negocio.basico;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_CARRINHO")
public class CarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private UsuarioEntity usuarioCarrinho;
	@OneToMany
	private List<ProdutosCarrinhoEntity> produtosCarrinho;

	// construtor padrão
	// sempre q vcs forem criar qualquer classe de objeto, usem construtor padrão. o spring só consegue fazer o bean se tiver um construtor default explicito...!!
	public CarrinhoEntity() {
	}
	
	// construtor com atributis//
	public CarrinhoEntity(Long id, UsuarioEntity usuarioCarrinho, List<ProdutosCarrinhoEntity> produtosCarrinho) {

		this.id = id;
		this.usuarioCarrinho = usuarioCarrinho;
		this.produtosCarrinho = produtosCarrinho;
	}
	
	// metodos especiais
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuarioCarrinho() {
		return usuarioCarrinho;
	}

	public void setUsuarioCarrinho(UsuarioEntity usuarioCarrinho) {
		this.usuarioCarrinho = usuarioCarrinho;
	}

	public List<ProdutosCarrinhoEntity> getProdutosCarrinho() {
		return produtosCarrinho;
	}

	public void setProdutosCarrinho(List<ProdutosCarrinhoEntity> produtosCarrinho) {
		this.produtosCarrinho = produtosCarrinho;
	}
	
	

}
