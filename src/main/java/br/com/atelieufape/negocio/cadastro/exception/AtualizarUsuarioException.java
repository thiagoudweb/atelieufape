package br.com.atelieufape.negocio.cadastro.exception;

public class AtualizarUsuarioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AtualizarUsuarioException(String msgErro) {
        super(msgErro);
    }

}
