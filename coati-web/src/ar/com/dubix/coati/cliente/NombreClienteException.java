package ar.com.dubix.coati.cliente;

public class NombreClienteException extends ClienteException {

	public NombreClienteException() {
		super("El cliente debe tener un nombre");
	}
}
