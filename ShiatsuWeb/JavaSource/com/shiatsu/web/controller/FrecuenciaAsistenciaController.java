package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.bo.FrecuenciaAsistenciaBo;
import com.shiatsu.domain.FrecuenciaAsistencia;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Controller;
import com.utilidades.business.BusinessErrorHelper;

public class FrecuenciaAsistenciaController  extends Controller{

	private HtmlDataTable     	  listaDataTable;
    private List<FrecuenciaAsistencia>    lista;
    private FrecuenciaAsistencia 	  	  frecuenciaAsistencia;
	private FrecuenciaAsistenciaBo	  	  frecuenciaAsistenciaBo;  
	

	 /**
	 * @return the init
	 */ 
	public boolean getInit() {  
		Object dato = this.getFacesContext().getExternalContext().getRequestParameterMap().get("init");
       if (dato != null) {
          this.reiniciarController();
          this.buscarTodos();
       } 
       return init;
	}
	
	public FrecuenciaAsistenciaController() {
		this.reiniciarController();
	}

	@Override
	protected void reiniciarController() {
		this.reiniciarFiltro();
		this.reiniciarDatos(); 
	}

	@Override
	protected void reiniciarFiltro() {
		this.agregar = Boolean.TRUE;
		this.frecuenciaAsistencia = new FrecuenciaAsistencia();
	}

	@Override
	protected void reiniciarDatos() {
		this.listaDataTable = new HtmlDataTable();
		this.lista = new ArrayList<FrecuenciaAsistencia>();
	}
	


	/**
     * Método para validar el código, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

        if ((this.frecuenciaAsistencia.getPvStEstado() != null) && (!FrecuenciaAsistencia.ESTADO_DEFAULT.equals(this.frecuenciaAsistencia.getPvStEstado()))) {
            correcto = true;
    	}
    	if ((this.frecuenciaAsistencia.getPvStDescripcion() != null) && (!"".equals(this.frecuenciaAsistencia.getPvStDescripcion()))) {
            correcto = true;
    	}
        return correcto;
    }

    /**
     * Metodo validarObjetoId Metodo que valida el id del objeto que se quiere buscar, agregar o modificar
     * @return bool
     */
    private boolean validarObjetoId() { 
        boolean correcto = false;
        if((this.frecuenciaAsistencia.getPvInCodigo()!=null) && !(this.frecuenciaAsistencia.getPvInCodigo().equals(Integer.valueOf(0)))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * Método buscar Busca las lista de FrecuenciaAsistencias que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        //if(this.listaDataTable != null){this.listaDataTable.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            FrecuenciaAsistencia frecuenciaAsistencia = this.frecuenciaAsistenciaBo.buscar(this.frecuenciaAsistencia);
            if (frecuenciaAsistencia != null) {
                this.lista.add(frecuenciaAsistencia);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.lista = this.frecuenciaAsistenciaBo.getFrecuenciaAsistencias(this.frecuenciaAsistencia);
        		respuesta = "success";
        	}
            else{ 
                this.addWarning(null, Bundle.rcs.getString("todosLosRegistros"));
                this.buscarTodos();
            }
        } 
        if ((respuesta == "success") && (this.lista.isEmpty())) { 
            this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        } else if (respuesta == "success") {
            this.reiniciarFiltro();
            this.addInfo(null, Bundle.rcs.getString("operacionExitosa"));
        }
        return respuesta;
    }
 
