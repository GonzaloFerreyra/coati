package ar.com.dubix.coati.seguridad;

public abstract class UsuarioException extends Exception {
	
	public UsuarioException(final String mensaje) {
		super(mensaje);
	}
}
