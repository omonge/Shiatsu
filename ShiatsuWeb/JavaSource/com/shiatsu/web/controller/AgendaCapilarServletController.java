/**
 * 
 */
package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable; 
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.shiatsu.domain.AgendaCapilar;
import com.shiatsu.web.bundles.Bundle;
//import com.utilidades.business.BusinessErrorHelper;

import com.shiatzu.util.Controller;

/**
 * @author oscar.monge
 *
 */
@SuppressWarnings("deprecation")
public class AgendaCapilarServletController extends Controller  {
	 
    private HtmlDataTable 	listaDataTableAgendaCapilar;
    private List<AgendaCapilar> 	listaAgendaCapilar[][];  
    private List<AgendaCapilar> 	listaAgenda; 
    private AgendaCapilar 	  	agendaCapilar;
    public static final int COLUMNAS 	= 7;
	public static final Integer FILAS	 	= new Integer(10);
	
	public AgendaCapilarServletController() { 
		this.reiniciarController();
	}
	
	@Override
	protected void reiniciarController(){
		this.reiniciarFiltro();
		this.reiniciarDatos(); 
	}
	
	@Override
	protected void reiniciarFiltro(){ 
		this.agregar=Boolean.TRUE;
		this.agendaCapilar=new AgendaCapilar();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void reiniciarDatos(){ 
		this.listaDataTableAgendaCapilar=new HtmlDataTable();
		this.listaAgendaCapilar = new ArrayList[10][10];
		this.listaAgenda = new ArrayList<AgendaCapilar>();
	}
	
	
	/****************** METODOS *************************************/
 
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
	private void creaArregloMulti(){
		for(int i =0;i< 10;i++){
			for(int j =0;j< 10;j++){
				this.listaAgendaCapilar[i][j] = this.creaArreglo(); 
			}
		}
		
	}
	private Integer inicio;
	public List<AgendaCapilar> tome(){
		return this.listaAgenda;
	}
	 
	private List<AgendaCapilar> creaArreglo(){
		if(this.inicio == null){
			inicio=Integer.valueOf(1);
		}else{
			inicio++;
		}
		AgendaCapilar agenda= new AgendaCapilar();
		List<AgendaCapilar> lista = new ArrayList<AgendaCapilar>();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+1);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+2);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+3);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+4);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+5);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+6);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+7);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+8);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+9);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(this.inicio.intValue())+10);
        lista.add(agenda);
        return lista;
	}
    /**
     * MÈtodo abrirPopUp
     * Abre el pop up 
     * @return success
     */
    public String abrirPopUp() {
        this.getFacesContext().getApplication().createValueBinding("#{diagnosticoController.diagnostico}").setValue(this.getFacesContext(), new AgendaCapilar());
        return "success";
    }
 
    /**
     * MÈtodo cerrarPopUpDiagnostico
     * Cierra el pop up
     * @return success
     */ 
    public String cerrarPopUp(){
    	AgendaCapilar agendaCapilar = (AgendaCapilar) this.getFacesContext().getApplication().createValueBinding("#{diagnosticoController.diagnostico}").getValue(this.getFacesContext());
        return "success";
    }




    /**
     * MÈtodo buscar Busca las listaAgendaCapilar que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        String respuesta = "error";
        
        return respuesta;
    }
 
	public void buscarTodos(){
		
		//creaArregloMulti();
        this.listaAgenda = this.creaArreglo();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        session.setAttribute("listaAgenda1", this.listaAgenda);
        
        
	}
	public String action(){
		System.out.println("asdfasdf");
		//this.agendaCapilar = (AgendaCapilar) this.listaDataTableAgendaCapilar.getRowData();
		HtmlColumn column = new HtmlColumn();
		
		return "success";
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la p√°gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.agendaCapilar = (AgendaCapilar) this.listaDataTableAgendaCapilar.getRowData();
	     this.agregar = false;
		 return "success";
	}
		
	

	/**
     * Retorna una lista de selectItems que contienen frecuencia de agendaCapilars del agendaCapilar
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de agendaCapilars del agendaCapilar
     */
	public List<SelectItem> getTipoAlopeciaItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		
		return items;
	}
	
	/*********************** NAVEGACION *******************************/
	/**Metodo irAgregar
	* 
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
	/*********************** VALIDACION  *******************************/
	
	/**Metodo validaInsertar
	* Valida los datos del agendaCapilar
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validaInsertar(){
		boolean correcto = true;
		try{
		}catch(NumberFormatException nef){
            this.addError(null, Bundle.rcs.getString("soloNumeros"));
            nef.printStackTrace();
        }catch(Exception e){
        	this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            e.printStackTrace();
		}
		return correcto;
	}
	
	/**MÈtodo agregar
	* Agrega un agendaCapilar en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            
        /*}catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        */}catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/**MÈtodo modificar
	* Modificar un agendaCapilar en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            
        /*}catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        */}catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/**M√©todo eliminar
	* Eliminar un agendaCapilar en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            
            respuesta = "success";
        /*}catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        */}catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("agendaCapilar.pvLoCodigo")) 					return "form1:txtPvLoCodigo";
		}
		return null;
	}
/********************** SET Y GETS ****************************/
	/**
	 * @return the agendaCapilar
	 */
	public AgendaCapilar getAgendaCapilar() {
		return agendaCapilar;
	} 
  
	/**
	 * @param agendaCapilar the agendaCapilar to set
	 */
	public void setAgendaCapilar(AgendaCapilar agendaCapilar) {
		this.agendaCapilar = agendaCapilar;
	}

	/**
	 * @return the listaDataTableAgendaCapilar
	 */
	public HtmlDataTable getListaDataTableAgendaCapilar() {
		return listaDataTableAgendaCapilar;
	}

	/**
	 * @param listaDataTableAgendaCapilar the listaDataTableAgendaCapilar to set
	 */
	public void setListaDataTableAgendaCapilar(HtmlDataTable listaDataTableAgendaCapilar) {
		this.listaDataTableAgendaCapilar = listaDataTableAgendaCapilar;
	}
	
	/**
	 * @return the listaAgendaCapilar
	 */
	public List<AgendaCapilar>[][] getListaAgendaCapilar() {
		return listaAgendaCapilar;
	}

	/**
	 * @param listaAgendaCapilar the listaAgendaCapilar to set
	 */
	public void setListaAgendaCapilar(List<AgendaCapilar>[][] listaAgendaCapilar) {
		this.listaAgendaCapilar = listaAgendaCapilar;
	}

	public int columnas(){
		return 7;
	}

 

	/**
	 * @return the listaAgenda
	 */
	public List<AgendaCapilar> getListaAgenda() {
		return listaAgenda;
	}

	/**
	 * @param listaAgenda the listaAgenda to set
	 */
	public void setListaAgenda(List<AgendaCapilar> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}
}
