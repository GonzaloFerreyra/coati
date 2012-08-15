package ar.com.dubix.coati.cliente;

public class CodigoClienteException extends ClienteException {

	public CodigoClienteException() {
		super("El cliente debe tener un código");
	}
}
