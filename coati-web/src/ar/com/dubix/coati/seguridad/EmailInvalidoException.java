package ar.com.dubix.coati.seguridad;

public class EmailInvalidoException extends UsuarioException {

	public EmailInvalidoException() {
		super("El email ingresado es inválido.");
	}

}
