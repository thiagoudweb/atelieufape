package br.com.atelieufape.comunicacao;

import br.com.atelieufape.negocio.basico.CompraEntity;
import br.com.atelieufape.negocio.fachada.Fachada;
import br.com.atelieufape.negocio.cadastro.exception.CompraDuplicadaException;
import br.com.atelieufape.negocio.cadastro.exception.CompraNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
@CrossOrigin(origins = "http://localhost:3000/")
public class CompraController {

    @Autowired
    private Fachada fachada;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarCompra(@RequestBody CompraEntity compra) {
        try {
            fachada.cadastrarCompra(compra);
            return ResponseEntity.ok("Compra cadastrada com sucesso!");
        } catch (CompraDuplicadaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarCompraPorID(@PathVariable Long id) {
        try {
            CompraEntity compra = fachada.buscarCompraPorID(id);
            return ResponseEntity.ok(compra);
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CompraEntity>> listarCompras() {
        List<CompraEntity> compras = fachada.listarCompras();
        return ResponseEntity.ok(compras);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerCompra(@PathVariable Long id) {
        try {
            fachada.removerCompra(id);
            return ResponseEntity.ok("Compra removida com sucesso!");
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
