package ar.com.dubix.coati.facturacion;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public final class CategoriaFiscalResponsableInscripto 
		extends CategoriaFiscal implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CategoriaFiscalResponsableInscripto instance;

	/**
	 * Constructor para Objectify
	 */
	private CategoriaFiscalResponsableInscripto() {
		super();
	}

	private CategoriaFiscalResponsableInscripto(final String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public static CategoriaFiscalResponsableInscripto getInstance() {
		if (instance == null) {
			instance = new CategoriaFiscalResponsableInscripto(
					"Responsable Inscripto");
		}
		return instance;
	}
}
