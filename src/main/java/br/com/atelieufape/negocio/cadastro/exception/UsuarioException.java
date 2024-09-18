package br.com.atelieufape.negocio.cadastro.exception;

public class UsuarioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UsuarioException(String msgErro) {
		super(msgErro);
	}

}
