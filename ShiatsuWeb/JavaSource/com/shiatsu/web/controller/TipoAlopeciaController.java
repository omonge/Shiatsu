package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.bo.TipoAlopeciaBo;
import com.shiatsu.domain.TipoAlopecia;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Controller;
import com.utilidades.business.BusinessErrorHelper;

public class TipoAlopeciaController  extends Controller{

	private HtmlDataTable     	  listaDataTable;
    private List<TipoAlopecia>    lista;
    private TipoAlopecia 	  	  tipoAlopecia;
	private TipoAlopeciaBo	  	  tipoAlopeciaBo;  
	

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
	
	public TipoAlopeciaController() {
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
		this.tipoAlopecia = new TipoAlopecia();
	}

	@Override
	protected void reiniciarDatos() {
		this.listaDataTable = new HtmlDataTable();
		this.lista = new ArrayList<TipoAlopecia>();
	}
	


	/**
     * Método para validar el código, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

        if ((this.tipoAlopecia.getPvStEstado() != null) && (!TipoAlopecia.ESTADO_DEFAULT.equals(this.tipoAlopecia.getPvStEstado()))) {
            correcto = true;
    	}
    	if ((this.tipoAlopecia.getPvStDescripcion() != null) && (!"".equals(this.tipoAlopecia.getPvStDescripcion()))) {
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
        if((this.tipoAlopecia.getPvInCodigo()!=null) && (!TipoAlopecia.TIPO_APOPECIA_DEFAULT.equals(this.tipoAlopecia.getPvInCodigo()))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * Método buscar Busca las listaTipoAlopecia que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTable != null){this.listaDataTable.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            TipoAlopecia TipoAlopecia = this.tipoAlopeciaBo.buscar(this.tipoAlopecia);
            if (TipoAlopecia != null) {
                this.lista.add(TipoAlopecia);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.lista = this.tipoAlopeciaBo.getTipoAlopecia(this.tipoAlopecia);
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
		this.lista = this.tipoAlopeciaBo.getTipoAlopecia();
        if(this.lista.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la pÃ¡gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.tipoAlopecia = (TipoAlopecia) this.listaDataTable.getRowData();
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
			if((!this.agregar) && (this.tipoAlopecia.getPvInCodigo() == null) ||(TipoAlopecia.TIPO_APOPECIA_DEFAULT.equals(this.tipoAlopecia.getPvInCodigo()))){
				this.addError(this.getPropertyFieldName("cliente.pvInCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((!this.agregar) && (this.tipoAlopecia.getPvStEstado()== null ||(TipoAlopecia.ESTADO_DEFAULT.equals(this.tipoAlopecia.getPvStEstado())))){
				this.addError(this.getPropertyFieldName("cliente.pvStEstado"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.tipoAlopecia.getPvStDescripcion()== null || ("".equals(this.tipoAlopecia.getPvStDescripcion())))){
				this.addError(this.getPropertyFieldName("cliente.pvStDescripcion"),Bundle.rcs.getString("campoRequerido"));
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
	* Agrega un cliente en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	this.tipoAlopecia.setPvStEstado(TipoAlopecia.ESTADO_ACTIVO);
                this.tipoAlopeciaBo.agregar(this.tipoAlopecia);
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
	* Modificar un cliente en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
                this.tipoAlopeciaBo.modificar(this.tipoAlopecia);
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
	* Eliminar un TipoAlopecia en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.tipoAlopeciaBo.eliminar(this.tipoAlopecia);
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
     * Retorna una lista de selectItems que contienen estados del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(TipoAlopecia.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(TipoAlopecia.ESTADO_ACTIVO,    TipoAlopecia.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(TipoAlopecia.ESTADO_INACTIVO,  TipoAlopecia.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("TipoAlopecia.pvInCodigo")) return "form1:pvInCodigo";
			if (property.equals("TipoAlopecia.pvStDescripcion")) return "form1:pvStDescripcion";
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
	public List<TipoAlopecia> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<TipoAlopecia> lista) {
		this.lista = lista;
	}

	/**
	 * @return the TipoAlopecia
	 */
	public TipoAlopecia getTipoAlopecia() {
		return this.tipoAlopecia;
	}

	/**
	 * @param TipoAlopecia the TipoAlopecia to set
	 */
	public void setTipoAlopecia(TipoAlopecia TipoAlopecia) {
		this.tipoAlopecia = TipoAlopecia;
	}

	/**
	 * @return the TipoAlopeciaBo
	 */
	public TipoAlopeciaBo getTipoAlopeciaBo() {
		return this.tipoAlopeciaBo;
	}

	/**
	 * @param TipoAlopeciaBo the TipoAlopeciaBo to set
	 */
	public void setTipoAlopeciaBo(TipoAlopeciaBo TipoAlopeciaBo) {
		this.tipoAlopeciaBo = TipoAlopeciaBo;
	}

}
