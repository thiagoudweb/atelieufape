package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.CompraEntity;
import java.util.List;

public interface ContratoCadastroCompra {
    CompraEntity cadastrarCompra(CompraEntity compra);
    CompraEntity buscarCompraPorId(Long id);
    List<CompraEntity> listarCompras();
    CompraEntity atualizarCompra(CompraEntity compra);
    void removerCompra(Long id);
}
