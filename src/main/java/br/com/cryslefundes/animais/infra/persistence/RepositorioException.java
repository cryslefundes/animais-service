package br.com.cryslefundes.animais.infra.persistence;

public class RepositorioException extends RuntimeException {
    public RepositorioException(String message) {
        this(message, null);
    }

    public RepositorioException(String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
