package ar.com.dubix.coati.seguridad;

public class PasswordNuloException extends UsuarioException {

	public PasswordNuloException() {
		super("Debe suministrar la contraseña.");
	}

}
