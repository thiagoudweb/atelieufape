package br.com.atelieufape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;

//Autor: Luiza Marques
//Esta classe é responsável por testar o produto.
public class ProdutoEntityTest {
	
	ProdutoEntity produto = new ProdutoEntity();
	
	@Test
    void testCategoriaValida() {
        produto.setCategoria("Roupa");
        assertEquals("Roupa", produto.getCategoria());
    }

    @Test
    void testCategoriaInvalida() {
        try {
            produto.setCategoria("Eletrônico");
            fail("Deveria ter lançado uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("A categoria não é válida.", e.getMessage());
        }
    }

    @Test
    void testPreco() {
        produto.setPreco(100.50);
        assertEquals(100.50, produto.getPreco());
    }

    @Test
    void testQuantidade() {
        produto.setQuantidade(10);
        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void testToString() {
    	//criando um expositor para teste
        UsuarioExpositorEntity expositor = new UsuarioExpositorEntity();
        ProdutoEntity produto = new ProdutoEntity(1L, "Anel de prata", 99.99, "Acessório", "Anel prateado",
                "Novo", "Marca XYZ", 5, expositor);
        String saidaEsperada = "ProdutoEntity [id=1, nome=Anel de prata, preco=99.99, categoria=Acessório, "
        		+ "descricao=Anel prateado, condicao=Novo, marca=Marca XYZ, quantidade=5]";
        assertEquals(saidaEsperada, produto.toString());
    }

}