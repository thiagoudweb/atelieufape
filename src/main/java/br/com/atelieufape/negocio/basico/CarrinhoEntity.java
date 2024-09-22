package br.com.atelieufape.negocio.basico;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TABELA_CARRINHO")
public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relação com UsuarioEntity
    @ManyToOne
    @JoinColumn(name = "usuario_carrinho_id")
    @JsonBackReference
    private UsuarioEntity usuarioCarrinho;

    // Relação com ItemCarrinhoCompraEntity
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<ItemCarrinhoCompraEntity> itensCarrinho;

    private double saldoProdutos;

    // Construtor padrão
    public CarrinhoEntity() {
        this.itensCarrinho = new ArrayList<>();
    }

    // Construtor com atributos
    public CarrinhoEntity(Long id, UsuarioEntity usuarioCarrinho, List<ItemCarrinhoCompraEntity> itensCarrinho) {
        this.id = id;
        this.usuarioCarrinho = usuarioCarrinho;
        this.itensCarrinho = itensCarrinho;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public UsuarioEntity getUsuarioCarrinho() {
        return usuarioCarrinho;
    }

    public void setUsuarioCarrinho(UsuarioEntity usuarioCarrinho) {
        this.usuarioCarrinho = usuarioCarrinho;
    }

    public List<ItemCarrinhoCompraEntity> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(List<ItemCarrinhoCompraEntity> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public double getSaldoProdutos() {
        return saldoProdutos;
    }

    public void setSaldoProdutos(double saldoProdutos) {
        this.saldoProdutos = saldoProdutos;
    }

    public void adicionarItem(ItemCarrinhoCompraEntity item) {
        this.itensCarrinho.add(item);
        item.setCarrinho(this);
    }
}
