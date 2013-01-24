package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.SuministroBo;
import com.shiatsu.dao.SuministroDao;
import com.shiatsu.domain.Suministro;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class SuministroBoImpl extends BusinessObjectHelper implements SuministroBo {

	private SuministroDao suministroDao;
	
	/**
	 * @param SuministroDao the SuministroDao to set
	 */
	public void setSuministroDao(SuministroDao suministroDao) {
		this.suministroDao = suministroDao;
	}

	@Override
	public void agregar(Suministro suministro) throws BusinessErrorHelper {
		try{
			 if(!this.existe(suministro)){
			 	suministro.setPvObUsuario(Utilidades.getUsuario());
			 	suministro.setPvDaModifica(new Date());
				 this.suministroDao.agregar(suministro);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("suministroBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Suministro suministro) throws BusinessErrorHelper {
		try{
			 if(this.suministroDao.existe(suministro)){
				 suministro.setPvDaModifica(new Date());
				 this.suministroDao.modificar(suministro);
	         }else{ 
	        	this.addError("suministroBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Suministro suministro) throws BusinessErrorHelper {
		try{
			 if(this.suministroDao.existe(suministro)){
				 this.suministroDao.eliminar(suministro);
	         }else{ 
	        	this.addError("suministroBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Suministro buscar(Suministro suministro) { 
		return this.suministroDao.buscar(suministro);
	}

	@Override
	public boolean existe(Suministro suministro) {
		return this.suministroDao.existe(suministro);
	}

	@Override
	public List<Suministro> getSuministros() {
		return this.suministroDao.getSuministros();
	}

	@Override
	public List<Suministro> getSuministros(Suministro suministro) {
		return this.suministroDao.getSuministros(suministro);
	}





}
