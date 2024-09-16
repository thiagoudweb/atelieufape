package br.com.atelieufape.negocio.contratos;

import java.util.List;

import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;

public interface ContratoCadastroProduto {
	
	public ProdutoEntity cadastrarProduto(ProdutoEntity produto) throws CadastroProdutoException;
	
	public ProdutoEntity atualizarProduto(ProdutoEntity produto) throws CadastroProdutoException;
	
	public void excluirProduto(ProdutoEntity produto) throws CadastroProdutoException;
	
	public void excluirProduto(Long id) throws CadastroProdutoException;
	
	public List<ProdutoEntity> listarProdutos() throws CadastroProdutoException;
	
	public ProdutoEntity buscarProdutoPorNome (String nome) throws CadastroProdutoException;
	
	public ProdutoEntity buscarProdutoPorId(Long id) throws CadastroProdutoException;
	
}