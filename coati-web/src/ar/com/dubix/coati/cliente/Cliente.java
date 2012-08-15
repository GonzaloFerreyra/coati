package ar.com.dubix.coati.cliente;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String codigo;
	private String nombre;
	private String domicilio;
	private String condicionIVA;
	private String numeroLista;
	private String localidad;
	private String provincia;
	private String codigoPostal;
	private String cuit;
	private String diaDeVisita;

	/**
	 * Constructor para Objectify
	 */
	public Cliente() {
	}

	/**
	 * Construye un cliente en función de sus propiedades.
	 * 
	 * @param nombre
	 * @param codigo
	 * @param domicilio
	 * @param condicionIVA
	 * @param numeroLista
	 * @param localidad
	 * @param provincia
	 * @param codigoPostal
	 * @param cuit
	 * @throws NombreClienteException 
	 * @throws CodigoClienteException 
	 * @throws DomicilioClienteException 
	 * @throws ProvinciaClienteException 
	 * @throws LocalidadClienteException 
	 * @throws CodigoPostalClienteException 
	 * @throws CuitClienteException 
	 */
	public Cliente(final String nombre, final String codigo,
			final String domicilio, final String condicionIVA,
			final String numeroLista, final String localidad,
			final String provincia, final String codigoPostal,
			final String cuit, final String diaDeVisita)
			throws NombreClienteException, CodigoClienteException,
			DomicilioClienteException, CondicionIvaDesconocidaException,
			ProvinciaClienteException, LocalidadClienteException,
			CodigoPostalClienteException, CuitClienteException {
		definirNombre(nombre);
		definirCodigo(codigo);
		definirDomicilio(domicilio);
		definirCondicionIVA(condicionIVA);
		definirLocalidad(localidad);
		definirProvincia(provincia);
		definirCodigoPostal(codigoPostal);
		definirCUIT(cuit);
		this.numeroLista = numeroLista;
		this.diaDeVisita = diaDeVisita;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the condicionIVA
	 */
	public String getCondicionIVA() {
		return condicionIVA;
	}

	/**
	 * @return the numeroLista
	 */
	public String getNumeroLista() {
		return numeroLista;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @return the cuit
	 */
	public String getCuit() {
		return cuit;
	}

	public String getDiaDeVisita() {
		return diaDeVisita;
	}

	public void setDiaDeVisita(String diaDeVisita) {
		this.diaDeVisita = diaDeVisita;
	}

	private void definirNombre(final String nombre) throws NombreClienteException {
		if (nombre == null) {
			throw new NombreClienteException();
		}
		this.nombre = nombre;
	}

	private void definirCodigo(final String codigo) throws CodigoClienteException {
		if (codigo == null) {
			throw new CodigoClienteException();
		}
		this.codigo = codigo;
	}

	private void definirDomicilio(final String domicilio) throws DomicilioClienteException {
		if (domicilio == null) {
			throw new DomicilioClienteException();
		}
		this.domicilio = domicilio;
	}

	private void definirCondicionIVA(final String condicionIVA) throws CondicionIvaDesconocidaException	{
		if (condicionIVA == null) {
			throw new CondicionIvaDesconocidaException();
		}
		this.condicionIVA = condicionIVA;
	}

	private void definirLocalidad(final String localidad) throws LocalidadClienteException	{
		if (localidad == null) {
			throw new LocalidadClienteException();
		}
		this.localidad = localidad;
	}

	private void definirProvincia(final String provincia) throws ProvinciaClienteException	{
		if (provincia == null) {
			throw new ProvinciaClienteException();
		}
		this.provincia = provincia;
	}

	private void definirCodigoPostal(final String codigoPostal) throws CodigoPostalClienteException	{
		if (codigoPostal == null) {
			throw new CodigoPostalClienteException();
		}
		this.codigoPostal = codigoPostal;
	}

	private void definirCUIT(final String cuit) throws CuitClienteException	{
		if (cuit == null) {
			throw new CuitClienteException();
		}
		this.cuit = cuit;
	}
}
