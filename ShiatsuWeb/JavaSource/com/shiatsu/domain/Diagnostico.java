package com.shiatsu.domain;

import java.io.Serializable;
import java.util.Date;

public class Diagnostico implements Serializable{
	

	private static final long serialVersionUID = 4655663139997201540L;
	
	public static final String ESTADO_DEFAULT	= new String("");
	public static final String ESTADO_ACTIVO   	= new String("A");
	public static final String ESTADO_INACTIVO 	= new String("I");
	public static final String ESTADO_ACTIVO_DESCRIPCION   	= new String("ACTIVO");
	public static final String ESTADO_INACTIVO_DESCRIPCION 	= new String("INACTIVO");
	
	public static final Integer NUMERO_DEFAULT 	= new Integer(0);
	public static final String TEXTO_DEFAULT 	= new String("");
	
	public static final String TEXTO_SI	= new String("SI");
	public static final String TEXTO_NO	= new String("NO");
	
	private String pvStCodigo;
	private String pvStNombre;
	private Integer pvInTipoAlopecia;
	private Double pvDoPorcentajePerdida; 
	private String pvStUsuario;
	private String pvStDermatitisOleosa;  
	private String pvStDermatitisSeca;
	private String pvStDermatitisSeborreica;  
	private String pvStCaspa;
	private String pvStHongo;
	private String pvStDeshidratacion;
	private String pvStPsoriasis; 
	private String pvStTelanocitos;
	private String pvStEstado;
	private Usuario pvObUsuario;
	private Date pvDaModifica;
			
	public Diagnostico() {
		this.pvStCodigo = null;
		this.pvStNombre = null;
		this.pvInTipoAlopecia = null;
		this.pvDoPorcentajePerdida = null;
		this.pvStUsuario = null;
		this.pvStDermatitisOleosa = null;  
		this.pvStDermatitisSeca = null;
		this.pvStDermatitisSeborreica = null; 
		this.pvStCaspa = null;
		this.pvStHongo = null;
		this.pvStDeshidratacion = null;
		this.pvStPsoriasis = null;
		this.pvStTelanocitos = null;
		this.pvStEstado = null;
		this.pvDaModifica = new Date();
		this.pvObUsuario = new Usuario(); 
	}

	/** @return regresa el getEstadoDescripcion*/
	public String getEstadoDescripcion() {
		if(Cliente.ESTADO_ACTIVO.equals(this.pvStEstado)){
			return ESTADO_ACTIVO_DESCRIPCION;
		}
		if(Cliente.ESTADO_INACTIVO.equals(this.pvStEstado)){ 
			return ESTADO_INACTIVO_DESCRIPCION;
		}
		return null;
	}	
	
	
	/**
	 * @return the pvStNombre
	 */
	public String getPvStNombre() {
		if(this.pvStNombre!=null){
			return this.pvStNombre.toUpperCase();
		}
		return pvStNombre;
	}
	/**
	 * @param pvStNombre the pvStNombre to set
	 */
	public void setPvStNombre(String pvStNombre) {
		this.pvStNombre = pvStNombre;
	}

	/**
	 * @return the pvInTipoAlopecia
	 */
	public Integer getPvInTipoAlopecia() {
		return pvInTipoAlopecia;
	}

	/**
	 * @param pvInTipoAlopecia the pvInTipoAlopecia to set
	 */
	public void setPvInTipoAlopecia(Integer pvInTipoAlopecia) {
		this.pvInTipoAlopecia = pvInTipoAlopecia;
	}

	/**
	 * @return the pvDoPorcentajePerdida
	 */
	public Double getPvDoPorcentajePerdida() {
		return pvDoPorcentajePerdida;
	}

	/**
	 * @param pvDoPorcentajePerdida the pvDoPorcentajePerdida to set
	 */
	public void setPvDoPorcentajePerdida(Double pvDoPorcentajePerdida) {
		this.pvDoPorcentajePerdida = pvDoPorcentajePerdida;
	}

