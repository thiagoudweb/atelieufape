package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import java.util.List;
//Autor: Thiago Silva
//Essa classe é responsável por manter um contrato de integridade com a classe de cadastro dos itens no carrinho do usuario, visando a padronização e ecapsulamento do codigo.
public interface ContratoCadastroProdutosCarrinho {

	public ProdutosCarrinhoEntity salvarProdutosCarrinho(ProdutosCarrinhoEntity produtos);

	public void deletarProdutosCarrinho(Long id);
	
	public void deletarUnidadeDeProdutos(Long id, int quant);

	public ProdutosCarrinhoEntity atualizarProdutosCarrinho(ProdutosCarrinhoEntity produtos);

	public List<ProdutosCarrinhoEntity> listarProdutosCarrinho();

}
