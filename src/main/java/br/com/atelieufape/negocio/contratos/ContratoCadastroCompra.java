package br.com.atelieufape.negocio.contratos;

import br.com.atelieufape.negocio.basico.CompraEntity;
import java.util.List;

// Autor: Tiago José
// Essa interface define o contrato para as operações relacionadas ao gerenciamento de compras.
// Ela especifica os métodos que devem ser implementados por qualquer classe que queira manipular
public interface ContratoCadastroCompra {
    CompraEntity cadastrarCompra(CompraEntity compra);

    CompraEntity buscarCompraPorId(Long id);

    List<CompraEntity> listarCompras();

    CompraEntity atualizarCompra(CompraEntity compra);

    void removerCompra(Long id);
}
