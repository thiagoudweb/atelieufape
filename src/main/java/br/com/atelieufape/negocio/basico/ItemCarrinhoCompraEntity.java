package br.com.atelieufape.negocio.basico;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "ITEM_CARRINHO_COMPRA")
public class ItemCarrinhoCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relação com ProdutoEntity
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produto;

    // Quantidade do produto
    @Column(nullable = false)
    private int quantidade;

    // Preço unitário no momento da adição ao carrinho ou compra
    @Column(nullable = false)
    private double precoUnitario;

    // Relação opcional com CarrinhoEntity
    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    @JsonBackReference
    private CarrinhoEntity carrinho;

    // Relação opcional com CompraEntity
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    // Construtor padrão
    public ItemCarrinhoCompraEntity() {
    }

    // Construtor para item na compra

    public ItemCarrinhoCompraEntity(ProdutoEntity produto, int quantidade, double precoUnitario,
            CarrinhoEntity carrinho) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.carrinho = carrinho;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public CarrinhoEntity getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoEntity carrinho) {
        this.carrinho = carrinho;
    }

    public CompraEntity getCompra() {
        return compra;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }
}
