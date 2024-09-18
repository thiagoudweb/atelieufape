package br.com.atelieufape.negocio.cadastro.exception;

public class ListarUsuarioException extends UsuarioException {
	private static final long serialVersionUID = 1L;

	public ListarUsuarioException(String msgErro) {
		super(msgErro);
	}
}
