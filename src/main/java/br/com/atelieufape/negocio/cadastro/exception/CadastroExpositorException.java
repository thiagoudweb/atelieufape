package br.com.atelieufape.negocio.cadastro.exception;

public class CadastroExpositorException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CadastroExpositorException(String msgErro) {
		super(msgErro);
	}
	
}
