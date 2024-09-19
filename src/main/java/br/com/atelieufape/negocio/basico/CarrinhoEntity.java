package br.com.atelieufape.negocio.basico;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_CARRINHO")
public class CarrinhoEntity {
	
	@Id
	private Long id;
}
