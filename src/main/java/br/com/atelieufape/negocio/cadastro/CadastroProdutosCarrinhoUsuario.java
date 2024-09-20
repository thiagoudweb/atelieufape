package br.com.atelieufape.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.ProdutoCarrinhoDados;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProdutosCarrinho;


@Service
public class CadastroProdutosCarrinhoUsuario implements ContratoCadastroProdutosCarrinho {
	
	@Autowired
	private ProdutoCarrinhoDados produtosCarrinho;
	
	@Override
	public ProdutosCarrinhoEntity salvarProdutosCarrinho(ProdutosCarrinhoEntity produtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutosCarrinhoEntity deletarProdutosCarrinho(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutosCarrinhoEntity atualizarProdutosCarrinho(ProdutosCarrinhoEntity produtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutosCarrinhoEntity> listarProdutosCarrinho() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
