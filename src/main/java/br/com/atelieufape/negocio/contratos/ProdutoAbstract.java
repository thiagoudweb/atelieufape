package br.com.atelieufape.negocio.contratos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProdutoAbstract {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private double preco;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private String condicao;
	@Column(nullable = false)
	private String marca;
	@Column(nullable = false)
	private int quantidade;
	
	//construtor
	public ProdutoAbstract(String nome, double preco, String descricao, String condicao, String marca, int quantidade) {
		
		super();
		
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.condicao = condicao;
		this.marca = marca;
		this.quantidade = quantidade;
	}

	//getters e setters
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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

	public void setPreco(double preco) {
		this.preco = preco;
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

}