package ar.com.dubix.coati.seguridad;

public class NombreUsuarioYaExisteException extends UsuarioException {

	public NombreUsuarioYaExisteException(String nombreUsuario) {
		super("El nombre de usuario " + nombreUsuario + " ya ha sido utilizado.");
	}

}
