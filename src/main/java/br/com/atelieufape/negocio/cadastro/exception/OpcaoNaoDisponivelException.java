package br.com.atelieufape.negocio.cadastro.exception;

public class OpcaoNaoDisponivelException extends CarrinhoException {
	private static final long serialVersionUID = 1L;

	public OpcaoNaoDisponivelException(String msgErro) {
		super(msgErro);
	}

}
