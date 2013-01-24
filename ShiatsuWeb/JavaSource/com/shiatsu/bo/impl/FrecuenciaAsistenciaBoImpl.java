package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.FrecuenciaAsistenciaBo;
import com.shiatsu.dao.FrecuenciaAsistenciaDao;
import com.shiatsu.domain.FrecuenciaAsistencia;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class FrecuenciaAsistenciaBoImpl extends BusinessObjectHelper implements FrecuenciaAsistenciaBo {

	private FrecuenciaAsistenciaDao frecuenciaAsistenciaDao;
	
	/**
	 * @param FrecuenciaAsistenciaDao the FrecuenciaAsistenciaDao to set
	 */
	public void setFrecuenciaAsistenciaDao(FrecuenciaAsistenciaDao frecuenciaAsistenciaDao) {
		this.frecuenciaAsistenciaDao = frecuenciaAsistenciaDao;
	}

	@Override
	public void agregar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper {
		try{
			 if(!this.existe(frecuenciaAsistencia)){
			 	frecuenciaAsistencia.setPvObUsuario(Utilidades.getUsuario());
			 	frecuenciaAsistencia.setPvDaModifica(new Date());
				 this.frecuenciaAsistenciaDao.agregar(frecuenciaAsistencia);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("frecuenciaAsistenciaBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper {
		try{
			 if(this.frecuenciaAsistenciaDao.existe(frecuenciaAsistencia)){
				 frecuenciaAsistencia.setPvDaModifica(new Date());
				 this.frecuenciaAsistenciaDao.modificar(frecuenciaAsistencia);
	         }else{ 
	        	this.addError("frecuenciaAsistenciaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper {
		try{
			 if(this.frecuenciaAsistenciaDao.existe(frecuenciaAsistencia)){
				 this.frecuenciaAsistenciaDao.eliminar(frecuenciaAsistencia);
	         }else{ 
	        	this.addError("frecuenciaAsistenciaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public FrecuenciaAsistencia buscar(FrecuenciaAsistencia frecuenciaAsistencia) { 
		return this.frecuenciaAsistenciaDao.buscar(frecuenciaAsistencia);
	}

	@Override
	public boolean existe(FrecuenciaAsistencia frecuenciaAsistencia) {
		return this.frecuenciaAsistenciaDao.existe(frecuenciaAsistencia);
	}

	@Override
	public List<FrecuenciaAsistencia> getFrecuenciaAsistencias() {
		return this.frecuenciaAsistenciaDao.getFrecuenciaAsistencias();
	}

	@Override
	public List<FrecuenciaAsistencia> getFrecuenciaAsistencias(FrecuenciaAsistencia frecuenciaAsistencia) {
		return this.frecuenciaAsistenciaDao.getFrecuenciaAsistencias(frecuenciaAsistencia);
	}





}
