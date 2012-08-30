package ar.com.dubix.coati.empresa;

import com.googlecode.objectify.Objectify;

import ar.com.dubix.coati.dao.CoatiDAO;
import ar.com.dubix.coati.facturacion.CategoriaFiscal;

public class EmpresaDAO extends CoatiDAO {

	public static Empresa crearEmpresa(final String nombre, final String razonSocial,
			final String cuit, final String direccion, final String codigoPostal,
			final String localidad, final String provincia,
			final String nombreCategoriaFiscal)
			throws EmpresaException {
		Objectify ofy = getObjectifyService();
        Empresa guardada = ofy.query(Empresa.class).filter("nombre", nombre).get();
        if (guardada != null) {
        	throw new NombreEmpresaYaExisteException(nombre);
        }
		
		CategoriaFiscal categoriaFiscal = ofy.get(CategoriaFiscal.class,
				nombreCategoriaFiscal);
		Empresa empresa = new Empresa(nombre, razonSocial, cuit, direccion,
				codigoPostal, localidad, provincia, categoriaFiscal);
		ofy.put(empresa);
		return empresa;
	}

}
