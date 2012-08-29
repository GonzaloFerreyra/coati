package ar.com.dubix.coati.facturacion;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoriaFiscal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	protected String descripcion;

	/**
	 * Constructor para Objectify
	 */
	protected CategoriaFiscal() {
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
