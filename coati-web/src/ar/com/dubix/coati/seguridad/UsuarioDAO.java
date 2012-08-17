package ar.com.dubix.coati.seguridad;

import com.googlecode.objectify.Objectify;

import ar.com.dubix.coati.dao.CoatiDAO;


public class UsuarioDAO extends CoatiDAO {

	public static UsuarioAdministrador crearUsuarioAdministrador(
			final String nombreUsuario, final String password,
			final String validacionPassword, final String nombre,
			final String email, final String telefono)
			throws UsuarioException {
        Objectify ofy = CoatiDAO.getObjectifyService();
        Usuario guardado = ofy.query(Usuario.class).
        		filter("nombreUsuario", nombreUsuario).get();
        if (guardado != null) {
        	throw new NombreUsuarioYaExisteException(nombreUsuario);
        }
        UsuarioAdministrador nuevo = new UsuarioAdministrador(nombreUsuario, 
        		password, validacionPassword, nombre, email, telefono);
        ofy.put(nuevo);
        return nuevo;
	}
}
