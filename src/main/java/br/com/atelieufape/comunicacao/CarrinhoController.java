package br.com.atelieufape.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.atelieufape.negocio.cadastro.exception.CadastroProdutoException;
import br.com.atelieufape.negocio.cadastro.exception.CarrinhoException;
import br.com.atelieufape.negocio.fachada.Fachada;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private Fachada fachada;

	@PostMapping("/addProdutoCarrinho")
	public ResponseEntity<?> adicionarProdutoCarrinho (@PathVariable Long id, @RequestParam int quantidade ){
		try {
			 fachada.adicionarProdutoCarrinho(id, quantidade);
			 return ResponseEntity.ok("Produto adicionado ao carrinho");
			
		} catch (CarrinhoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (CadastroProdutoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
