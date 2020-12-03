package br.com.confidencecambio.javabasico.exception;

public class InvalidNameException extends IllegalArgumentException {

	private static final long serialVersionUID = -8970252406145320221L;

	public InvalidNameException(final String errorMessage, final Throwable err) {
		super(errorMessage, err);
	}
}