package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import java.util.List;

public interface ContratoCadastroProdutosCarrinho {

	public ProdutosCarrinhoEntity salvarProdutosCarrinho(ProdutosCarrinhoEntity produtos);

	public ProdutosCarrinhoEntity deletarProdutosCarrinho(Long id);

	public ProdutosCarrinhoEntity atualizarProdutosCarrinho(ProdutosCarrinhoEntity produtos);

	public List<ProdutosCarrinhoEntity> listarProdutosCarrinho();

}
