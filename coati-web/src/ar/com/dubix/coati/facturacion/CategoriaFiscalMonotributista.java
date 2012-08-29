package ar.com.dubix.coati.facturacion;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CategoriaFiscalMonotributista extends CategoriaFiscal
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CategoriaFiscalMonotributista instance;

	/**
	 * Constructor para Objectify
	 */
	private CategoriaFiscalMonotributista() {
		super();
	}

	private CategoriaFiscalMonotributista(final String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public static CategoriaFiscalMonotributista getInstance() {
		if (instance == null) {
			instance = new CategoriaFiscalMonotributista(
					"Monotributista");
		}
		return instance;
	}
}
