package com.shiatsu.domain;

import java.io.Serializable;
import java.util.Date;

public class Enfermedad  implements Serializable{

	private static final long serialVersionUID = 4655663135297201540L;
	public static final Integer ENFERMEDAD_DEFAULT   = new Integer(0);
	public static final String ESTADO_DEFAULT	= new String("");
	public static final String ESTADO_ACTIVO   	= new String("A");
	public static final String ESTADO_INACTIVO 	= new String("I");
	public static final String ESTADO_ACTIVO_DESCRIPCION   	= new String("ACTIVO");
	public static final String ESTADO_INACTIVO_DESCRIPCION 	= new String("INACTIVO");
	private Integer pvInCodigo;
	private String pvStDescripcion;
	private String pvStEstado;
	private Usuario pvObUsuario;
	private Date pvDaModifica;
	
	public Enfermedad(){
		this.pvInCodigo = null;
		this.pvStDescripcion = null;
		this.pvStEstado = null;
		this.pvDaModifica = new Date();
		this.pvObUsuario = new Usuario();
	}
	
	public String getEstadoDescripcion(){
		if(ESTADO_ACTIVO.equals(this.pvStEstado)){
			return ESTADO_ACTIVO_DESCRIPCION;
		}
		if(ESTADO_INACTIVO.equals(this.pvStEstado)){
			return ESTADO_INACTIVO_DESCRIPCION;
		}
		return null;
	}
	/**
	 * @return the pvInCodigo
	 */
	public Integer getPvInCodigo() {
		return pvInCodigo;
	}
	/**
	 * @param pvInCodigo the pvInCodigo to set
	 */
	public void setPvInCodigo(Integer pvInCodigo) {
		this.pvInCodigo = pvInCodigo;
	}
 
	/**
	 * @return the pvStDescripcion
	 */
	public String getPvStDescripcion() {
		return pvStDescripcion;
	}

	/**
	 * @param pvStDescripcion the pvStDescripcion to set
	 */
	public void setPvStDescripcion(String pvStDescripcion) {
		this.pvStDescripcion = pvStDescripcion;
	}

	
	/**
	 * @return the pvStEstado
	 */
	public String getPvStEstado() {
		return pvStEstado;
	}

	/**
	 * @param pvStEstado the pvStEstado to set
	 */
	public void setPvStEstado(String pvStEstado) {
		this.pvStEstado = pvStEstado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pvInCodigo == null) ? 0 : pvInCodigo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enfermedad other = (Enfermedad) obj;
		if (pvInCodigo == null) {
			if (other.pvInCodigo != null)
				return false;
		} else if (!pvInCodigo.equals(other.pvInCodigo))
			return false;
		return true;
	}

	public Usuario getPvObUsuario() {
		return pvObUsuario;
	}

	public void setPvObUsuario(Usuario pvObUsuario) {
		this.pvObUsuario = pvObUsuario;
	}

	public Date getPvDaModifica() {
		return pvDaModifica;
	}

	public void setPvDaModifica(Date pvDaModifica) {
		this.pvDaModifica = pvDaModifica;
	}
	 
}
