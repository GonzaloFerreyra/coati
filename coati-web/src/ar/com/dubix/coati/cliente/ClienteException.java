package ar.com.dubix.coati.cliente;

public abstract class ClienteException extends Exception {

	ClienteException(final String mensaje) {
		super(mensaje);
	}
}
