package br.com.atelieufape;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCarrinho;

// Autor: Thiago Silva
// Teste unitário: Aqui eu realizo o teste do carrinho, verificando se ele está salvando os produtos no carrinho.
@SpringBootTest
public class CarrinhoEntityTest {

    @Autowired
    private ContratoCadastroCarrinho carrinho;

    @Test
    public void salvarCarrinhoTeste() {
        // Configuração dos dados do teste
        Long idProduto = 1L;
        Long idUsuario = 2L;
        int quantidade = 2;
        // produtp
        ProdutoEntity produtoTest = new ProdutoEntity();
        produtoTest.setId(idProduto);
        produtoTest.setNome("Produto Teste");
        // usuario
        UsuarioEntity usuarioTest = new UsuarioEntity();
        usuarioTest.setId(idUsuario);
        usuarioTest.setNome("Usuário Teste");
        
        ProdutosCarrinhoEntity produtosTest = new ProdutosCarrinhoEntity();
        produtosTest.setProduto(produtoTest);
        produtosTest.setQuantidadeDeProdutos(quantidade);

        CarrinhoEntity carrinhoEntity = new CarrinhoEntity(produtosTest,usuarioTest);
//        carrinhoEntity.setUsuarioCarrinho(usuarioTest);
//        carrinhoEntity.getProdutosCarrinho().add(produtosTest);

        CarrinhoEntity resultado = carrinho.salvarCarrinho(carrinhoEntity);


        assertNotNull(resultado);
 
    }
}