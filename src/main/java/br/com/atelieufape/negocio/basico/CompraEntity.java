package br.com.atelieufape.negocio.basico;

import jakarta.persistence.*;
import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "usuario_expositor_id", nullable = false)
    private UsuarioExpositorEntity usuarioExpositor;

    @ManyToMany
    @JoinTable(
        name = "compra_produto",
        joinColumns = @JoinColumn(name = "compra_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoEntity> produtos;

    public CompraEntity() {
    }

    // Construtor
    public CompraEntity(LocalDate dataCompra, double valorTotal, StatusCompra status, UsuarioExpositorEntity usuarioExpositor, List<ProdutoEntity> produtos) {
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
        this.status = status;
        this.usuarioExpositor = usuarioExpositor;
        this.produtos = produtos;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UsuarioExpositorEntity getUsuarioExpositor() {
        return usuarioExpositor;
    }

    public void setUsuarioExpositor(UsuarioExpositorEntity usuarioExpositor) {
        this.usuarioExpositor = usuarioExpositor;
    }

    public List<ProdutoEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEntity> produtos) {
        this.produtos = produtos;
    }
}
