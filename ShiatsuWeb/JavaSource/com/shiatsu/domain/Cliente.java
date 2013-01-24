package com.shiatsu.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;



public class Cliente implements Serializable {

	private static final long serialVersionUID = 4655663135297201540L;
	
	public static final String ESTADO_DEFAULT	= new String("");
	public static final String ESTADO_ACTIVO   	= new String("A");
	public static final String ESTADO_INACTIVO 	= new String("I");
	public static final String ESTADO_ACTIVO_DESCRIPCION   	= new String("ACTIVO");
	public static final String ESTADO_INACTIVO_DESCRIPCION 	= new String("INACTIVO");
	
	public static final Long   TELEFONO_DEFAULT 			= new Long(0);
	public static final Integer PROFESION_DEFAULT  			= new Integer(0);
	public static final Integer FRECUENCIA_CITA_DEFAULT 	= new Integer(0);
	public static final Integer NACIONALIDAD_DEFAULT  		= new Integer(0);
	
	public static final String SEXO_DEFAULT  				= new String("");
	public static final String SEXO_MASCULINO  				= new String("M");
	public static final String SEXO_FEMENINO  				= new String("F");
	public static final String SEXO_MASCULINO_DESCRIPCION 	= new String("MASCULINO");
	public static final String SEXO_FEMENINO_DESCRIPCION  	= new String("FEMENINO");
	
	public static final Integer ALOPECIA_DEFAULT  			= new Integer(0);
	public static final Integer CLIENTE_DEFAULT  			= new Integer(0);
	
	private Usuario pvObUsuario;
	private Date pvDaModifica;
	private Integer	pvStCodigo;
	private String 	pvStDireccion;
	private String  pvStEstado;
	private String 	pvStEmail1;
	private String 	pvStEmail2;
	private String  pvStFacturaNombre;
	private	Integer pvInFrecuenciaCita;
	private String  pvStLugarProfesion;
	private Date	pvDaNacimiento;
	private Integer pvInNacionalidad;
	private Diagnostico pvDiDiagnostico;
	private Integer pvInProfesion; 
	private String  pvStSexo;
	private Long 	pvLoTelefonoCasa;
	private Long 	pvLoTelefonoCelular;
	private	Integer pvInTipoAlopecia; 
	private	Integer pvInProvincia;
	private	Integer pvInCanton;
	private	Integer pvInDistrito; 
	private String  pvStNombre; 

	public Cliente(){
		this.pvDiDiagnostico = new Diagnostico();
		this.pvDaModifica = new Date();
		this.pvObUsuario = new Usuario(); 
	}
	
	/** @return regresa el pvStEstadoDescripcion*/
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
	 * @return the pvStSexo
	 */
	public String getPvStSexo() {
		return pvStSexo;
	}

	/**
	 * @param pvStSexo the pvStSexo to set
	 */
	public void setPvStSexo(String pvStSexo) {
		this.pvStSexo = pvStSexo;
	}

  

	/** @return regresa el getPvStSexoDescripcion*/
	public String getSexoDescripcion() { 
		if(Cliente.SEXO_FEMENINO.equals(this.pvStSexo)){
			return SEXO_FEMENINO_DESCRIPCION;
		}
		if(Cliente.SEXO_MASCULINO.equals(this.pvStSexo)){ 
			return SEXO_MASCULINO_DESCRIPCION;
		}
		return null;
	}	

	/**
	 * @return the pvStCodigo
	 */
	public Integer getPvStCodigo() {
		return pvStCodigo;
	}
	/**
	 * @param pvStCodigo the pvStCodigo to set
	 */
	public void setPvStCodigo(Integer pvStCodigo) {
		this.pvStCodigo = pvStCodigo;
	}
	/**
	 * @return the pvStDireccion
	 */
	public String getPvStDireccion() {
		if(this.pvStDireccion!=null){
			return this.pvStDireccion.toUpperCase();
		}
		return this.pvStDireccion;
	}
	/**
	 * @param pvStDireccion the pvStDireccion to set
	 */
	public void setPvStDireccion(String pvStDireccion) {
		this.pvStDireccion = pvStDireccion;
	}
	 
	public String getPvStEstado() {
		return pvStEstado;
	}

	public void setPvStEstado(String pvStEstado) {
		this.pvStEstado = pvStEstado;
	}
	
	/**
	 * @return the pvStNombre
	 */
	public String getPvStNombre() {
		return pvStNombre;
	}

	/**
	 * @param pvStNombre the pvStNombre to set
	 */
	public void setPvStNombre(String pvStNombre) {
		this.pvStNombre = pvStNombre;
	}

	/**
	 * @return the pvStEmail1
	 */
	public String getPvStEmail1() {
		if(this.pvStEmail1!=null){
			return this.pvStEmail1.toUpperCase();
		}
		return pvStEmail1;
	}
	/**
	 * @param pvStEmail1 the pvStEmail1 to set
	 */
	public void setPvStEmail1(String pvStEmail1) {
		this.pvStEmail1 = pvStEmail1;
	}
	/**
	 * @return the pvStEmail2
	 */
	public String getPvStEmail2() {
		if(this.pvStEmail2!=null){
			return this.pvStEmail2.toUpperCase();
		}
		return pvStEmail2;
	}
	/**
	 * @param pvStEmail2 the pvStEmail2 to set
	 */
	public void setPvStEmail2(String pvStEmail2) {
		this.pvStEmail2 = pvStEmail2;
	}
	/**
	 * @return the pvStFacturaNombre
	 */
	public String getPvStFacturaNombre() {
		if(this.pvStFacturaNombre!=null){
			return this.pvStFacturaNombre.toUpperCase();
		}
		return pvStFacturaNombre;
	}
	/**
	 * @param pvStFacturaNombre the pvStFacturaNombre to set
	 */
	public void setPvStFacturaNombre(String pvStFacturaNombre) {
		this.pvStFacturaNombre = pvStFacturaNombre;
	}
	
