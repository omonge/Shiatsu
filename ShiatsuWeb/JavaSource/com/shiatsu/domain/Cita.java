/**
 * 
 */
package com.shiatsu.domain;

import java.io.Serializable;

/**
 * @author oscar.monge
 *
 */
public class Cita implements Serializable {
	private static final long serialVersionUID = 7129844110408404138L;

	public static final Integer CITA_DEFAULT   	= new Integer(0);
	public static final Integer CITA_SEMANAL   	= new Integer(1);
	public static final Integer CITA_QUINCENAL 	= new Integer(2);
	public static final Integer CITA_MENSUAL 	= new Integer(3);
	 
	public static final String CITA_SEMANAL_DESCRIPCION   	= new String("SEMANAL");
	public static final String CITA_QUINCENAL_DESCRIPCION 	= new String("QUINCENAL");
	public static final String CITA_MENSUAL_DESCRIPCION 	= new String("MENSUAL");
	
	public Cita() {
		// TODO Auto-generated constructor stub
	}

}
