package br.com.atelieufape.negocio.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.atelieufape.negocio.cadastro.CadastroUsuario;

@Service
public class FachadaUsuarioComum {
	
	@Autowired
	CadastroUsuario cadastroUsuario;

	
	
}
