package br.com.atelieufape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.StatusCompra;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Autor: Tiago José
// Essa classe é responsável por realizar testes unitários na entidade `CompraEntity`.
// Ela valida o comportamento do construtor da classe `CompraEntity`,
@SpringBootTest
public class CompraEntityTest {

    private UsuarioExpositorEntity usuarioExpositor;
    private ProdutoEntity produto;
    private List<ProdutoEntity> produtos;
    private LocalDate dataCompra;
    private double valorTotal;
    private StatusCompra status;

    @BeforeEach
    public void setUp() {
        // Criando instâncias reais para os testes
        usuarioExpositor = new UsuarioExpositorEntity();
        produto = new ProdutoEntity();
        produtos = List.of(produto);

        // Configuração inicial dos dados
        dataCompra = LocalDate.of(2024, 9, 20);
        valorTotal = 59.90;
        status = StatusCompra.CONCLUIDA;
    }

    @Test
    public void testCompraEntityConstrutor() {
        // Criando uma nova instância de CompraEntity
        CompraEntity compra = new CompraEntity(dataCompra, valorTotal, status, usuarioExpositor, produtos);

        // Verificando os valores
        assertEquals(dataCompra, compra.getDataCompra());
        assertEquals(valorTotal, compra.getValorTotal());
        assertEquals(status, compra.getStatus());
        assertEquals(usuarioExpositor, compra.getUsuarioExpositor());
        assertEquals(produtos, compra.getProdutos());
    }
}
