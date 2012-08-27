package ar.com.dubix.coati;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import static org.junit.Assert.*;

public class InicializadorTest {

	public static void limpiarClaseDelStore(String className) {
		try {
			String parametros = URLEncoder.encode("cleanClass", "UTF-8") +
					"=" + URLEncoder.encode(className, "UTF-8") + "&";
			URL url = new URL("http://localhost:8888/init");
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
		    assertEquals("Ocurrió un error al borrar la clase " + className, "OK", resultado);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
