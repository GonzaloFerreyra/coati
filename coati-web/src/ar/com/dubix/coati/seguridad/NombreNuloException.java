package ar.com.dubix.coati.seguridad;


public class NombreNuloException extends UsuarioException {

	public NombreNuloException() {
		super("Debe suministrar el nombre del usuario.");
	}
}
