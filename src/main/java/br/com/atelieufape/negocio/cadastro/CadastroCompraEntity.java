package br.com.atelieufape.negocio.cadastro;

import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.dados.CompraDados;
import br.com.atelieufape.negocio.contratos.ContratoCadastroCompra;
import br.com.atelieufape.negocio.cadastro.exception.CompraNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroCompraEntity implements ContratoCadastroCompra {

    @Autowired
    private CompraDados compraDados;

    @Override
    public CompraEntity cadastrarCompra(CompraEntity compra) {
        return compraDados.save(compra);
    }

    @Override
    public CompraEntity buscarCompraPorId(Long id) {
        return compraDados.findById(id)
            .orElseThrow(() -> new CompraNaoEncontradaException("Compra não encontrada!"));
    }

    @Override
    public List<CompraEntity> listarCompras() {
        return compraDados.findAll();
    }

    @Override
    public CompraEntity atualizarCompra(CompraEntity compra) {
        if (!compraDados.existsById(compra.getId())) {
            throw new CompraNaoEncontradaException("Compra não encontrada!");
        }
        return compraDados.save(compra);
    }

    @Override
    public void removerCompra(Long id) {
        if (!compraDados.existsById(id)) {
            throw new CompraNaoEncontradaException("Compra não encontrada!");
        }
        compraDados.deleteById(id);
    }
}
