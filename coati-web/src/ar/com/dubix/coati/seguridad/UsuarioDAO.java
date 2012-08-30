package ar.com.dubix.coati.seguridad;

import com.googlecode.objectify.Objectify;

import ar.com.dubix.coati.dao.CoatiDAO;


public class UsuarioDAO extends CoatiDAO {

	public static UsuarioAdministrador crearUsuarioAdministrador(
			final String nombreUsuario, final String password,
			final String validacionPassword, final String nombre,
			final String email, final String telefono)
			throws UsuarioException {
		java.util.Date iniciando = new java.util.Date();
		System.out.println("Iniciando 'nuevoAdministrador' en " + iniciando.getTime() +
				"...");
        Objectify ofy = getObjectifyService();
        Usuario guardado = ofy.query(Usuario.class).
        		filter("nombreUsuario", nombreUsuario).get();
        if (guardado != null) {
    		java.util.Date finalizando = new java.util.Date();
    		NombreUsuarioYaExisteException ex = new NombreUsuarioYaExisteException(nombreUsuario);
    		System.out.println("Error: " + ex.getMessage() + " en " + finalizando.getTime() +
    				"...");
        	throw ex;
        }
        UsuarioAdministrador nuevo = new UsuarioAdministrador(nombreUsuario, 
        		password, validacionPassword, nombre, email, telefono);
        ofy.put(nuevo);
		java.util.Date finalizando = new java.util.Date();
		System.out.println("Finalizando 'nuevoAdministrador' en " + finalizando.getTime() +
				"...");
        return nuevo;
	}
}
