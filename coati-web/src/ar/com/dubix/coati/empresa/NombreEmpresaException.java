package ar.com.dubix.coati.empresa;

public class NombreEmpresaException extends EmpresaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NombreEmpresaException() {
		super("Debe ingresar el nombre de la empresa.");
	}

}
