package ar.com.dubix.coati.dao;

import ar.com.dubix.coati.cliente.Cliente;
import ar.com.dubix.coati.producto.Producto;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CoatiDAO {

    static {
        try {
//            System.out.println("Inicio registro de clases");
            ObjectifyService.register(Producto.class);
//            System.out.println("Registro de clase Producto");
            ObjectifyService.register(Cliente.class);
//            System.out.println("Registro de clase Cliente");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Objectify getObjectifyService() {
        Objectify ofy = ObjectifyService.begin();
        return ofy;
    }
}
