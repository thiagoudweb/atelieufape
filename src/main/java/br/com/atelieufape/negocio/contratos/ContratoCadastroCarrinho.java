package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.CarrinhoEntity;

public interface ContratoCadastroCarrinho {

	public CarrinhoEntity salvarCarrinho(CarrinhoEntity carrinho);

	public void deletarCarrinhoPorId(Long id);

	public CarrinhoEntity atualizarCarrinho(CarrinhoEntity carrinho);

	public CarrinhoEntity pegarCarrinho(Long id);
}
