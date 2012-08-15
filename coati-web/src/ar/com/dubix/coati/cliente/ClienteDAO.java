package ar.com.dubix.coati.cliente;

import ar.com.dubix.coati.dao.CoatiDAO;
import ar.com.dubix.coati.dao.DAOException;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

/**
 *
 * @author gferreyra
 */
public class ClienteDAO 
        extends CoatiDAO {

    public static Cliente buscarOCrearCliente(final String nombre,
            final String codigo, final String domicilio,
            final String condicionIVA, final String numeroLista,
            final String localidad, final String provincia,
            final String codigoPostal, final String cuit,
            final String diaDeVisita)
    		throws ClienteException {

        Objectify ofy = CoatiDAO.getObjectifyService();
        Cliente cliente = ofy.query(Cliente.class).
                filter("codigo", codigo).get();
        if (cliente != null) {
            //fixme debe modificar los datos
            return cliente;
        }

        Cliente clientenuevo = new Cliente(nombre, codigo, domicilio, condicionIVA,
                numeroLista, localidad, provincia, codigoPostal, cuit, diaDeVisita);
        ofy.put(clientenuevo);
        return clientenuevo;
    }
    
    public static void borrarCliente(final Long id, final String codigo) throws DAOException {

        Objectify ofy = CoatiDAO.getObjectifyService();
    	Cliente cliente;
    	if (id != null) {
    		cliente = ofy.get(new Key<Cliente>(Cliente.class, id));
    		if (cliente == null) {
    			throw new DAOException(null, "No se pudo encontrar el cliente con id " + id);
    		}
			ofy.delete(cliente);
    	} else if (codigo != null) {
    		//TODO: buscar por codigo
    	} else {
    		throw new DAOException(null, "Debe suministrar un id de cliente o " +
    				"un código de cliente para poder borrarlo.");
    	}
    }
}
