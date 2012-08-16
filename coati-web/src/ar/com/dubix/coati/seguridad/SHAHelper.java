package ar.com.dubix.coati.seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAHelper {

	public static String calcularSHA256(final String contenido)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

	    byte[] hash = md.digest("password".getBytes());

	    StringBuffer sb = new StringBuffer();
	    for(byte b : hash) {
	    	sb.append(String.format("%02x", b));
	    }
	    return sb.toString();
	}
}
