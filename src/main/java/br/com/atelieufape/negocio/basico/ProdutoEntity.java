package br.com.atelieufape.negocio.basico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_PRODUTO")
public class ProdutoEntity {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private double preco;

	@Column(nullable = false)
	private String categoria;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String condicao;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "expositor_id", nullable = false)
	private UsuarioExpositorEntity expositor;
	// o produto aq n vai precisar saber onde ele ta senddo colocado no carrinho.
	// relacionamento unidirecional..
	// @OneToOne
	// private ProdutosCarrinhoEntity produtoNoCarrinho;

	// construtor padrão
	public ProdutoEntity() {
	}

	// construtor com todos os atributos
	public ProdutoEntity(Long id, String nome, double preco, String categoria, String descricao, String condicao,
			String marca, int quantidade, ProdutosCarrinhoEntity produtosNoCarrinho) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.condicao = condicao;
		this.marca = marca;
		this.quantidade = quantidade;
		// this.produtoNoCarrinho = produtosNoCarrinho;
	}

	// getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	// public ProdutosCarrinhoEntity getProdutoNoCarrinho() {
	// return produtoNoCarrinho;
	// }
	//
	// public void setProdutoNoCarrinho(ProdutosCarrinhoEntity produtoNoCarrinho) {
	// this.produtoNoCarrinho = produtoNoCarrinho;
	// }

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	// fizar a categoria para deixar o usuario limitado a 3 opç~çoes
	public void setCategoria(String categoria) {
		if (Categoria.CATEGORIAS_PERMITIDAS.contains(categoria)) {
			this.categoria = categoria;
		} else {
			throw new IllegalArgumentException("A categoria " + categoria + " não é válida.");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public UsuarioExpositorEntity getExpositor() {
		return expositor;
	}

	public void setExpositor(UsuarioExpositorEntity expositor) {
		this.expositor = expositor;
	}

	// método tostring
	@Override
	public String toString() {
		return "ProdutoEntity [id=" + id + ", nome=" + nome + ", preco=" + preco + ", categoria=" + categoria
				+ ", descricao=" + descricao + ", condicao=" + condicao + ", marca=" + marca + ", quantidade="
				+ quantidade + "]";
	}
}
