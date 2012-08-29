package ar.com.dubix.coati.empresa;

public class CategoriaFiscalException extends EmpresaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoriaFiscalException() {
		super("Debe suministrar la categoría fiscal de la empresa.");
	}

}
