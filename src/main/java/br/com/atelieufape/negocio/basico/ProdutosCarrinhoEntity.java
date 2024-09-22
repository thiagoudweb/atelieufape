package br.com.atelieufape.negocio.basico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//Autor: Thiago Silva
//Essa classe é responsável moldar a entidade ( tabela do produto do carrinho ) no banco de dados. Ela consiste em organizar, alem do produto, sua quantidade, a soma do valor final para finalizar compra, a quantidade dos itens que o usuario selecionou ( pra evitar duplicidade no codigo ). ela concentra todas as informações do produto, alem do produto em sí!
@Entity
@Table(name = "PRODUTOS_CARRINHO")
public class ProdutosCarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ProdutoEntity produto;
	private int quantidadeDeProdutos;
	private double valorproduto;
	@ManyToOne
	private CarrinhoEntity carrinhoUsuario;

	// construtor com atributos //

	public ProdutosCarrinhoEntity(Long id, ProdutoEntity produto, int quantidadeDeProdutos, double valorFinal,
			CarrinhoEntity carrinhoUsuario) {

		this.id = id;
		this.produto = produto;
		this.quantidadeDeProdutos = quantidadeDeProdutos;
		this.valorproduto = produto.getPreco();
		this.carrinhoUsuario = carrinhoUsuario;
	}

	// construtor para iniciar objeto //
	public ProdutosCarrinhoEntity(ProdutoEntity produto, int quantidade) {
		this.produto = produto;
		this.quantidadeDeProdutos = quantidade;
	}

	// construtor padrão //

	public ProdutosCarrinhoEntity() {

	}

	// metodos especiais //
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public int getQuantidadeDeProdutos() {
		return quantidadeDeProdutos;
	}

	public void setQuantidadeDeProdutos(int quantidadeDeProdutos) {
		this.quantidadeDeProdutos = quantidadeDeProdutos;
	}

	public double getValorFinal() {
		return valorproduto;
	}

	public void setValorFinal(double valorFinal) {
		this.valorproduto = valorFinal;
	}

	public CarrinhoEntity getCarrinhoUsuario() {
		return carrinhoUsuario;
	}

	public void setCarrinhoUsuario(CarrinhoEntity carrinhoUsuario) {
		this.carrinhoUsuario = carrinhoUsuario;
	}

}
