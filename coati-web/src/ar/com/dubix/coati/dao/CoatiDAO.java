package ar.com.dubix.coati.dao;

import ar.com.dubix.coati.cliente.Cliente;
import ar.com.dubix.coati.producto.Producto;
import ar.com.dubix.coati.seguridad.Usuario;
import ar.com.dubix.coati.seguridad.UsuarioAdministrador;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CoatiDAO {

    static {
        try {
            ObjectifyService.register(Producto.class);
            ObjectifyService.register(Cliente.class);
            ObjectifyService.register(Usuario.class);
            ObjectifyService.register(UsuarioAdministrador.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Objectify getObjectifyService() {
        Objectify ofy = ObjectifyService.begin();
        return ofy;
    }
}
