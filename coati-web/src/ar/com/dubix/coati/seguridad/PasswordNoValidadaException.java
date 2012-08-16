package ar.com.dubix.coati.seguridad;

public class PasswordNoValidadaException extends UsuarioException {

	public PasswordNoValidadaException() {
		super("Las contraseñas suministradas no coinciden");
	}

}
