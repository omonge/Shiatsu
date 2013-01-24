package com.shiatzu.util;

import java.util.ArrayList;
import java.util.List;


import javax.faces.model.SelectItem;

import com.shiatsu.domain.Usuario;

public class Utilidades {
	
	public Utilidades() {
		// TODO Auto-generated constructor stub
	}
	
 public static Usuario getUsuario() {
	    	Usuario usuario= new Usuario();
	    	usuario.setPvInCodigo(123);
	        /*HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	        
	        if (session != null) {
	             usuario  =  (Usuario)session.getAttribute("usuario");
	        }*/
	        return usuario;
	}
    /**
     * 
     * Metodo getMeses
     * @return Lista con objetos SelectItem con codigos Integer de 1 a 12 y Descripci�n del Mes
     */
    public static List<SelectItem>  getMesesItems(){
        List<SelectItem> meses = new ArrayList<SelectItem>();
        meses.add(new SelectItem(Integer.valueOf(0),  "Seleccione un mes"));
        meses.add(new SelectItem(Integer.valueOf(1), "ENERO"));
        meses.add(new SelectItem(Integer.valueOf(2), "FEBRERO"));
        meses.add(new SelectItem(Integer.valueOf(3), "MARZO"));
        meses.add(new SelectItem(Integer.valueOf(4), "ABRIL"));
        meses.add(new SelectItem(Integer.valueOf(5), "MAYO"));
        meses.add(new SelectItem(Integer.valueOf(6), "JUNIO"));
        meses.add(new SelectItem(Integer.valueOf(7), "JULIO"));
        meses.add(new SelectItem(Integer.valueOf(8), "AGOSTO"));
        meses.add(new SelectItem(Integer.valueOf(9), "SEPTIEMBRE"));
        meses.add(new SelectItem(Integer.valueOf(10),"OCTUBRE"));
        meses.add(new SelectItem(Integer.valueOf(11),"NOVIEMBRE"));
        meses.add(new SelectItem(Integer.valueOf(12),"DICIEMBRE"));
        return meses;
    }

}
