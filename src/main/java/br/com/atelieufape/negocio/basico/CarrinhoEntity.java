package br.com.atelieufape.negocio.basico;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//Autor: Thiago Silva
// Essa classe é responsável moldar a entidade ( tabela do carrinho ) no banco de dados, visando a persistência do carrinho do(s) usuario(s).
@Entity
@Table(name = "TABELA_CARRINHO")
public class CarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuarioCarrinho;
	@OneToMany(mappedBy = "carrinhoUsuario", cascade = CascadeType.ALL)
	private List<ProdutosCarrinhoEntity> produtosCarrinho;
	private double saldoProdutos;

	// construtor padrão //
	public CarrinhoEntity() {
	}

	// construtor com atributis//
	public CarrinhoEntity(Long id, UsuarioEntity usuarioCarrinho, List<ProdutosCarrinhoEntity> produtosCarrinho) {

		this.id = id;
		this.usuarioCarrinho = usuarioCarrinho;
		this.produtosCarrinho = produtosCarrinho;
	}

	// construtor para iniciar objeto //
	public CarrinhoEntity(ProdutosCarrinhoEntity produtoNovo,UsuarioEntity usuarioCarrinho) {
		this.produtosCarrinho = new ArrayList<>();
		this.produtosCarrinho.add(produtoNovo);
		this.usuarioCarrinho = usuarioCarrinho;
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

	public void setProdutosCarrinho(ProdutosCarrinhoEntity produtosCarrinho) {
		this.produtosCarrinho.add(produtosCarrinho);
	}

	public double getSaldoProdutos() {
		return saldoProdutos;
	}

	public void setSaldoProdutos(double saldoProdutos) {
		this.saldoProdutos = saldoProdutos;
	}

}
