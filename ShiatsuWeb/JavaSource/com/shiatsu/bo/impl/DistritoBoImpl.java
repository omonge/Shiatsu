package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.DistritoBo;
import com.shiatsu.dao.DistritoDao;
import com.shiatsu.domain.Distrito;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class DistritoBoImpl extends BusinessObjectHelper implements DistritoBo {

	private DistritoDao distritoDao;
	
	/**
	 * @param pDistritoDao the pDistritoDao to set
	 */
	public void setDistritoDao(DistritoDao DistritoDao) {
		this.distritoDao = DistritoDao;
	}

	@Override
	public void agregar(Distrito distrito) throws BusinessErrorHelper {
		try{
			 if(!this.existe(distrito)){
			 	distrito.setPvObUsuario(Utilidades.getUsuario());
			 	distrito.setPvDaModifica(new Date());
				 this.distritoDao.agregar(distrito);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("DistritoBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Distrito distrito) throws BusinessErrorHelper {
		try{
			 if(this.distritoDao.existe(distrito)){
				 distrito.setPvDaModifica(new Date());
				 this.distritoDao.modificar(distrito);
	         }else{ 
	        	this.addError("DistritoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Distrito distrito) throws BusinessErrorHelper {
		try{
			 if(this.distritoDao.existe(distrito)){
				 this.distritoDao.eliminar(distrito);
	         }else{ 
	        	this.addError("DistritoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Distrito buscar(Distrito distrito) { 
		return this.distritoDao.buscar(distrito);
	}

	@Override
	public boolean existe(Distrito distrito) {
		return this.distritoDao.existe(distrito);
	}

	@Override
	public List<Distrito> getDistrito() {
		return this.distritoDao.getDistrito();
	}

	@Override
	public List<Distrito> getDistrito(Distrito distrito) {
		return this.distritoDao.getDistrito(distrito);
	}

}
