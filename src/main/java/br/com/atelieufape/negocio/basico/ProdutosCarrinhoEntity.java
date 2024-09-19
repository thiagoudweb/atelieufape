package br.com.atelieufape.negocio.basico;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUTOS_CARRINHO")
public class ProdutosCarrinhoEntity {

	@Id
	private Long id;
}
