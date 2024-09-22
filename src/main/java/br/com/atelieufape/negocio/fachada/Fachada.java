package br.com.atelieufape.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atelieufape.negocio.basico.ProdutoEntity;
import br.com.atelieufape.negocio.basico.ProdutosCarrinhoEntity;
import br.com.atelieufape.negocio.basico.UsuarioEntity;
import br.com.atelieufape.negocio.basico.UsuarioExpositorEntity;
import br.com.atelieufape.negocio.basico.CarrinhoEntity;
import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.cadastro.exception.AtualizarUsuarioException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroExpositorException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCarrinho;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCompra;
import br.com.atelieufape.negocio.contratos.ContratoCadastroExpositor;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProduto;
import br.com.atelieufape.negocio.contratos.ContratoCadastroProdutosCarrinho;
import br.com.atelieufape.negocio.contratos.ContratoCadastroUsuario;

@Service
public class Fachada {

    @Autowired
    private ContratoCadastroUsuario cadastroUsuario;

    @Autowired
    private ContratoCadastroExpositor cadastroExpositor;
    
    @Autowired
    private ContratoCadastroProduto cadastroProduto;

    @Autowired
    private ContratoCadastroCompra cadastroCompra;

    @Autowired
    private ContratoCadastroCarrinho cadastroCarrinho;

    @Autowired
    private ContratoCadastroProdutosCarrinho cadastroProdutoCarrinho;

    // usuario
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) throws CadastroUsuarioException {
        return this.cadastroUsuario.cadastrarUsuario(usuario);
    }

    public void removerUsuarioPorID(Long id ) throws CadastroUsuarioException{
        this.cadastroUsuario.deletarUsuario(id);
    }

    public UsuarioEntity atualizarUsuario(UsuarioEntity usuario) throws CadastroUsuarioException {
        return this.cadastroUsuario.atualizarUsuario(usuario);
    }

    public List<UsuarioEntity> listarUsuarios() {
        return this.cadastroUsuario.listarUsuarios();
    }

    public UsuarioEntity buscarUsuarioPorID(Long id) throws CadastroUsuarioException {
        return this.cadastroUsuario.buscarUsuarioPorID(id);
    }

    // Expositor
    public UsuarioExpositorEntity cadastrarExpositor(UsuarioExpositorEntity expositor)
            throws CadastroExpositorException {
        return this.cadastroExpositor.cadastrarExpositor(expositor);
    }

    public void removerExpositor(UsuarioExpositorEntity expositor) {
        this.cadastroExpositor.removerExpositor(expositor);
    }

    public UsuarioExpositorEntity atualizarExpositor(UsuarioExpositorEntity expositor)
            throws CadastroExpositorException {
        return this.cadastroExpositor.atualizarExpositor(expositor);
    }

    public List<UsuarioExpositorEntity> listarExpositores() {
        return this.cadastroExpositor.listarExpositores();
    }

    public UsuarioExpositorEntity buscarUsuarioExpositorPorID(Long id) throws CadastroExpositorException {
        return this.cadastroExpositor.buscarUsuarioExpositorPorID(id);
    }

    // produto
    public ProdutoEntity cadastrarProduto(ProdutoEntity produto) throws CadastroProdutoException {
        return this.cadastroProduto.cadastrarProduto(produto);
    }

    public ProdutoEntity buscarProdutoPorID(Long id) throws CadastroProdutoException {
        return this.cadastroProduto.buscarProdutoPorId(id);
    }

    public ProdutoEntity buscarProdutoPorNome(String nome) throws CadastroProdutoException {
        return this.cadastroProduto.buscarProdutoPorNome(nome);
    }

    public List<ProdutoEntity> listarProdutos() throws CadastroProdutoException {
        return this.cadastroProduto.listarProdutos();
    }

    public ProdutoEntity atualizarProduto(ProdutoEntity produto) throws CadastroProdutoException {
        return this.cadastroProduto.atualizarProduto(produto);
    }

    public void removerProduto(ProdutoEntity produto) throws CadastroProdutoException {
        this.cadastroProduto.removerProduto(produto);
    }

    // compra
    public CompraEntity cadastrarCompra(CompraEntity compra) {
        return this.cadastroCompra.cadastrarCompra(compra);
    }

    public CompraEntity buscarCompraPorID(Long id) {
        return this.cadastroCompra.buscarCompraPorId(id);
    }

    public List<CompraEntity> listarCompras() {
        return this.cadastroCompra.listarCompras();
    }

    public CompraEntity atualizarCompra(CompraEntity compra) {
        return this.cadastroCompra.atualizarCompra(compra);
    }

    public void removerCompra(Long id) {
        this.cadastroCompra.removerCompra(id);
    }

    // carrinho
    public CarrinhoEntity adicionarProdutoCarrinho(Long id, int quantidade)
            throws CarrinhoException, CadastroProdutoException {

        if (quantidade <= 0) {
            throw new CarrinhoException("A quantidade de produtos selecionados é inválida");
        } else {
            ProdutoEntity produtoSelecionado = cadastroProduto.buscarProdutoPorId(id);
            ProdutosCarrinhoEntity novoProdutoCarrinho = new ProdutosCarrinhoEntity(produtoSelecionado, quantidade);
            CarrinhoEntity salvarCarrinho = new CarrinhoEntity(novoProdutoCarrinho);
            return cadastroCarrinho.salvarCarrinho(salvarCarrinho);
        }
    }
}
