package ar.com.dubix.coati.seguridad;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.junit.Test;

public class UsuariosServletITTest {

	private static final String nombreUsuario = "username";
	private static final String nombre = "nombre";
	private static final String email = "gonzalo.ferreyra@gmail.com";

	@Test
	public void testCrearUsuarioAdministrador() throws Exception {
		
		String parametros = URLEncoder.encode("username", "UTF-8") + "=" + 
					URLEncoder.encode(nombreUsuario, "UTF-8") + "&";
		parametros += URLEncoder.encode("password", "UTF-8") + "=" + 
				URLEncoder.encode("password", "UTF-8") + "&";
		parametros += URLEncoder.encode("validacionPassword", "UTF-8") + "=" + 
				URLEncoder.encode("password", "UTF-8") + "&";
		parametros += URLEncoder.encode("nombre", "UTF-8") + "=" + 
				URLEncoder.encode(nombre, "UTF-8") + "&";
		parametros += URLEncoder.encode("email", "UTF-8") + "=" + 
				URLEncoder.encode(email, "UTF-8") + "&";
		parametros += URLEncoder.encode("telefono", "UTF-8") + "=" + 
				URLEncoder.encode("154-187391", "UTF-8") + "&";
		parametros += URLEncoder.encode("accion", "UTF-8") + "=" + 
				URLEncoder.encode(UsuariosServlet.NUEVO_ADMINISTRADOR, "UTF-8");
		URL url = new URL("http://localhost:8888/usuarios");
		URLConnection conn = url.openConnection();
	    conn.setDoOutput(true);
	    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    wr.write(parametros);
	    wr.flush();
		
	    String resultado = "";
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) != null) {
	        resultado += line; 
	    }
	    wr.close();
	    rd.close();
	    
	    System.out.println(resultado);
        String[] partes = resultado.split("\\:");
        assertEquals(2, partes.length);
        assertEquals("Usuario Administrador guardado. Id" , partes[0]);
        assertNotNull(partes[1]);
        Long id = Long.parseLong(partes[1].trim());
		assertNotNull(id);
		
		//verifico que falle un 2º alta del mismo username
		URL url2 = new URL("http://localhost:8888/usuarios");
		conn = url2.openConnection();
	    conn.setDoOutput(true);
	    wr = new OutputStreamWriter(conn.getOutputStream());
	    wr.write(parametros);
	    wr.flush();
	    
	    resultado = "";
	    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    while ((line = rd.readLine()) != null) {
	        resultado += line; 
	    }
	    wr.close();
	    rd.close();
	    assertTrue(resultado.contains("El nombre de usuario " + nombreUsuario + 
	    		" ya ha sido utilizado."));
	}
}
