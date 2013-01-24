package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import com.shiatsu.bo.MedicamentoBo;
import com.shiatsu.domain.Medicamento;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Controller;
import com.utilidades.business.BusinessErrorHelper;

public class MedicamentoController  extends Controller{

	private HtmlDataTable     	listaDataTable;
    private List<Medicamento>	lista;
    private Medicamento 	  	  	medicamento;
	private MedicamentoBo	  	medicamentoBo;  
	

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
	
	public MedicamentoController() {
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
		this.medicamento = new Medicamento();
	}

	@Override
	protected void reiniciarDatos() {
		this.listaDataTable = new HtmlDataTable();
		this.lista = new ArrayList<Medicamento>();
	}
	


	/**
     * Método para validar el código, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

        if ((this.medicamento.getPvStEstado() != null) && (!Medicamento.ESTADO_DEFAULT.equals(this.medicamento.getPvStEstado()))) {
            correcto = true;
    	}
    	if ((this.medicamento.getPvStDescripcion() != null) && (!"".equals(this.medicamento.getPvStDescripcion()))) {
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
        if((this.medicamento.getPvInCodigo()!=null) && (!Medicamento.MEDICAMENTO_DEFAULT.equals(this.medicamento.getPvInCodigo()))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * Método buscar Busca las listamedicamento que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTable != null){this.listaDataTable.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Medicamento medicamento = this.medicamentoBo.buscar(this.medicamento);
            if (medicamento != null) {
                this.lista.add(medicamento);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.lista = this.medicamentoBo.getMedicamento(this.medicamento);
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
		this.lista = this.medicamentoBo.getMedicamento();
        if(this.lista.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la pÃ¡gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.medicamento = (Medicamento) this.listaDataTable.getRowData();
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
			if((!this.agregar) && (this.medicamento.getPvInCodigo() == null) ||(Medicamento.MEDICAMENTO_DEFAULT.equals(this.medicamento.getPvInCodigo()))){
				this.addError(this.getPropertyFieldName("cliente.pvInCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((!this.agregar) && (this.medicamento.getPvStEstado()== null ||(Medicamento.ESTADO_DEFAULT.equals(this.medicamento.getPvStEstado())))){
				this.addError(this.getPropertyFieldName("cliente.pvStEstado"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.medicamento.getPvStDescripcion()== null || ("".equals(this.medicamento.getPvStDescripcion())))){
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
            	this.medicamento.setPvStEstado(Medicamento.ESTADO_ACTIVO);
                this.medicamentoBo.agregar(this.medicamento);
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
                this.medicamentoBo.modificar(this.medicamento);
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
	* Eliminar un medicamento en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.medicamentoBo.eliminar(this.medicamento);
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
		items.add(new SelectItem(Medicamento.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Medicamento.ESTADO_ACTIVO,    Medicamento.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(Medicamento.ESTADO_INACTIVO,  Medicamento.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
        		
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("medicamento.pvInCodigo")) return "form1:pvInCodigo";
			if (property.equals("medicamento.pvStDescripcion")) return "form1:pvStDescripcion";
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
	public List<Medicamento> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Medicamento> lista) {
		this.lista = lista;
	}

	/**
	 * @return the medicamento
	 */
	public Medicamento getMedicamento() {
		return medicamento;
	}

	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	/**
	 * @return the medicamentoBo
	 */
	public MedicamentoBo getMedicamentoBo() {
		return medicamentoBo;
	}

	/**
	 * @param medicamentoBo the medicamentoBo to set
	 */
	public void setMedicamentoBo(MedicamentoBo medicamentoBo) {
		this.medicamentoBo = medicamentoBo;
	}

}
