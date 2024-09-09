package br.com.atelieufape.negocio.cadastro.exception;

public class CadastroUsuarioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CadastroUsuarioException(String msgErro) {
		super(msgErro);
	}
	
}
