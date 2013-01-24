package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.CantonBo;
import com.shiatsu.dao.CantonDao;
import com.shiatsu.domain.Canton;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class CantonBoImpl extends BusinessObjectHelper implements CantonBo {

	private CantonDao cantonDao;
	
	/**
	 * @param pCantonDao the pCantonDao to set
	 */
	public void setCantonDao(CantonDao cantonDao) {
		this.cantonDao = cantonDao;
	}

	@Override
	public void agregar(Canton canton) throws BusinessErrorHelper {
		try{
			 if(!this.existe(canton)){
			 	canton.setPvObUsuario(Utilidades.getUsuario());
			 	canton.setPvDaModifica(new Date());
				this.cantonDao.agregar(canton);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("CantonBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Canton canton) throws BusinessErrorHelper {
		try{
			 if(this.cantonDao.existe(canton)){
				 canton.setPvDaModifica(new Date());
				 this.cantonDao.modificar(canton);
	         }else{ 
	        	this.addError("CantonBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Canton canton) throws BusinessErrorHelper {
		try{
			 if(this.cantonDao.existe(canton)){
				 this.cantonDao.eliminar(canton);
	         }else{ 
	        	this.addError("CantonBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Canton buscar(Canton canton) { 
		return this.cantonDao.buscar(canton);
	}

	@Override
	public boolean existe(Canton canton) {
		return this.cantonDao.existe(canton);
	}

	@Override
	public List<Canton> getCanton() {
		return this.cantonDao.getCanton();
	}

	@Override
	public List<Canton> getCanton(Canton canton) {
		return this.cantonDao.getCanton(canton);
	}

}
