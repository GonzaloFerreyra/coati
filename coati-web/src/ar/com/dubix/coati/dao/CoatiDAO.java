package ar.com.dubix.coati.dao;

import ar.com.dubix.coati.cliente.Cliente;
import ar.com.dubix.coati.empresa.Empresa;
import ar.com.dubix.coati.facturacion.CategoriaFiscal;
import ar.com.dubix.coati.facturacion.CategoriaFiscalConsumidorFinal;
import ar.com.dubix.coati.facturacion.CategoriaFiscalExento;
import ar.com.dubix.coati.facturacion.CategoriaFiscalMonotributista;
import ar.com.dubix.coati.facturacion.CategoriaFiscalResponsableInscripto;
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
            ObjectifyService.register(CategoriaFiscal.class);
            ObjectifyService.register(CategoriaFiscalResponsableInscripto.class);
            ObjectifyService.register(CategoriaFiscalMonotributista.class);
            ObjectifyService.register(CategoriaFiscalConsumidorFinal.class);
            ObjectifyService.register(CategoriaFiscalExento.class);
            ObjectifyService.register(Empresa.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Objectify getObjectifyService() {
        Objectify ofy = ObjectifyService.begin();
        return ofy;
    }
}