	/**
	 * @return the pvStUsuario
	 */
	public String getPvStUsuario() {
		return pvStUsuario;
	}

	/**
	 * @param pvStUsuario the pvStUsuario to set
	 */
	public void setPvStUsuario(String pvStUsuario) {
		this.pvStUsuario = pvStUsuario;
	}

	/**
	 * @return the pvStDermatitisOleosa
	 */
	public String getPvStDermatitisOleosa() {
		return pvStDermatitisOleosa;
	}

	/**
	 * @param pvStDermatitisOleosa the pvStDermatitisOleosa to set
	 */
	public void setPvStDermatitisOleosa(String pvStDermatitisOleosa) {
		this.pvStDermatitisOleosa = pvStDermatitisOleosa;
	}

	/**
	 * @return the pvStDermatitisSeca
	 */
	public String getPvStDermatitisSeca() {
		return pvStDermatitisSeca;
	}

	/**
	 * @param pvStDermatitisSeca the pvStDermatitisSeca to set
	 */
	public void setPvStDermatitisSeca(String pvStDermatitisSeca) {
		this.pvStDermatitisSeca = pvStDermatitisSeca;
	}

	/**
	 * @return the pvStDermatitisSeborreica
	 */
	public String getPvStDermatitisSeborreica() {
		return pvStDermatitisSeborreica;
	}

	/**
	 * @param pvStDermatitisSeborreica the pvStDermatitisSeborreica to set
	 */
	public void setPvStDermatitisSeborreica(String pvStDermatitisSeborreica) {
		this.pvStDermatitisSeborreica = pvStDermatitisSeborreica;
	}

	/**
	 * @return the pvStCaspa
	 */
	public String getPvStCaspa() {
		return pvStCaspa;
	}

	/**
	 * @param pvStCaspa the pvStCaspa to set
	 */
	public void setPvStCaspa(String pvStCaspa) {
		this.pvStCaspa = pvStCaspa;
	}

	/**
	 * @return the pvStHongo
	 */
	public String getPvStHongo() {
		return pvStHongo;
	}

	/**
	 * @param pvStHongo the pvStHongo to set
	 */
	public void setPvStHongo(String pvStHongo) {
		this.pvStHongo = pvStHongo;
	}

	/**
	 * @return the pvStDeshidratacion
	 */
	public String getPvStDeshidratacion() {
		return pvStDeshidratacion;
	}

	/**
	 * @param pvStDeshidratacion the pvStDeshidratacion to set
	 */
	public void setPvStDeshidratacion(String pvStDeshidratacion) {
		this.pvStDeshidratacion = pvStDeshidratacion;
	}

	/**
	 * @return the pvStPsoriasis
	 */
	public String getPvStPsoriasis() {
		return pvStPsoriasis;
	}

	/**
	 * @param pvStPsoriasis the pvStPsoriasis to set
	 */
	public void setPvStPsoriasis(String pvStPsoriasis) {
		this.pvStPsoriasis = pvStPsoriasis;
	}

	/**
	 * @return the pvStTelanocitos
	 */
	public String getPvStTelanocitos() {
		return pvStTelanocitos;
	}

	/**
	 * @param pvStTelanocitos the pvStTelanocitos to set
	 */
	public void setPvStTelanocitos(String pvStTelanocitos) {
		this.pvStTelanocitos = pvStTelanocitos;
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

	/**
	 * @return the pvStCodigo
	 */
	public String getPvStCodigo() {
		return pvStCodigo;
	}

	/**
	 * @param pvStCodigo the pvStCodigo to set
	 */
	public void setPvStCodigo(String pvStCodigo) {
		this.pvStCodigo = pvStCodigo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pvStCodigo == null) ? 0 : pvStCodigo.hashCode());
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
		Diagnostico other = (Diagnostico) obj;
		if (pvStCodigo == null) {
			if (other.pvStCodigo != null)
				return false;
		} else if (!pvStCodigo.equals(other.pvStCodigo))
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
