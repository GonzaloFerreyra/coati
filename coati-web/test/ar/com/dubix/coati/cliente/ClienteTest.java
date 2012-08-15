package ar.com.dubix.coati.cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	private static Cliente instance;
	private static final String nombre = "Nombre";
	private static final String codigo = "Codigo";
	private static final String domicilio = "Domicilio";
	private static final String condicionIVA = "Consumidor Final";
	private static final String numeroLista = "A1";
	private static final String localidad = "Santa Fe";
	private static final String provincia = "Santa Fe";
	private static final String codigoPostal = "3000";
	private static final String cuit = "CUIT";
	private static final String diaDeVisita = "Lunes";


	@Before
	public void setUp() throws Exception {
		instance = new Cliente(nombre, codigo, domicilio, condicionIVA, numeroLista,
				localidad, provincia, codigoPostal, cuit, diaDeVisita);
	}

	@Test
	public void testCrearClienteCompleto() throws Exception {
		instance = new Cliente(nombre, codigo, domicilio, condicionIVA, numeroLista,
				localidad, provincia, codigoPostal, cuit, diaDeVisita);
		assertEquals(nombre, instance.getNombre());
		assertEquals(codigo, instance.getCodigo());
		assertEquals(domicilio, instance.getDomicilio());
		assertEquals(condicionIVA, instance.getCondicionIVA());
		assertEquals(numeroLista, instance.getNumeroLista());
		assertEquals(localidad, instance.getLocalidad());
		assertEquals(provincia, instance.getProvincia());
		assertEquals(codigoPostal, instance.getCodigoPostal());
		assertEquals(cuit, instance.getCuit());
		assertEquals(diaDeVisita, instance.getDiaDeVisita());
	}

	@Test
	public void testGetCodigo() {
		assertEquals(codigo, instance.getCodigo());
	}

	@Test
	public void testGetNombre() {
		assertEquals(nombre, instance.getNombre());
	}

	@Test
	public void testGetDomicilio() {
		assertEquals(domicilio, instance.getDomicilio());
	}

	@Test
	public void testGetCondicionIVA() {
		assertEquals(condicionIVA, instance.getCondicionIVA());
	}

	@Test
	public void testGetNumeroLista() {
		assertEquals(numeroLista, instance.getNumeroLista());
	}

	@Test
	public void testGetLocalidad() {
		assertEquals(localidad, instance.getLocalidad());
	}

	@Test
	public void testGetProvincia() {
		assertEquals(provincia, instance.getProvincia());
	}

	@Test
	public void testGetCodigoPostal() {
		assertEquals(codigoPostal, instance.getCodigoPostal());
	}

	@Test
	public void testGetCuit() {
		assertEquals(cuit, instance.getCuit());
	}

	@Test
	public void testGetDiaDeVisita() {
		assertEquals(diaDeVisita, instance.getDiaDeVisita());
	}

}
