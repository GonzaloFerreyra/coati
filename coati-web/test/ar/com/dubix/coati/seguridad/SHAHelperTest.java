package ar.com.dubix.coati.seguridad;

import static org.junit.Assert.*;

import org.junit.Test;

public class SHAHelperTest {

	@Test
	public void testCalcularSHA256()
			throws Exception {
		String esperado =
				"5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
		String resultado = SHAHelper.calcularSHA256("password");
		assertEquals(esperado, resultado);
	}
}
