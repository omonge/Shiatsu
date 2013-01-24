package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.ProvinciaBo;
import com.shiatsu.dao.ProvinciaDao;
import com.shiatsu.domain.Provincia;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class ProvinciaBoImpl extends BusinessObjectHelper implements ProvinciaBo {

	private ProvinciaDao provinciaDao;
	
	/**
	 * @param pprovinciaDao the pprovinciaDao to set
	 */
	public void setProvinciaDao(ProvinciaDao provinciaDao) {
		this.provinciaDao = provinciaDao;
	}

	@Override
	public void agregar(Provincia provincia) throws BusinessErrorHelper {
		try{
			 if(!this.existe(provincia)){
			 	provincia.setPvObUsuario(Utilidades.getUsuario());
			 	provincia.setPvDaModifica(new Date());
				 this.provinciaDao.agregar(provincia);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("provinciaBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Provincia provincia) throws BusinessErrorHelper {
		try{
			 if(this.provinciaDao.existe(provincia)){
				 provincia.setPvDaModifica(new Date());
				 this.provinciaDao.modificar(provincia);
	         }else{ 
	        	this.addError("provinciaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Provincia provincia) throws BusinessErrorHelper {
		try{
			 if(this.provinciaDao.existe(provincia)){
				 this.provinciaDao.eliminar(provincia);
	         }else{ 
	        	this.addError("provinciaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Provincia buscar(Provincia provincia) { 
		return this.provinciaDao.buscar(provincia);
	}

	@Override
	public boolean existe(Provincia provincia) {
		return this.provinciaDao.existe(provincia);
	}

	@Override
	public List<Provincia> getProvincia() {
		return this.provinciaDao.getProvincia();
	}

	@Override
	public List<Provincia> getProvincia(Provincia provincia) {
		return this.provinciaDao.getProvincia(provincia);
	}

}
