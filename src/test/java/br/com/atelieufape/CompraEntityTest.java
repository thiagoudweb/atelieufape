package br.com.atelieufape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.ItemCarrinhoCompraEntity;
import br.com.atelieufape.negocio.basico.StatusCompra;
import br.com.atelieufape.negocio.basico.UsuarioEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompraEntityTest {

    private UsuarioEntity cliente;
    private ProdutoEntity produto;
    private ItemCarrinhoCompraEntity itemCompra;
    private List<ItemCarrinhoCompraEntity> itensCompra;
    private LocalDate dataCompra;
    private double valorTotal;
    private StatusCompra status;

    @BeforeEach
    public void setUp() {
        cliente = new UsuarioEntity();
        cliente.setId(1L);
        cliente.setNome("Cliente Teste");
        produto = new ProdutoEntity();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setPreco(59.90);
        itemCompra = new ItemCarrinhoCompraEntity(produto, 1, produto.getPreco(), null);
        itensCompra = List.of(itemCompra);
        dataCompra = LocalDate.of(2024, 9, 20);
        valorTotal = 59.90;
        status = StatusCompra.CONCLUIDA;
    }

    @Test
    public void testCompraEntityConstrutor() {
        // Criando uma nova instância de CompraEntity
        CompraEntity compra = new CompraEntity(dataCompra, valorTotal, status, cliente, itensCompra);

        // Verificando os valores
        assertEquals(dataCompra, compra.getDataCompra());
        assertEquals(valorTotal, compra.getValorTotal());
        assertEquals(status, compra.getStatus());
        assertEquals(cliente, compra.getCliente());
        assertEquals(itensCompra, compra.getItensCompra());
    }
}