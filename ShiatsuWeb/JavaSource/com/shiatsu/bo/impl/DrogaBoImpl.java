package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.DrogaBo;
import com.shiatsu.dao.DrogaDao;
import com.shiatsu.domain.Droga;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class DrogaBoImpl extends BusinessObjectHelper implements DrogaBo {

	private DrogaDao drogaDao;
	
	/**
	 * @param drogaDao the DrogaDao to set
	 */
	public void setDrogaDao(DrogaDao drogaDao) {
		this.drogaDao = drogaDao;
	}

	@Override
	public void agregar(Droga droga) throws BusinessErrorHelper {
		try{
			 if(!this.existe(droga)){
			 	droga.setPvObUsuario(Utilidades.getUsuario());
			 	droga.setPvDaModifica(new Date());
				 this.drogaDao.agregar(droga);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("DrogaBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Droga droga) throws BusinessErrorHelper {
		try{
			 if(this.drogaDao.existe(droga)){
				 droga.setPvDaModifica(new Date());
				 this.drogaDao.modificar(droga);
	         }else{ 
	        	this.addError("drogaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Droga droga) throws BusinessErrorHelper {
		try{
			 if(this.drogaDao.existe(droga)){
				 this.drogaDao.eliminar(droga);
	         }else{ 
	        	this.addError("drogaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Droga buscar(Droga droga) { 
		return this.drogaDao.buscar(droga);
	}

	@Override
	public boolean existe(Droga droga) {
		return this.drogaDao.existe(droga);
	}

	@Override
	public List<Droga> getDrogas() {
		List<Droga> lista = this.drogaDao.getDrogas();
		return lista;
	}

	@Override
	public List<Droga> getDrogas(Droga droga) {
		return this.drogaDao.getDrogas(droga);
	}





}
