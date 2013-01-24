package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.EnfermedadBo;
import com.shiatsu.dao.EnfermedadDao;
import com.shiatsu.domain.Enfermedad;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class EnfermedadBoImpl extends BusinessObjectHelper implements EnfermedadBo {

	private EnfermedadDao enfermedadDao;
	
	/**
	 * @param pEnfermedadDao the pEnfermedadDao to set
	 */
	public void setEnfermedadDao(EnfermedadDao EnfermedadDao) {
		this.enfermedadDao = EnfermedadDao;
	}

	@Override
	public void agregar(Enfermedad enfermedad) throws BusinessErrorHelper {
		try{
			 if(!this.existe(enfermedad)){
				 enfermedad.setPvObUsuario(Utilidades.getUsuario());
				 enfermedad.setPvDaModifica(new Date());
				 this.enfermedadDao.agregar(enfermedad);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("EnfermedadBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Enfermedad enfermedad) throws BusinessErrorHelper {
		try{
			 if(this.enfermedadDao.existe(enfermedad)){
				 //enfermedad.setPvObUsuario(Utilidades.getUsuario());
				 enfermedad.setPvDaModifica(new Date());
				 this.enfermedadDao.modificar(enfermedad);
	         }else{ 
	        	this.addError("EnfermedadBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Enfermedad enfermedad) throws BusinessErrorHelper {
		try{
			 if(this.enfermedadDao.existe(enfermedad)){
				 this.enfermedadDao.eliminar(enfermedad);
	         }else{ 
	        	this.addError("EnfermedadBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Enfermedad buscar(Enfermedad enfermedad) { 
		return this.enfermedadDao.buscar(enfermedad);
	}

	@Override
	public boolean existe(Enfermedad enfermedad) {
		return this.enfermedadDao.existe(enfermedad);
	}

	@Override
	public List<Enfermedad> getEnfermedad() {
		return this.enfermedadDao.getEnfermedad();
	}

	@Override
	public List<Enfermedad> getEnfermedad(Enfermedad enfermedad) {
		return this.enfermedadDao.getEnfermedad(enfermedad);
	}

}
