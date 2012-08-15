package ar.com.dubix.coati.cliente;

public class CodigoPostalClienteException extends ClienteException {

	public CodigoPostalClienteException() {
		super("Debe suministrar el código postal del cliente.");
	}

}
