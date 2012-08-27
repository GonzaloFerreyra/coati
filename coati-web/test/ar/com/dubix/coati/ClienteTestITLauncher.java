package ar.com.dubix.coati;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Before;
import org.junit.Test;

import ar.com.dubix.coati.cliente.Cliente;
import static org.junit.Assert.*;


public class ClienteTestITLauncher {
	
	@Before
	public void inicializar() throws Exception {
		InicializadorTest.limpiarClaseDelStore("ar.com.dubix.coati.cliente.Cliente");
	}
	
	@Test
	public void clienteDAOTestIT() throws Exception {
		URL alta = new URL("http://localhost:8888/cliente?accion=nuevo&codigo=1a&nombre=Gonzalo" +
				"&domicilio=casa&condicionIVA=Exento&numeroLista=1&localidad=SantaFe&provincia=SantaFe" +
				"&codigoPostal=3000&cuit=20239299556&diaDeVisita=lunes");
        URLConnection con = alta.openConnection();
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(con.getInputStream()));
        String inputLine;
        String resultado = "";
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        	resultado += inputLine;
        }
        in.close();
        String[] partes = resultado.split("\\:");
        assertEquals(2, partes.length);
        assertEquals("Cliente guardado. Id" , partes[0]);
        assertNotNull(partes[1]);
        Long id = Long.parseLong(partes[1].trim());
        
        URL baja = new URL("http://localhost:8888/cliente?accion=borrar&id=" + id);
        con = baja.openConnection();
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        resultado = "";
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        	resultado += inputLine;
        }
        in.close();
        assertEquals("El cliente ha sido dado de baja", resultado);
	}
}
