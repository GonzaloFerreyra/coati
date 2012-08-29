package ar.com.dubix.coati.facturacion;

import java.io.Serializable;
import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CategoriaFiscalConsumidorFinal extends CategoriaFiscal
		implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CategoriaFiscalConsumidorFinal instance;

	/**
	 * Constructor para Objectify
	 */
	private CategoriaFiscalConsumidorFinal() {
		super();
	}

	private CategoriaFiscalConsumidorFinal(final String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public static CategoriaFiscalConsumidorFinal getInstance() {
		if (instance == null) {
			instance = new CategoriaFiscalConsumidorFinal(
					"Consumidor Final");
		}
		return instance;
	}
}
