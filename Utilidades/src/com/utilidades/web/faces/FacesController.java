package com.utilidades.web.faces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.utilidades.business.BusinessErrorHelper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author oscar.monge
 *
 */
@SuppressWarnings({ "rawtypes", "deprecation" })
public abstract class FacesController {
	private FacesContext facesContext;
	protected Map requestScope;
	protected Map sessionScope;
	protected Map applicationScope;
	protected Map requestParam;
	public static Integer ERROR 	= Integer.valueOf(1);
	public static Integer WARNING 	= Integer.valueOf(2);
	public static Integer INFO 		= Integer.valueOf(3);
	
	
	public FacesController() {
		this.facesContext = this.getFacesContext();
        this.requestScope = (Map) this.facesContext.getApplication().createValueBinding("#{requestScope}").getValue(this.facesContext);
		this.sessionScope = (Map) this.facesContext.getApplication().createValueBinding("#{sessionScope}").getValue(this.facesContext);
		this.applicationScope = (Map) this.facesContext.getApplication().createValueBinding("#{applicationScope}").getValue(this.facesContext);
		this.requestParam = (Map) this.facesContext.getApplication().createValueBinding("#{param}").getValue(this.facesContext);
	}
	protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
	protected void addMessage(String field, String messageSummary, String messageDetail, Integer severity){
        FacesMessage msg = new FacesMessage();
        this.setSeverityMessage(msg,severity);
        msg.setSummary(messageSummary);
        if(messageDetail!=null){
        	msg.setDetail(messageDetail);
        }
        this.getFacesContext().addMessage(field, msg);
    }
	private void setSeverityMessage(FacesMessage msg,Integer severity){
		if(severity!=null){
			switch(severity.intValue()){
				case 1 :{
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				}break;
				case 2 :{
					msg.setSeverity(FacesMessage.SEVERITY_INFO);
				}break;
				case 3 :{
					msg.setSeverity(FacesMessage.SEVERITY_WARN);
				}break;
				default:{
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				};
			}
		}else{
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
	}
	protected abstract String getPropertyFieldName(String property);
	
	protected void exceptionBussinessError(BusinessErrorHelper error){
	        Map errors = error.getErrors();
	        Iterator keyIterator = errors.keySet().iterator();
	        while(keyIterator.hasNext()){
	            String property = (String) keyIterator.next();
	            List messages = (List) errors.get(property);
	            if(messages != null && !messages.isEmpty()){
	                for(int i = 0; i < messages.size(); i++){
	                    String message = (String) messages.get(i);
	                    String field = this.getPropertyFieldName(property);
	                    this.addMessage(field, message,null,FacesController.ERROR);
	                }
	            }
	        }
	    }
}
