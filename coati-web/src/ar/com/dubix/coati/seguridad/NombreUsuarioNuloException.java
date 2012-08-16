package ar.com.dubix.coati.seguridad;

public class NombreUsuarioNuloException extends UsuarioException {

	public NombreUsuarioNuloException() {
		super("Debe suministrar el nombre de usuario.");
	}
}
