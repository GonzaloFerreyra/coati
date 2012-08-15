package ar.com.dubix.coati.cliente;

public class CuitClienteException extends ClienteException {

	public CuitClienteException() {
		super("Debe suministrar el cuit del cliente.");
	}
}
