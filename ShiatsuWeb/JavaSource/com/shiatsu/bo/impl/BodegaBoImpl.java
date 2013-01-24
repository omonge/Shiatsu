package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.BodegaBo;
import com.shiatsu.dao.BodegaDao;
import com.shiatsu.domain.Bodega;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class BodegaBoImpl extends BusinessObjectHelper implements BodegaBo {

	private BodegaDao bodegaDao;
	
	/**
	 * @param BodegaDao the BodegaDao to set
	 */
	public void setBodegaDao(BodegaDao bodegaDao) {
		this.bodegaDao = bodegaDao;
	}

	@Override
	public void agregar(Bodega bodega) throws BusinessErrorHelper {
		try{
			 if(!this.existe(bodega)){
				 bodega.setPvObUsuario(Utilidades.getUsuario());
				 bodega.setPvDaModifica(new Date());
				 this.bodegaDao.agregar(bodega);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("bodegaBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Bodega bodega) throws BusinessErrorHelper {
		try{
			 if(this.bodegaDao.existe(bodega)){
				 bodega.setPvDaModifica(new Date());
				 this.bodegaDao.modificar(bodega);
	         }else{ 
	        	this.addError("bodegaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Bodega bodega) throws BusinessErrorHelper {
		try{
			 if(this.bodegaDao.existe(bodega)){
				 this.bodegaDao.eliminar(bodega);
	         }else{ 
	        	this.addError("bodegaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Bodega buscar(Bodega bodega) { 
		return this.bodegaDao.buscar(bodega);
	}

	@Override
	public boolean existe(Bodega bodega) {
		return this.bodegaDao.existe(bodega);
	}

	@Override
	public List<Bodega> getBodegas() {
		return this.bodegaDao.getBodegas();
	}

	@Override
	public List<Bodega> getBodegas(Bodega bodega) {
		return this.bodegaDao.getBodegas(bodega);
	}





}
