package br.com.atelieufape.negocio.basico;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TABELA_COMPRA")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCompra;
    private double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusCompra status;

    // Relação com UsuarioEntity (cliente)
    @ManyToOne
    @JoinColumn(name = "usuario_cliente_id", nullable = false)
    private UsuarioEntity cliente;

    // Relação com ItemCarrinhoCompraEntity
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<ItemCarrinhoCompraEntity> itensCompra;

    // Construtor padrão
    public CompraEntity() {
        this.itensCompra = new ArrayList<>();
    }

    // Construtor com atributos
    public CompraEntity(LocalDate dataCompra, double valorTotal, StatusCompra status, UsuarioEntity cliente, List<ItemCarrinhoCompraEntity> itensCompra) {
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
        this.status = status;
        this.cliente = cliente;
        this.itensCompra = itensCompra;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusCompra getStatus() {
        return status;
    }

    public void setStatus(StatusCompra status) {
        this.status = status;
    }

    public UsuarioEntity getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioEntity cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrinhoCompraEntity> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCarrinhoCompraEntity> itensCompra) {
        this.itensCompra = itensCompra;
    }

    // Método para adicionar item à compra
    public void adicionarItem(ItemCarrinhoCompraEntity item) {
        this.itensCompra.add(item);
        item.setCompra(this);
    }
}
