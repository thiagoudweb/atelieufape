package br.com.atelieufape.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.dados.ProdutoDados;
import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProduto;

@Service
public class CadastroProduto implements ContratoCadastroProduto {

	//construtor
	@Autowired
	private ProdutoDados produtoDados;
	
	//getters e setters
	public ProdutoDados getProdutoDados() {
		return produtoDados;
	}

	public void setProdutoDados(ProdutoDados produtoDados) {
		this.produtoDados = produtoDados;
	}

	//metodos personalizados
	@Override
	public ProdutoEntity cadastrarProduto(ProdutoEntity produto) throws CadastroProdutoException {
		
		Optional<ProdutoEntity> verificarNome = produtoDados.findByNome(produto.getNome());
		
		if(verificarNome.isPresent())
			throw new CadastroProdutoException("Um produto com esse nome já existe no sistema!");
		else
			return produtoDados.save(produto);
	}

	@Override
	public ProdutoEntity atualizarProduto(ProdutoEntity produto) throws CadastroProdutoException {
		
		if(produtoDados.existsById(produto.getId()))
			return produtoDados.save(produto);
		else
			throw new CadastroProdutoException("Produto não encontrado.");
	}

	@Override
	public void excluirProduto(ProdutoEntity produto) throws CadastroProdutoException {

		if(produtoDados.exists(produto))
			produtoDados.delete(produto);
		else
			throw new CadastroProdutoException("Produto não encontrado!");
		
	}

	@Override
	public void excluirProduto(Long id) throws CadastroProdutoException {

		if(produtoDados.existsById(id))
			produtoDados.deleteById(id);
		else
			throw new CadastroProdutoException("Produto não encontrado!");
		
	}

	@Override
	public List<ProdutoEntity> listarProdutos() throws CadastroProdutoException {
		
		try {
			List<ProdutoEntity> produtos = produtoDados.findAll();
			return produtos;
			
		} catch(Exception e) {
			throw new CadastroProdutoException("Erro ao listar os produtos, tente novamente mais tarde!");
		}

	}

	@Override
	public ProdutoEntity buscarProdutoPorId(Long id) throws CadastroProdutoException {
		
		Optional<ProdutoEntity> produtoBuscado = produtoDados.findById(id);
		
		if (produtoBuscado.isPresent())
			return produtoBuscado.get();
		else
			throw new CadastroProdutoException("Produto não encontrado!");
		
	}

	@Override
	public ProdutoEntity buscarProdutoPorNome(String nome) throws CadastroProdutoException {

		Optional<ProdutoEntity> produtoBuscado = produtoDados.findByNome(nome);
		
		if (produtoBuscado.isPresent())
			return produtoBuscado.get();
		else
			throw new CadastroProdutoException("Produto não encontrado!");
		
	}

}