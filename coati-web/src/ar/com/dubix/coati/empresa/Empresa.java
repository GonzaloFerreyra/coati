package ar.com.dubix.coati.empresa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import ar.com.dubix.coati.facturacion.CategoriaFiscal;
import ar.com.dubix.coati.util.StringUtil;

import com.googlecode.objectify.annotation.Unindexed;

@Entity
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nombre;
	private String razonSocial;
	private String cuit;
	@Unindexed
	private String direccion;
	@Unindexed
	private String codigoPostal;
	@Unindexed
	private String nombreLocalidad;
	@Unindexed
	private String nombreProvincia;
	@Unindexed
	private String categoriaFiscal;

	/**
	 * Constructor para Objectify
	 */
	@SuppressWarnings("unused")
	private Empresa() {
	}

	public Empresa(final String nombre, final String razonSocial,
			final String cuit, final String direccion,
			final String codigoPostal, final String localidad,
			final String provincia, final CategoriaFiscal categoriaFiscal)
			throws EmpresaException {
		definirNombre(nombre);
		definirRazonSocial(razonSocial);
		this.cuit = cuit; // fixme!
		definirDireccion(direccion);
		definirCodigoPostal(codigoPostal);
		definirLocalidad(localidad);
		definirProvincia(provincia);
		definirCategoriaFiscal(categoriaFiscal);
	}

	private void definirCodigoPostal(final String codigoPostal)
			throws CodigoPostalEmpresaException {
		CodigoPostalEmpresaException nee = (CodigoPostalEmpresaException) StringUtil
				.validarCadenaNulaVacia(codigoPostal,
						"ar.com.dubix.coati.empresa.CodigoPostalEmpresaException");
		if (nee != null) {
			throw nee;
		}
		this.codigoPostal = codigoPostal;
	}

	private void definirProvincia(final String provincia)
			throws ProvinciaException {
		ProvinciaException nee = (ProvinciaException) StringUtil
				.validarCadenaNulaVacia(provincia,
						"ar.com.dubix.coati.empresa.ProvinciaException");
		if (nee != null) {
			throw nee;
		}
		this.nombreProvincia = provincia;
	}

	private void definirLocalidad(final String localidad)
			throws LocalidadException {
		LocalidadException nee = (LocalidadException) StringUtil
				.validarCadenaNulaVacia(localidad,
						"ar.com.dubix.coati.empresa.LocalidadException");
		if (nee != null) {
			throw nee;
		}
		this.nombreLocalidad = localidad;
	}

	private void definirDireccion(final String direccion)
			throws DireccionEmpresaException {
		DireccionEmpresaException nee = (DireccionEmpresaException) StringUtil
				.validarCadenaNulaVacia(direccion,
						"ar.com.dubix.coati.empresa.DireccionEmpresaException");
		if (nee != null) {
			throw nee;
		}
		this.direccion = direccion;
	}

	private void definirRazonSocial(final String razonSocial)
			throws RazonSocialException {
		RazonSocialException nee = (RazonSocialException) StringUtil
				.validarCadenaNulaVacia(razonSocial,
						"ar.com.dubix.coati.empresa.RazonSocialException");
		if (nee != null) {
			throw nee;
		}
		this.razonSocial = razonSocial;
	}

	private void definirNombre(final String nombre)
			throws NombreEmpresaException {
		NombreEmpresaException nee = (NombreEmpresaException) StringUtil
				.validarCadenaNulaVacia(nombre,
						"ar.com.dubix.coati.empresa.NombreEmpresaException");
		if (nee != null) {
			throw nee;
		}
		this.nombre = nombre;
	}

	private void definirCategoriaFiscal(final CategoriaFiscal categoriaFiscal)
			throws CategoriaFiscalException {
		if (categoriaFiscal == null) {
			throw new CategoriaFiscalException();
		}
		this.categoriaFiscal = categoriaFiscal.getDescripcion();
	}

	public String getNombre() {
		return nombre;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDirección() {
		return direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public String getCategoriaFiscal() {
		return categoriaFiscal;
	}

	public void setNombre(String nombre) throws NombreEmpresaException {
		definirNombre(nombre);
	}

	public void setRazonSocial(String razonSocial) 
			throws RazonSocialException {
		definirRazonSocial(razonSocial);
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;//fixme!
	}

	public void setDireccion(final String direccion)
			throws DireccionEmpresaException {
		definirDireccion(direccion);
	}

	public void setCodigoPostal(final String codigoPostal)
			throws CodigoPostalEmpresaException {
		definirCodigoPostal(codigoPostal);
	}

	public void setNombreLocalidad(final String nombreLocalidad)
			throws LocalidadException {
		definirLocalidad(nombreLocalidad);
	}

	public void setNombreProvincia(final String nombreProvincia)
			throws ProvinciaException {
		definirProvincia(nombreProvincia);
	}

	public void setCategoriaFiscal(final CategoriaFiscal categoriaFiscal)
			throws CategoriaFiscalException {
		definirCategoriaFiscal(categoriaFiscal);
	}
}
