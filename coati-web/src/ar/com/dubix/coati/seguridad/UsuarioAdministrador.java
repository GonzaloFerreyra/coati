package ar.com.dubix.coati.seguridad;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class UsuarioAdministrador extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioAdministrador() {
	}

	public UsuarioAdministrador(String nombreUsuario, String password,
			String validacionPassword, String nombre, String email,
			String telefono) throws UsuarioException {
		super(nombreUsuario, password, validacionPassword, nombre, email,
				telefono);
	}
}
