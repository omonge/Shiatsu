/**
 * 
 */
package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable; 
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
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
public class AgendaCapilarDynamicController extends Controller  {
	  
	 private   List<List<AgendaCapilar>> dynamicList; // Simulate fake DB.
	    private static String[] dynamicHeaders; // Optional.
	    private HtmlPanelGroup dynamicDataTableGroup; // Placeholder.
	    private Long id;
	public AgendaCapilarDynamicController() { 
		this.reiniciarController();
	}
	private List<AgendaCapilar> creaArreglo(int hora){
		 if(this.id==null){
			 this.id = Long.valueOf(1);
		 }
		AgendaCapilar agenda= new AgendaCapilar();
		List<AgendaCapilar> lista = new ArrayList<AgendaCapilar>();
        agenda.setHora(Integer.valueOf(hora));
        agenda.setId(id++);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(hora));
        agenda.setId(id++);
        lista.add(agenda);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(hora));
        lista.add(agenda);
        agenda.setId(id++);
        agenda= new AgendaCapilar();
        agenda.setHora(Integer.valueOf(hora));
        lista.add(agenda); 
        agenda.setId(id++);
        this.id = Long.valueOf(this.id.longValue() + 6);
        return lista;
	}
	private void loadDynamicList() {

        // Set headers (optional).
        dynamicHeaders = new String[] {"ID", "Name", "Value"};

        // Set rows. This is a stub example, just do your dynamic thing.
        this.dynamicList = new ArrayList<List<AgendaCapilar>>();
        dynamicList.add(this.creaArreglo(700)); 
        dynamicList.add(this.creaArreglo(730));  
        dynamicList.add(this.creaArreglo(800)); 
        dynamicList.add(this.creaArreglo(830)); 
        dynamicList.add(this.creaArreglo(900)); 
        dynamicList.add(this.creaArreglo(1000)); 
    }
	 
	 private void populateDynamicDataTable() {

	        // Create <h:dataTable value="#{agendaCapilarDynamicController.dynamicList}" var="dynamicItem">.
	        HtmlDataTable dynamicDataTable = new HtmlDataTable();
	        dynamicDataTable.setValueExpression("value",
	            createValueExpression("#{agendaCapilarDynamicController.dynamicList}", List.class));
	        dynamicDataTable.setVar("dynamicItem");

	        // Iterate over columns.
	        for (int i = 0; i < dynamicList.get(0).size(); i++) {

	            // Create <h:column>.
	            HtmlColumn column = new HtmlColumn();
	            dynamicDataTable.getChildren().add(column);

	           /* // Create <h:outputText value="dynamicHeaders[i]"> for <f:facet name="header"> of column.
	            HtmlOutputText header = new HtmlOutputText();
	            header.setValue(dynamicHeaders[i]);
	            column.setHeader(header);*/

	            // Create <h:outputText value="#{dynamicItem[" + i + "]}"> for the body of column.
	            HtmlOutputText output = new HtmlOutputText();
	            output.setValueExpression("value",
	                createValueExpression("#{dynamicItem[" + i + "].hora}", AgendaCapilar.class));
	            	            column.getChildren().add(output);
	        }

	        // Add the datatable to <h:panelGroup binding="#{agendaCapilarDynamicController.dynamicDataTableGroup}">.
	        dynamicDataTableGroup = new HtmlPanelGroup();
	        dynamicDataTableGroup.getChildren().add(dynamicDataTable);
	    }
	// Getters -----------------------------------------------------------------------------------

	    public HtmlPanelGroup getDynamicDataTableGroup() {
	        // This will be called once in the first RESTORE VIEW phase.
	       // if (dynamicDataTableGroup == null) {
	            loadDynamicList(); // Preload dynamic list.
	            populateDynamicDataTable(); // Populate editable datatable.
	       // }

	        return dynamicDataTableGroup;
	    }

	    public List<List<AgendaCapilar>> getDynamicList() {
	        return dynamicList;
	    }

	    // Setters -----------------------------------------------------------------------------------

	    public void setDynamicDataTableGroup(HtmlPanelGroup dynamicDataTableGroup) {
	        this.dynamicDataTableGroup = dynamicDataTableGroup;
	    }
	    /**
		 * @param dynamicList the dynamicList to set
		 */
		public void setDynamicList(List<List<AgendaCapilar>> dynamicList) {
			this.dynamicList = dynamicList;
		} 
	 // Helpers -----------------------------------------------------------------------------------

	    private ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        return facesContext.getApplication().getExpressionFactory().createValueExpression(
	            facesContext.getELContext(), valueExpression, valueType);
	    }

	    /*private MethodExpression createActionExpression(String actionExpression, Class<?> returnType) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        return facesContext.getApplication().getExpressionFactory().createMethodExpression(
	            facesContext.getELContext(), actionExpression, returnType, new Class[0]);
	    }*/
	@Override
	protected void reiniciarController(){
		this.reiniciarFiltro();
		this.reiniciarDatos(); 
	}
	
	@Override
	protected void reiniciarFiltro(){ 
		this.agregar=Boolean.TRUE;
		 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void reiniciarDatos(){ 
		 
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
	 
	 



    /**
     * Método buscar Busca las listaAgendaCapilar que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        String respuesta = "error";
        
        return respuesta;
    }
 
	public void buscarTodos(){ 
		
	} 
	
	 
	 
	
	 
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("agendaCapilar.pvLoCodigo")) 					return "form1:txtPvLoCodigo";
		}
		return null;
	}
	
}
