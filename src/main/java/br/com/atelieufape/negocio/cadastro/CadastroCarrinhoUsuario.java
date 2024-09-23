package br.com.atelieufape.negocio.cadastro;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.CarrinhoDados;
import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoNaoEncontradoException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCarrinho;
//Autor:Thiago Silva 
// Essa classe é responsável por salvar o carrinho como um todo. utilizando salvamento cascata, os produtos do carrinho também serão salvos automaticamente.!
@Service
public class CadastroCarrinhoUsuario implements ContratoCadastroCarrinho {

	@Autowired
	private CarrinhoDados carrinhoDados;

	@Override
	public CarrinhoEntity salvarCarrinho(CarrinhoEntity carrinho) {
		return carrinhoDados.save(carrinho);
	}

	@Override
	public void deletarCarrinhoPorId(Long id) {
		carrinhoDados.deleteById(id);

	}

	@Override
	public CarrinhoEntity atualizarCarrinho(CarrinhoEntity carrinho) {
		return carrinhoDados.save(carrinho);
		
	}

	@Override
	public CarrinhoEntity pegarCarrinho(Long usuarioId) throws CarrinhoNaoEncontradoException {
	    Optional<CarrinhoEntity> carrinho = carrinhoDados.findByusuarioCarrinho_Id(usuarioId);
	    
	    if (carrinho.isPresent()) {
	        return carrinho.get();
	    } else {
	        throw new CarrinhoNaoEncontradoException("Carrinho não encontrado para o usuário.");
	    }
	}

}