	/**
	 * @return the pvInFrecuenciaCita
	 */
	public Integer getPvInFrecuenciaCita() {
		return pvInFrecuenciaCita;
	}
	/**
	 * @param pvInFrecuenciaCita the pvInFrecuenciaCita to set
	 */
	public void setPvInFrecuenciaCita(Integer pvInFrecuenciaCita) {
		this.pvInFrecuenciaCita = pvInFrecuenciaCita;
	}
	/**
	 * @return the pvStLugarProfesion
	 */
	public String getPvStLugarProfesion() {
		if(this.pvStLugarProfesion!=null){
			return this.pvStLugarProfesion.toUpperCase();
		}
		return pvStLugarProfesion;
	}
	/**
	 * @param pvStLugarProfesion the pvStLugarProfesion to set
	 */
	public void setPvStLugarProfesion(String pvStLugarProfesion) {
		this.pvStLugarProfesion = pvStLugarProfesion;
	}
	/**
	 * @return the pvDaNacimiento
	 */
	public Date getPvDaNacimiento() {
		return pvDaNacimiento;
	}
	/**
	 * @param pvDaNacimiento the pvDaNacimiento to set
	 */
	public void setPvDaNacimiento(Date pvDaNacimiento) {
		this.pvDaNacimiento = pvDaNacimiento;
	}
	/**
	 * @return the pvInNacionalidad
	 */
	public Integer getPvInNacionalidad() {
		return pvInNacionalidad;
	}
	/**
	 * @param pvInNacionalidad the pvInNacionalidad to set
	 */
	public void setPvInNacionalidad(Integer pvInNacionalidad) {
		this.pvInNacionalidad = pvInNacionalidad;
	}

	/**
	 * @return the pvInProfesion
	 */
	public Integer getPvInProfesion() {
		return pvInProfesion;
	}
	/**
	 * @param pvInProfesion the pvInProfesion to set
	 */
	public void setPvInProfesion(Integer pvInProfesion) {
		this.pvInProfesion = pvInProfesion;
	} 
	/**
	 * @return the pvLoTelefonoCasa
	 */
	public Long getPvLoTelefonoCasa() {
		return pvLoTelefonoCasa;
	}
	/**
	 * @param pvLoTelefonoCasa the pvLoTelefonoCasa to set
	 */
	public void setPvLoTelefonoCasa(Long pvLoTelefonoCasa) {
		this.pvLoTelefonoCasa = pvLoTelefonoCasa;
	}
	/**
	 * @return the pvLoTelefonoCelular
	 */
	public Long getPvLoTelefonoCelular() {
		return pvLoTelefonoCelular;
	}
	/**
	 * @param pvLoTelefonoCelular the pvLoTelefonoCelular to set
	 */
	public void setPvLoTelefonoCelular(Long pvLoTelefonoCelular) {
		this.pvLoTelefonoCelular = pvLoTelefonoCelular;
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
	 * @return the pvInProvincia
	 */
	public Integer getPvInProvincia() {
		return pvInProvincia;
	}

	/**
	 * @param pvInProvincia the pvInProvincia to set
	 */
	public void setPvInProvincia(Integer pvInProvincia) {
		this.pvInProvincia = pvInProvincia;
	}

	/**
	 * @return the pvInCanton
	 */
	public Integer getPvInCanton() {
		return pvInCanton;
	}

	/**
	 * @param pvInCanton the pvInCanton to set
	 */
	public void setPvInCanton(Integer pvInCanton) {
		this.pvInCanton = pvInCanton;
	}

	/**
	 * @return the pvInDistrito
	 */
	public Integer getPvInDistrito() {
		return pvInDistrito;
	}

	/**
	 * @param pvInDistrito the pvInDistrito to set
	 */
	public void setPvInDistrito(Integer pvInDistrito) {
		this.pvInDistrito = pvInDistrito;
	}

	
	/**
	 * @return the pvDiDiagnostico
	 */
	public Diagnostico getPvDiDiagnostico() {
		return pvDiDiagnostico;
	}

	/**
	 * @param pvDiDiagnostico the pvDiDiagnostico to set
	 */
	public void setPvDiDiagnostico(Diagnostico pvDiDiagnostico) {
		this.pvDiDiagnostico = pvDiDiagnostico;
	}

	
	/**
	 * Comment for equals
	 * @param obj
	 * @return resultado
	 */
	public boolean equals(Object obj) {
		boolean resultado;
		if (!(obj instanceof Cliente)) {
			resultado = false;
		} else {
			Cliente cliente = (Cliente) obj;
			resultado = new EqualsBuilder()
			.append(this.pvStCodigo, cliente.getPvStCodigo())
			.isEquals();	
		}	
		return resultado;
	}
	
	/**
     * @see java.lang.Object#hashCode()
     * @return int
     */
    public int hashCode() {
        return new HashCodeBuilder()
        .append(this.pvStCodigo)
        .toHashCode();
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
