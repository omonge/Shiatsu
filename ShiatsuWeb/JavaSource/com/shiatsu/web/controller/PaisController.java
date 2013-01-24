package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.bo.PaisBo; 
import com.shiatsu.domain.Pais;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Controller;
import com.utilidades.business.BusinessErrorHelper;

public class PaisController  extends Controller{

	private HtmlDataTable listaDataTable;
    private List<Pais>    lista;
    private Pais 	  	  pais;
	private PaisBo	  	  paisBo;  
	

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
	
	public PaisController() {
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
		this.pais = new Pais();
	}

	@Override
	protected void reiniciarDatos() {
		this.listaDataTable = new HtmlDataTable();
		this.lista = new ArrayList<Pais>();
	}
	


	/**
     * Método para validar el código, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

        if ((this.pais.getPvStEstado() != null) && (!Pais.ESTADO_DEFAULT.equals(this.pais.getPvStEstado()))) {
            correcto = true;
    	}
    	if ((this.pais.getPvStDescripcion() != null) && (!"".equals(this.pais.getPvStDescripcion()))) {
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
        if((this.pais.getPvInCodigo()!=null) && (!Pais.PAIS_DEFAULT.equals(this.pais.getPvInCodigo()))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * Método buscar Busca las listapais que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTable != null){this.listaDataTable.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Pais pais = this.paisBo.buscar(this.pais);
            if (pais != null) {
                this.lista.add(pais);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.lista = this.paisBo.getPais(this.pais);
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
		this.lista = this.paisBo.getPais();
        if(this.lista.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la pÃ¡gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.pais = (Pais) this.listaDataTable.getRowData();
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
			if((!this.agregar) && (this.pais.getPvInCodigo() == null) ||(Pais.PAIS_DEFAULT.equals(this.pais.getPvInCodigo()))){
				this.addError(this.getPropertyFieldName("cliente.pvInCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((!this.agregar) && (this.pais.getPvStEstado()== null ||(Pais.ESTADO_DEFAULT.equals(this.pais.getPvStEstado())))){
				this.addError(this.getPropertyFieldName("cliente.pvStEstado"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.pais.getPvStDescripcion()== null || ("".equals(this.pais.getPvStDescripcion())))){
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
            	this.pais.setPvStEstado(Pais.ESTADO_ACTIVO);
                this.paisBo.agregar(this.pais);
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
                this.paisBo.modificar(this.pais);
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
	* Eliminar un pais en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.paisBo.eliminar(this.pais);
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
		items.add(new SelectItem(Pais.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Pais.ESTADO_ACTIVO,    Pais.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(Pais.ESTADO_INACTIVO,  Pais.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
        		
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("pais.pvInCodigo")) return "form1:pvInCodigo";
			if (property.equals("pais.pvStDescripcion")) return "form1:pvStDescripcion";
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
	public List<Pais> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Pais> lista) {
		this.lista = lista;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the paisBo
	 */
	public PaisBo getPaisBo() {
		return paisBo;
	}

	/**
	 * @param paisBo the paisBo to set
	 */
	public void setPaisBo(PaisBo paisBo) {
		this.paisBo = paisBo;
	}

}
