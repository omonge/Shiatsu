/**
 * DiagnosticoBoImpl.java
 */
package com.shiatsu.bo.impl;
import java.util.Date;
import java.util.List;

import com.shiatsu.bo.DiagnosticoBo;
import com.shiatsu.dao.DiagnosticoDao;
import com.shiatsu.domain.Diagnostico;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;




/**
 * @author oscar.monge
 *
 */
public class DiagnosticoBoImpl extends BusinessObjectHelper implements DiagnosticoBo {
 
	private DiagnosticoDao diagnosticoDao;
	
	/** @param diagnosticoDao el diagnosticoDao a establecer */
	public void setDiagnosticoDao(DiagnosticoDao diagnosticoDao) {
		this.diagnosticoDao = diagnosticoDao;
	}

	@Override
	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticoDao.getDiagnosticos();
	}

	@Override
	public List<Diagnostico> getDiagnosticos(Diagnostico diagnostico) {
		return this.diagnosticoDao.getDiagnosticos(diagnostico);
	}

	@Override
	public void agregar(Diagnostico diagnostico) throws BusinessErrorHelper {
		try{
			 if(!this.existe(diagnostico)){
			 	diagnostico.setPvObUsuario(Utilidades.getUsuario());
			 	diagnostico.setPvDaModifica(new Date());
				 this.diagnosticoDao.agregar(diagnostico);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("diagnosticoBo.agregar",e.getMessage() );
            this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Diagnostico diagnostico) throws BusinessErrorHelper {
		try{
			 if(this.diagnosticoDao.existe(diagnostico)){
				 diagnostico.setPvDaModifica(new Date());
				 this.diagnosticoDao.modificar(diagnostico);
	         }else{ 
	        	this.addError("diagnosticoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
          e.printStackTrace();
          this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
          this.throwBussinessError();
		}
		
	}

	@Override
	public void eliminar(Diagnostico diagnostico) throws BusinessErrorHelper {
		try{
			this.diagnosticoDao.eliminar(diagnostico);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("diagnosticoBo.eliminar", Bundle.rcs.getString("noExiste"));
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            this.throwBussinessError();
		}
		
	}

	@Override
	public boolean existe(Diagnostico diagnostico) {
		boolean correcto = this.diagnosticoDao.existe(diagnostico);
		return correcto;
	}

	@Override
	public Diagnostico buscar(Diagnostico diagnostico) { 
		return this.diagnosticoDao.buscar(diagnostico);
	}

}
