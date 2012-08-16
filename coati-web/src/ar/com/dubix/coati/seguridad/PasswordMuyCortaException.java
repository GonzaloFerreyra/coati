package ar.com.dubix.coati.seguridad;

public class PasswordMuyCortaException extends UsuarioException {

	public PasswordMuyCortaException() {
		super("La contraseña debe contener más de 6 caracteres.");
	}
}
