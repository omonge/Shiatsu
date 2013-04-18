/**
 * 
 */
package com.shiatsu.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author oscar.monge
 *
 */
public class AgendaCapilar implements Serializable {
	private static final long serialVersionUID = 7129844110408404138L; 

	public static final int COLUMNAS 	=  10;
	public static final Integer FILAS	 	= new Integer(10);

	private Long 		id;
	/*private Long 		cedula;
	private String 		apellidos;*/
	private Integer		hora;
	/*private Date 		fecha;
	private Usuario 	usuario;
	private TipoCliente tipoCliente;
	private String 		observacion;*/
	
	private Boolean primero;
	private Boolean ultimo;
	
	
	public AgendaCapilar() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the hora
	 */
	public Integer getHora() {
		return hora;
	}


	/**
	 * @param hora the hora to set
	 */
	public void setHora(Integer hora) {
		this.hora = hora;
	}


 
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AgendaCapilar)) {
			return false;
		}
		AgendaCapilar other = (AgendaCapilar) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	public Boolean getUltimo() {
		return ultimo;
	}
	public void setUltimo(Boolean ultimo) {
		this.ultimo = ultimo;
	}
	public Boolean getPrimero() {
		return primero;
	}
	public void setPrimero(Boolean primero) {
		this.primero = primero;
	}
}
