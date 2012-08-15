package ar.com.dubix.coati.dao;

public class DAOException extends Exception {

	public DAOException(final Throwable throwable, final String mensaje) {
		super(mensaje);
		if (throwable != null) {
			setStackTrace(throwable.getStackTrace());
		}
	}
}
