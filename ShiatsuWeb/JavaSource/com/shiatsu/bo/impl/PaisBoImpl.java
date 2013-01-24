package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.PaisBo;
import com.shiatsu.dao.PaisDao;
import com.shiatsu.domain.Pais;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class PaisBoImpl extends BusinessObjectHelper implements PaisBo {

	private PaisDao paisDao;
	
	/**
	 * @param ppaisDao the ppaisDao to set
	 */
	public void setPaisDao(PaisDao paisDao) {
		this.paisDao = paisDao;
	}

	@Override
	public void agregar(Pais pais) throws BusinessErrorHelper {
		try{
			 if(!this.existe(pais)){
			 	pais.setPvObUsuario(Utilidades.getUsuario());
			 	pais.setPvDaModifica(new Date());
				 this.paisDao.agregar(pais);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("paisBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Pais pais) throws BusinessErrorHelper {
		try{
			 if(this.paisDao.existe(pais)){
				 pais.setPvDaModifica(new Date());
				 this.paisDao.modificar(pais);
	         }else{ 
	        	this.addError("paisBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Pais pais) throws BusinessErrorHelper {
		try{
			 if(this.paisDao.existe(pais)){
				 this.paisDao.eliminar(pais);
	         }else{ 
	        	this.addError("paisBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Pais buscar(Pais pais) { 
		return this.paisDao.buscar(pais);
	}

	@Override
	public boolean existe(Pais pais) {
		return this.paisDao.existe(pais);
	}

	@Override
	public List<Pais> getPais() {
		return this.paisDao.getPais();
	}

	@Override
	public List<Pais> getPais(Pais pais) {
		return this.paisDao.getPais(pais);
	}

}
