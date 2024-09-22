package br.com.atelieufape.comunicacao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.cadastro.exception.CadastroUsuarioException;
import br.com.atelieufape.negocio.fachada.Fachada;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private Fachada fachada;

    @PostMapping("/adicionarProdutoCarrinho")
    public ResponseEntity<String> adicionarProdutoCarrinho(@RequestBody Map<String, Object> payload) {
        try {
            Long usuarioId = Long.valueOf(payload.get("usuarioId").toString());
            Long produtoId = Long.valueOf(payload.get("produtoId").toString());
            int quantidade = Integer.parseInt(payload.get("quantidade").toString());

            fachada.adicionarProdutoCarrinho(usuarioId, produtoId, quantidade);
            return ResponseEntity.ok("Produto adicionado ao carrinho");
        } catch (CarrinhoException | CadastroProdutoException | CadastroUsuarioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}