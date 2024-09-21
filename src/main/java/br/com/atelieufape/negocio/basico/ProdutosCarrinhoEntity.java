package br.com.atelieufape.negocio.basico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
