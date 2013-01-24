package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.bo.BodegaBo;
import com.shiatsu.domain.Bodega;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Controller;
import com.utilidades.business.BusinessErrorHelper;

public class BodegaController  extends Controller{

	private HtmlDataTable     	  listaDataTable;
    private List<Bodega>    lista;
    private Bodega 	  	  bodega;
	private BodegaBo	  	  bodegaBo;  
	

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
	
	public BodegaController() {
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
		this.bodega = new Bodega();
	}

	@Override
	protected void reiniciarDatos() {
		this.listaDataTable = new HtmlDataTable();
		this.lista = new ArrayList<Bodega>();
	}
	


	/**
     * Método para validar el código, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

        if ((this.bodega.getPvStEstado() != null) && (!Bodega.ESTADO_DEFAULT.equals(this.bodega.getPvStEstado()))) {
            correcto = true;
    	}
        
    	if ((this.bodega.getPvStDescripcion() != null) && (!"".equals(this.bodega.getPvStDescripcion()))) {
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
        if((this.bodega.getPvInCodigo()!=null) && !(this.bodega.getPvInCodigo().equals(Integer.valueOf(0)))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * Método buscar Busca las lista de Bodegas que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        //if(this.listaDataTable != null){this.listaDataTable.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Bodega bodega = this.bodegaBo.buscar(this.bodega);
            if (bodega != null) {
                this.lista.add(bodega);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.lista = this.bodegaBo.getBodegas(this.bodega);
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
		this.lista = this.bodegaBo.getBodegas();
        if(this.lista.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la pÃ¡gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.bodega = (Bodega) this.listaDataTable.getRowData();
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
			if((!this.agregar) && (this.bodega.getPvInCodigo() == null)){
				this.addError(this.getPropertyFieldName("bodega.pvInCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.bodega.getPvStDescripcion()== null || ("".equals(this.bodega.getPvStDescripcion())))){
				this.addError(this.getPropertyFieldName("bodega.pvStDescripcion"),Bundle.rcs.getString("campoRequerido"));
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
	* Agrega un bodega en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	//this.bodega.setPvStEstado(Bodega.ESTADO_ACTIVO);
                this.bodegaBo.agregar(this.bodega);
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
	* Modificar un bodega en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
                this.bodegaBo.modificar(this.bodega);
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
	* Eliminar un Bodega en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.bodegaBo.eliminar(this.bodega);
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
     * Retorna una lista de selectItems que contienen estados del bodega
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Bodega.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Bodega.ESTADO_ACTIVO,    Bodega.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(Bodega.ESTADO_INACTIVO,  Bodega.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("Bodega.pvInCodigo")) return "form1:pvInCodigo";
			if (property.equals("Bodega.pvStDescripcion")) return "form1:pvStDescripcion";
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
	public List<Bodega> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Bodega> lista) {
		this.lista = lista;
	}

	/**
	 * @return the Bodega
	 */
	public Bodega getBodega() {
		return this.bodega;
	}

	/**
	 * @param Bodega the Bodega to set
	 */
	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}


	/**
	 * @param BodegaBo the BodegaBo to set
	 */
	public void setBodegaBo(BodegaBo bodegaBo) {
		this.bodegaBo = bodegaBo;
	}

}
