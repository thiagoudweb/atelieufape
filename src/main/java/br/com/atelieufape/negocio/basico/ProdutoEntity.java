package br.com.atelieufape.negocio.basico;

import br.com.atelieufape.negocio.contratos.ProdutoAbstract;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_PRODUTO")
public class ProdutoEntity extends ProdutoAbstract {

	public ProdutoEntity(String nome, double preco, String descricao, String condicao, String marca, int quantidade) {
		super(nome, preco, descricao, condicao, marca, quantidade);
	}
	
}