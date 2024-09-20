package br.com.atelieufape.negocio.cadastro.exception;

public class CarrinhoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarrinhoException(String msgErro) {
		super(msgErro);
	}

}
