package ar.com.dubix.coati.empresa;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.dubix.coati.facturacion.CategoriaFiscal;
import ar.com.dubix.coati.facturacion.CategoriaFiscalResponsableInscripto;

public class EmpresaTest {

	private static Empresa instance;
	private static final String nombre = "Empresa";
	private static final String razonSocial = "Razon Social";
	private static final String cuit = "20-23929955-6";
	private static final String direccion = "Calle";
	private static final String codigoPostal = "3000";
	private static final String nombreLocalidad = "Santa Fe";
	private static final String nombreProvincia = "Santa Fe";
	private static final CategoriaFiscal categoriaFiscal = 
			CategoriaFiscalResponsableInscripto.getInstance();

	@Test
	public void crear() throws Exception {
		try {
			new Empresa(null, null, null, null, null, null, null, null);
			fail("Debe fallar porque el nombre es nulo");
		} catch (NombreEmpresaException nee) {
		}
		try {
			new Empresa("", null, null, null, null, null, null, null);
			fail("Debe fallar porque el nombre esta vacío");
		} catch (NombreEmpresaException nee) {
		}
		try {
			new Empresa(" ", null, null, null, null, null, null, null);
			fail("Debe fallar porque el nombre esta vacío");
		} catch (NombreEmpresaException nee) {
		}

		try {
			new Empresa(nombre, null, null, null, null, null, null, null);
			fail("Debe fallar porque la razón social es nulo");
		} catch (RazonSocialException ree) {
		}
		try {
			new Empresa(nombre, "", null, null, null, null, null, null);
			fail("Debe fallar porque el nombre esta vacío");
		} catch (RazonSocialException nee) {
		}
		try {
			new Empresa(nombre, " ", null, null, null, null, null, null);
			fail("Debe fallar porque la razón social esta vacío");
		} catch (RazonSocialException nee) {
		}

		try {
			new Empresa(nombre, razonSocial, cuit, null, null, null, null, null);
			fail("Debe fallar porque la dirección es nula");
		} catch (DireccionEmpresaException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, "", null, null, null, null);
			fail("Debe fallar porque la dirección esta vacía");
		} catch (DireccionEmpresaException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, " ", null, null, null, null);
			fail("Debe fallar porque la dirección esta vacía");
		} catch (DireccionEmpresaException ree) {
		}

		try {
			new Empresa(nombre, razonSocial, cuit, direccion, null, null, null, null);
			fail("Debe fallar porque el código postal es nulo");
		} catch (CodigoPostalEmpresaException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, direccion, "", null, null, null);
			fail("Debe fallar porque el código postal esta vacío");
		} catch (CodigoPostalEmpresaException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, direccion, " ", null, null, null);
			fail("Debe fallar porque el código postal esta vacío");
		} catch (CodigoPostalEmpresaException ree) {
		}

		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, null,
					null, null);
			fail("Debe fallar porque la localidad es nula");
		} catch (LocalidadException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, "",
					null, null);
			fail("Debe fallar porque la localidad esta vacía");
		} catch (LocalidadException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, " ",
					null, null);
			fail("Debe fallar porque la localidad esta vacía");
		} catch (LocalidadException ree) {
		}

		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, 
					nombreLocalidad, null, null);
			fail("Debe fallar porque la provincia es nula");
		} catch (ProvinciaException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, 
					nombreLocalidad, "", null);
			fail("Debe fallar porque la provincia esta vacía");
		} catch (ProvinciaException ree) {
		}
		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, 
					nombreLocalidad, "  ", null);
			fail("Debe fallar porque la provincia esta vacía");
		} catch (ProvinciaException ree) {
		}

		try {
			new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, 
					nombreLocalidad, nombreProvincia, null);
			fail("Debe fallar porque categoría fiscal es nula");
		} catch (CategoriaFiscalException ree) {
		}
	
		instance = new Empresa(nombre, razonSocial, cuit, direccion, codigoPostal, 
				nombreLocalidad, nombreProvincia, categoriaFiscal);
		assertEquals(nombre, instance.getNombre());
		assertEquals(razonSocial, instance.getRazonSocial());
		assertEquals(cuit, instance.getCuit());
		assertEquals(direccion, instance.getDirección());
		assertEquals(codigoPostal, instance.getCodigoPostal());
		assertEquals(nombreLocalidad, instance.getNombreLocalidad());
		assertEquals(nombreProvincia, instance.getNombreProvincia());
		assertEquals(categoriaFiscal.getDescripcion(), instance.getCategoriaFiscal());
	}
}
