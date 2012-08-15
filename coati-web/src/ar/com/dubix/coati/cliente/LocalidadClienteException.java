package ar.com.dubix.coati.cliente;

public class LocalidadClienteException extends ClienteException {

	public LocalidadClienteException() {
		super("Debe suministrar la localidad del cliente");
	}
}
