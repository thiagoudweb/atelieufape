package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.CarrinhoEntity;
// Autor: Thiago Silva
// Essa classe é responsável por manter um contrato de integridade com a classe de cadastro do carrinho, visando a padronização e ecapsulamento do codigo.
public interface ContratoCadastroCarrinho {

	public CarrinhoEntity salvarCarrinho(CarrinhoEntity carrinho);

	public void deletarCarrinhoPorId(Long id);

	public CarrinhoEntity atualizarCarrinho(CarrinhoEntity carrinho);

	public CarrinhoEntity pegarCarrinho(Long id);
}
