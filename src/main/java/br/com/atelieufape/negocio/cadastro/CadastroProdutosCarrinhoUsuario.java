package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.ProdutoCarrinhoDados;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoVazioException;
import br.com.atelieufape.negocio.cadastro.exception.ItemCarrinhoNaoDisponivelException;
import br.com.atelieufape.negocio.cadastro.exception.ProdutoNaoEncontradoException;
import br.com.atelieufape.negocio.cadastro.exception.QuantidadeProdutosInvalidaException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProdutosCarrinho;

//Autor:Thiago Silva 
//Essa classe é responsável por manter o crud básico e logicas simples de alteração dos produtos dentro do carrinho. O carrinho manterá essa classe e pode utilizar ela para coletar informações finais para finalização da compra, alem da logica de add produtos.

@Service
public class CadastroProdutosCarrinhoUsuario implements ContratoCadastroProdutosCarrinho {

	@Autowired
	private ProdutoCarrinhoDados produtosCarrinho;

// cadastrar produto. aq tem uma logica simples para não duplicar o produto na tbaela do produtoscarrinhos.
	@Override
	public ProdutosCarrinhoEntity salvarProdutosCarrinho(ProdutosCarrinhoEntity produtos) {
		Optional<ProdutosCarrinhoEntity> produtoJaSalvo = produtosCarrinho.findById(produtos.getId());
		if (produtoJaSalvo.isPresent()) {

			ProdutosCarrinhoEntity produtoAtualizado = produtoJaSalvo.get();
			produtoAtualizado.setQuantidadeDeProdutos(
					produtoAtualizado.getQuantidadeDeProdutos() + produtos.getQuantidadeDeProdutos());
			return produtosCarrinho.save(produtoAtualizado);
		}

		else {
			return produtosCarrinho.save(produtos);
		}
	}

	// deletar produto: aqui eu deleto o produto de vez, ao invés de apagar unidade
	// por unidade.
	@Override
	public void deletarProdutosCarrinho(Long id) throws CarrinhoVazioException {

		Optional<ProdutosCarrinhoEntity> produtoBd = produtosCarrinho.findById(id);
		if (produtoBd.isPresent()) {

			produtosCarrinho.deleteById(id);
		}

		else {
			throw new CarrinhoVazioException("Produto não não esta no carrinho");
		}
	}

	// Aqui eu deleto o produto por unidades, pois, dentro do carrinho, contem um
	// array com um vários objetos e cada um deles é um produto e seus atributos
	// especificos.
	@Override
	public void deletarUnidadeDeProdutos(Long id, int quantRemover) throws QuantidadeProdutosInvalidaException {

		Optional<ProdutosCarrinhoEntity> produtoBd = produtosCarrinho.findById(id);

		if (produtoBd.isPresent()) {

			ProdutosCarrinhoEntity produtoAtualizado = produtoBd.get();
			int quantidadeAtual = produtoAtualizado.getQuantidadeDeProdutos();

			if (quantRemover < 0) {

				throw new QuantidadeProdutosInvalidaException("Quantidade inválida!");

			} else if (quantRemover == quantidadeAtual) {
				deletarProdutosCarrinho(id);

			}

			else {
				if (quantidadeAtual > quantRemover) {

					produtoAtualizado.setQuantidadeDeProdutos(quantidadeAtual - quantRemover);
					produtosCarrinho.save(produtoAtualizado);
				} else {
					throw new QuantidadeProdutosInvalidaException("Quantidade tem que ser maior que a atual");
				}

			}
		} else {
			throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}

	}

	@Override
	public ProdutosCarrinhoEntity atualizarProdutosCarrinho(ProdutosCarrinhoEntity produtos)
			throws ItemCarrinhoNaoDisponivelException {

		Optional<ProdutosCarrinhoEntity> produtoBd = produtosCarrinho.findById(produtos.getId());
		if (produtoBd.isPresent()) {

			return produtosCarrinho.save(produtos);
		} else {
			throw new ItemCarrinhoNaoDisponivelException("Item selecionado não disponivel");
		}
	}

	@Override
	public List<ProdutosCarrinhoEntity> listarProdutosCarrinho() throws CarrinhoVazioException {

		List<ProdutosCarrinhoEntity> listaProdutos = produtosCarrinho.findAll();
		if (listaProdutos.isEmpty()) {
			throw new CarrinhoVazioException(" O seu carrinho está vazio");
		} else {

			return listaProdutos;

		}
	}

}
