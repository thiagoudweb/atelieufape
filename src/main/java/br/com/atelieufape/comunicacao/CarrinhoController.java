package br.com.atelieufape.comunicacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/carrinho")
public class CarrinhoController {

}
