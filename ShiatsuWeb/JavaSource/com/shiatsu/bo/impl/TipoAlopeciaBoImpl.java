package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.TipoAlopeciaBo;
import com.shiatsu.dao.TipoAlopeciaDao;
import com.shiatsu.domain.TipoAlopecia;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class TipoAlopeciaBoImpl extends BusinessObjectHelper implements TipoAlopeciaBo {

	private TipoAlopeciaDao tipoAlopeciaDao;
	
	/**
	 * @param tipoAlopeciaDao the pTipoAlopeciaDao to set
	 */
	public void setTipoAlopeciaDao(TipoAlopeciaDao tipoAlopeciaDao) {
		this.tipoAlopeciaDao = tipoAlopeciaDao;
	}

	@Override
	public void agregar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper {
		try{
			 if(!this.existe(tipoAlopecia)){
			 	tipoAlopecia.setPvObUsuario(Utilidades.getUsuario());
			 	tipoAlopecia.setPvDaModifica(new Date());
				 this.tipoAlopeciaDao.agregar(tipoAlopecia);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("TipoAlopeciaBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper {
		try{
			 if(this.tipoAlopeciaDao.existe(tipoAlopecia)){
				 tipoAlopecia.setPvDaModifica(new Date());
				 this.tipoAlopeciaDao.modificar(tipoAlopecia);
	         }else{ 
	        	this.addError("tipoAlopeciaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper {
		try{
			 if(this.tipoAlopeciaDao.existe(tipoAlopecia)){
				 this.tipoAlopeciaDao.eliminar(tipoAlopecia);
	         }else{ 
	        	this.addError("tipoAlopeciaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public TipoAlopecia buscar(TipoAlopecia tipoAlopecia) { 
		return this.tipoAlopeciaDao.buscar(tipoAlopecia);
	}

	@Override
	public boolean existe(TipoAlopecia tipoAlopecia) {
		return this.tipoAlopeciaDao.existe(tipoAlopecia);
	}

	@Override
	public List<TipoAlopecia> getTipoAlopecia() {
		return this.tipoAlopeciaDao.getTipoAlopecia();
	}

	@Override
	public List<TipoAlopecia> getTipoAlopecia(TipoAlopecia tipoAlopecia) {
		return this.tipoAlopeciaDao.getTipoAlopecia(tipoAlopecia);
	}



}
