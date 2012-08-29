package ar.com.dubix.coati.empresa;

public class RazonSocialException extends EmpresaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RazonSocialException() {
		super("Debe suministrar la razón social de la empresa.");
	}

}
