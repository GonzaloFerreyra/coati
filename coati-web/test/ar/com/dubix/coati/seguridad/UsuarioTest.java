package ar.com.dubix.coati.seguridad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private static final String nombreUsuario = "username";
	private static final String nombre= "nombre";
	private static final String email = "gonzalo.ferreyra@gmail.com";
	private static Usuario instance;

	@Before
	public void setUp() throws Exception {
		instance = new Usuario(nombreUsuario, "password", "password", nombre,
				email, "-");
	}

	@Test
	public void testNuevoUsuario() throws Exception {
		try {
			new Usuario(null, null, null, null, null, null);
			fail("Debe fallar porque el nombre de usuario es nulo.");
		} catch (NombreUsuarioNuloException ne) {
		}
		try {
			new Usuario("", null, null, null, null, null);
			fail("Debe fallar porque el nombre de usuario es nulo.");
		} catch (NombreUsuarioNuloException ne) {
		}
		try {
			new Usuario("   ", null, null, null, null, null);
			fail("Debe fallar porque el nombre de usuario es nulo.");
		} catch (NombreUsuarioNuloException ne) {
		}
		try {
			new Usuario("username", null, null, null, null, null);
			fail("Debe fallar porque el password es nulo.");
		} catch (PasswordNuloException ne) {
		}
		try {
			new Usuario("username", "", null, null, null, null);
			fail("Debe fallar porque el password es nulo.");
		} catch (PasswordNuloException ne) {
		}
		try {
			new Usuario("username", "    ", null, null, null, null);
			fail("Debe fallar porque el password es nulo.");
		} catch (PasswordNuloException ne) {
		}
		try {
			new Usuario("username", "password", null, null, null, null);
			fail("Debe fallar porque la validación del password es nula.");
		} catch (ValidacionPasswordNuloException ne) {
		}
		try {
			new Usuario("username", "password", "", null, null, null);
			fail("Debe fallar porque la validación del password es nula.");
		} catch (ValidacionPasswordNuloException ne) {
		}
		try {
			new Usuario("username", "password", "    ", null, null, null);
			fail("Debe fallar porque la validación del password es nula.");
		} catch (ValidacionPasswordNuloException ne) {
		}
		try {
			new Usuario("username", "password", "passwor", null, null, null);
			fail("Debe fallar porque la validación no coincide con la original.");
		} catch (PasswordNoValidadaException ne) {
		}
		try {
			new Usuario("username", "pass", "pass", null, null, null);
			fail("Debe fallar porque el password es demasiado corto.");
		} catch (PasswordMuyCortaException ne) {
		}
		try {
			new Usuario("username", "  pass  ", "  pass  ", null, null, null);
			fail("Debe fallar porque el password es demasiado corto.");
		} catch (PasswordMuyCortaException ne) {
		}
		try {
			new Usuario("username", "password", "password", null, null, null);
			fail("Debe fallar porque el nombre es nulo.");
		} catch (NombreNuloException ne) {
		}
		try {
			new Usuario("username", "password", "password", "", null, null);
			fail("Debe fallar porque el nombre es nulo.");
		} catch (NombreNuloException ne) {
		}
		try {
			new Usuario("username", "password", "password", "  ", null, null);
			fail("Debe fallar porque el nombre es nulo.");
		} catch (NombreNuloException ne) {
		}
		try {
			new Usuario("username", "password", "password", "nombre", null, null);
			fail("Debe fallar porque el email es nulo.");
		} catch (EmailInvalidoException ne) {
		}
		try {
			new Usuario("username", "password", "password", "nombre", "", null);
			fail("Debe fallar porque el email es nulo.");
		} catch (EmailInvalidoException ne) {
		}
		try {
			new Usuario("username", "password", "password", "nombre", "  ", null);
			fail("Debe fallar porque el email es nulo.");
		} catch (EmailInvalidoException ne) {
		}
		Usuario usuario = new Usuario(" username ", " password ", " password ", " nombre ",
					" gonzalo.ferreyra@gmail.com ", "-");
		assertEquals(nombreUsuario, usuario.getNombreUsuario());
		assertEquals(nombre, usuario.getNombre());
		assertEquals(email, usuario.getEmail());
		assertTrue(usuario.validarPassword("password"));
	}

	@Test
	public void testGetNombreUsuario() {
		assertEquals(nombreUsuario, instance.getNombreUsuario());
	}

	@Test
	public void testGetNombre() {
		assertEquals(nombre, instance.getNombre());
	}

	@Test
	public void testGetEmail() {
		assertEquals(email, instance.getEmail());
	}

	@Test
	public void testGetTelefono() {
		assertEquals("-", instance.getTelefono());
	}
}
