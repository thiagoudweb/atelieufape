package br.com.atelieufape.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.CarrinhoDados;
import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCarrinho;


@Service
public class CadastroCarrinhoUsuario implements ContratoCadastroCarrinho {
	
	@Autowired
	private CarrinhoDados carrinhoDados;

	@Override
	public CarrinhoEntity salvarCarrinho(CarrinhoEntity carrinho) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarCarrinhoPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarrinhoEntity atualizarCarrinho(CarrinhoEntity carrinho) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarrinhoEntity> listarCarrinhos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
