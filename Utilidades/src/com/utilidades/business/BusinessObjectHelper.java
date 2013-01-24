/**
 * 
 */
package com.utilidades.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author oscar.monge
 *
 */
public class BusinessObjectHelper {
	private static final long serialVersionUID = 786742911748490584L;
	
	@SuppressWarnings("rawtypes")
	public Map errors;
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public BusinessObjectHelper() {
		this.errors = new TreeMap();
	}
	/**
	 * @return the errors
	 */
	@SuppressWarnings("rawtypes")
	public List getErrors(String property) {
		List propertyErrors;
        if(this.errors!=null && this.errors.get(property) != null){
            propertyErrors = (List) this.errors.get(property);
        } else{
            propertyErrors = new ArrayList();
        }
        return propertyErrors;
	}
	/**
	 * @param errors the errors to set
	 */
	@SuppressWarnings("rawtypes")
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	@SuppressWarnings("rawtypes")
	protected void throwBussinessError() throws BusinessErrorHelper{
		BusinessErrorHelper error = new BusinessErrorHelper();
        error.setErrors(this.errors);
        this.errors = new TreeMap();
        throw error;
    }
	protected void addError(String property, String message){
        List propertyErrors;
        if(this.errors!=null && this.errors.get(property) != null){
            propertyErrors = (List) this.errors.get(property);
        } else{
            propertyErrors = new ArrayList();
        }
        propertyErrors.add(message);
        this.errors.put(property, propertyErrors);
    }
	

}
