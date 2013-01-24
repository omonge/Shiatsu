package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.ProfesionBo;
import com.shiatsu.dao.ProfesionDao;
import com.shiatsu.domain.Profesion;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class ProfesionBoImpl extends BusinessObjectHelper implements ProfesionBo {

	private ProfesionDao profesionDao;
	
	/**
	 * @param pprofesionDao the pprofesionDao to set
	 */
	public void setProfesionDao(ProfesionDao profesionDao) {
		this.profesionDao = profesionDao;
	}

	@Override
	public void agregar(Profesion profesion) throws BusinessErrorHelper {
		try{
			 if(!this.existe(profesion)){
			 	profesion.setPvObUsuario(Utilidades.getUsuario());
			 	profesion.setPvDaModifica(new Date());
				 this.profesionDao.agregar(profesion);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("profesionBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Profesion profesion) throws BusinessErrorHelper {
		try{
			 if(this.profesionDao.existe(profesion)){
				 profesion.setPvDaModifica(new Date());
				 this.profesionDao.modificar(profesion);
	         }else{ 
	        	this.addError("profesionBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Profesion profesion) throws BusinessErrorHelper {
		try{
			 if(this.profesionDao.existe(profesion)){
				 this.profesionDao.eliminar(profesion);
	         }else{ 
	        	this.addError("profesionBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Profesion buscar(Profesion profesion) { 
		return this.profesionDao.buscar(profesion);
	}

	@Override
	public boolean existe(Profesion profesion) {
		return this.profesionDao.existe(profesion);
	}

	@Override
	public List<Profesion> getProfesion() {
		return this.profesionDao.getProfesion();
	}

	@Override
	public List<Profesion> getProfesion(Profesion profesion) {
		return this.profesionDao.getProfesion(profesion);
	}

}
