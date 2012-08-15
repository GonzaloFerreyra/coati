package ar.com.dubix.coati.cliente;

public class DomicilioClienteException extends ClienteException {

	DomicilioClienteException() {
		super("El cliente debe tener un domicilio.");
	}
}
