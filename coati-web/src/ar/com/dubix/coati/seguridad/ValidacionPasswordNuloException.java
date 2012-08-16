package ar.com.dubix.coati.seguridad;

public class ValidacionPasswordNuloException extends UsuarioException {

	public ValidacionPasswordNuloException() {
		super("Debe suministrar la verificación de la contraseña.");
	}

}