	public void buscarTodos(){
		this.lista = this.frecuenciaAsistenciaBo.getFrecuenciaAsistencias();
        if(this.lista.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la pÃ¡gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.frecuenciaAsistencia = (FrecuenciaAsistencia) this.listaDataTable.getRowData();
	     this.agregar = false;
		 return "success";
	}


	/*********************** NAVEGACION *******************************/
	
	/**Metodo irAgregar
	*@return success
	*/
	public String irAgregar(){
		this.reiniciarController();
		return "success";
	}
	public String regresar(){
		this.reiniciarFiltro();
		this.buscarTodos();
		return "success";
	}
	
	private boolean validaInsertar(){
		boolean correcto = true;
		try{
			if((!this.agregar) && (this.frecuenciaAsistencia.getPvInCodigo() == null)){
				this.addError(this.getPropertyFieldName("frecuenciaAsistencia.pvInCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.frecuenciaAsistencia.getPvStDescripcion()== null || ("".equals(this.frecuenciaAsistencia.getPvStDescripcion())))){
				this.addError(this.getPropertyFieldName("frecuenciaAsistencia.pvStDescripcion"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
		}catch(NumberFormatException nef){
            this.addError(null, Bundle.rcs.getString("soloNumeros"));
            nef.printStackTrace();
        }catch(Exception e){
        	this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            e.printStackTrace();
		}
		return correcto;
	}
	
	/**Método agregar
	* Agrega un frecuenciaAsistencia en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	//this.frecuenciaAsistencia.setPvStEstado(FrecuenciaAsistencia.ESTADO_ACTIVO);
                this.frecuenciaAsistenciaBo.agregar(this.frecuenciaAsistencia);
                this.addInfo(null, Bundle.rcs.getString("datosAgregados"));
                respuesta = "success";
                this.reiniciarFiltro();
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	
	/**Método modificar
	* Modificar un frecuenciaAsistencia en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
                this.frecuenciaAsistenciaBo.modificar(this.frecuenciaAsistencia);
                this.addInfo(null, Bundle.rcs.getString("datosModificados"));
                respuesta = "success";
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	
	/**Método eliminar
	* Eliminar un FrecuenciaAsistencia en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.frecuenciaAsistenciaBo.eliminar(this.frecuenciaAsistencia);
            this.addInfo(null, Bundle.rcs.getString("datosEliminados")); 
            this.reiniciarController();
            this.buscarTodos();
            respuesta = "success";
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
        
	/**
     * Retorna una lista de selectItems que contienen estados del frecuenciaAsistencia
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(FrecuenciaAsistencia.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(FrecuenciaAsistencia.ESTADO_ACTIVO,    FrecuenciaAsistencia.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(FrecuenciaAsistencia.ESTADO_INACTIVO,  FrecuenciaAsistencia.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("FrecuenciaAsistencia.pvInCodigo")) return "form1:pvInCodigo";
			if (property.equals("FrecuenciaAsistencia.pvStDescripcion")) return "form1:pvStDescripcion";
		}
		return null;
	}


	/**
	 * @return the listaDataTable
	 */
	public HtmlDataTable getListaDataTable() {
		return listaDataTable;
	}

	/**
	 * @param listaDataTable the listaDataTable to set
	 */
	public void setListaDataTable(HtmlDataTable listaDataTable) {
		this.listaDataTable = listaDataTable;
	}

	/**
	 * @return the lista
	 */
	public List<FrecuenciaAsistencia> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<FrecuenciaAsistencia> lista) {
		this.lista = lista;
	}

	/**
	 * @return the FrecuenciaAsistencia
	 */
	public FrecuenciaAsistencia getFrecuenciaAsistencia() {
		return this.frecuenciaAsistencia;
	}

	/**
	 * @param FrecuenciaAsistencia the FrecuenciaAsistencia to set
	 */
	public void setFrecuenciaAsistencia(FrecuenciaAsistencia frecuenciaAsistencia) {
		this.frecuenciaAsistencia = frecuenciaAsistencia;
	}


	/**
	 * @param FrecuenciaAsistenciaBo the FrecuenciaAsistenciaBo to set
	 */
	public void setFrecuenciaAsistenciaBo(FrecuenciaAsistenciaBo frecuenciaAsistenciaBo) {
		this.frecuenciaAsistenciaBo = frecuenciaAsistenciaBo;
	}

}
