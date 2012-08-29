package ar.com.dubix.coati.facturacion;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CategoriaFiscalExento extends CategoriaFiscal
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CategoriaFiscalExento instance;

	/**
	 * Constructor para Objectify
	 */
	private CategoriaFiscalExento() {
		super();
	}

	private CategoriaFiscalExento(final String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public static CategoriaFiscalExento getInstance() {
		if (instance == null) {
			instance = new CategoriaFiscalExento("Exento");
		}
		return instance;
	}
}
