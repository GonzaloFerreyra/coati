package ar.com.dubix.coati.util;

public class StringUtil {

	/**
	 * Verifica que un string no sea nulo ni vacío. Si la cadena no es nula ni
	 * vacía, devuelve null; en caso de fallar devuelve una excepción de la
	 * clase recibida como parámetro
	 * 
	 * @param cadena
	 *            Cadena a evaluar
	 * @param claseExcepcion
	 *            Fullname de la excepción a arrojar si la validación falla
	 * @return
	 */
	public static Exception validarCadenaNulaVacia(final String cadena,
			final String claseExcepcion) {
		if ((cadena == null) || (cadena.trim().isEmpty())) {
			return newInstance(claseExcepcion); 
		}
		return null;
	}

	private static Exception newInstance(String claseExcepcion) {
		try {
			Class<?> c = Class.forName(claseExcepcion);
			Exception ex = (Exception) c.newInstance();
			return ex;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		} catch (InstantiationException ie) {
			ie.printStackTrace();
			return null;
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
			return null;
		}
	}
}
