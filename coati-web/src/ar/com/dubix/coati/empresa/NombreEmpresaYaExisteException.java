package ar.com.dubix.coati.empresa;

public class NombreEmpresaYaExisteException extends EmpresaException {

	NombreEmpresaYaExisteException(final String nombre) {
		super("El nombre de empresa " + nombre + " ya ha sido utilizado.");
	}
}
