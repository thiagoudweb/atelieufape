package br.com.atelieufape.negocio.basico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_PRODUTO")
public class ProdutoEntity {

    //atributos
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

    //construtor padrao
    public ProdutoEntity() {
    }

    //construtor com atributos

    public ProdutoEntity(String nome, double preco, String descricao, String condicao, String marca, int quantidade) {
        this.nome = nome;
        this.preco = preco;

    public ProdutoEntity(String nome, double preco, String categoria, String descricao, String condicao, String marca, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.setCategoria(categoria);

        this.descricao = descricao;
        this.condicao = condicao;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    //getters e setters
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

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getDescricao() {

	public String getCategoria() {
		return categoria;
	}

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
}