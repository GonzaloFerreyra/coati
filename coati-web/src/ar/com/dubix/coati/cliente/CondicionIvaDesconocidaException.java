package ar.com.dubix.coati.cliente;

public class CondicionIvaDesconocidaException extends ClienteException {

	public CondicionIvaDesconocidaException() {
		super("Debe suministrar una condición de IVA válida.");
	}
}
