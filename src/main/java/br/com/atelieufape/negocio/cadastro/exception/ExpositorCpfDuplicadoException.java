package br.com.atelieufape.negocio.cadastro.exception;

public class ExpositorCpfDuplicadoException extends RuntimeException {
    public ExpositorCpfDuplicadoException(String message) {
        super(message);
    }
}