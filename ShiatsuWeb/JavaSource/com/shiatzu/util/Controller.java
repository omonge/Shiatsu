package com.shiatzu.util;


import com.utilidades.web.faces.FacesController;

public abstract class Controller  extends FacesController{

	protected boolean 	  init;
	protected boolean 	  agregar;
    
	public Controller()  {
		super();
	}

	/***
	 * reinicia el controller
	 */
	protected abstract void reiniciarController();
	
	/***
	 * reinicia el filtro (variables del controller)
	 */
	protected abstract void reiniciarFiltro();
	
	/***
	 * reinicia los datos (listas y datatables)
	 */
	protected abstract void reiniciarDatos();
	
	@Override
	protected abstract String getPropertyFieldName(String arg0) ;
	
	
	/***
	 * Agrega un error a la lista de mensaje en el campo indicado
	 * @param campo
	 * @param mensaje
	 */
	protected void addError(String campo,String mensaje){
		this.addMessage(campo, mensaje,null,FacesController.ERROR);
	}
	
	/***
	 * Agrega un info a la lista de mensaje en el campo indicado
	 * @param campo
	 * @param mensaje
	 */
	protected void addInfo(String campo,String mensaje){
		this.addMessage(campo, mensaje,null,FacesController.INFO);
	}
	
	/***
	 * Agrega un warning a la lista de mensaje en el campo indicado
	 * @param campo
	 * @param mensaje
	 */
	protected void addWarning(String campo,String mensaje){
		this.addMessage(campo, mensaje,null,FacesController.WARNING);
	}
	
	/**
	 * @param init the init to set
	 */
	public void setInit(boolean init) {
		this.init = init;
	}

	/**
	 * @return the agregar
	 */
	public boolean getAgregar() {
		return this.agregar;
	}

	/**
	 * @param agregar the agregar to set
	 */
	public void setAgregar(boolean agregar) {
		this.agregar = agregar;
	}

}
