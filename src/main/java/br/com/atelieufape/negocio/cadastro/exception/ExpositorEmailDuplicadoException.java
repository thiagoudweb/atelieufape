package br.com.atelieufape.negocio.cadastro.exception;

public class ExpositorEmailDuplicadoException extends RuntimeException {
    public ExpositorEmailDuplicadoException(String message) {
        super(message);
    }
}