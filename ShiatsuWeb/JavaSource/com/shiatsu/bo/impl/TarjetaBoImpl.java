package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.TarjetaBo;
import com.shiatsu.dao.TarjetaDao;
import com.shiatsu.domain.Tarjeta;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class TarjetaBoImpl extends BusinessObjectHelper implements TarjetaBo {

	private TarjetaDao tarjetaDao;
	
	/**
	 * @param TarjetaDao the TarjetaDao to set
	 */
	public void setTarjetaDao(TarjetaDao tarjetaDao) {
		this.tarjetaDao = tarjetaDao;
	}

	@Override
	public void agregar(Tarjeta tarjeta) throws BusinessErrorHelper {
		try{
			 if(!this.existe(tarjeta)){
			 	tarjeta.setPvObUsuario(Utilidades.getUsuario());
			 	tarjeta.setPvDaModifica(new Date());
				 this.tarjetaDao.agregar(tarjeta);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("tarjetaBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Tarjeta tarjeta) throws BusinessErrorHelper {
		try{
			 if(this.tarjetaDao.existe(tarjeta)){
				 tarjeta.setPvDaModifica(new Date());
				 this.tarjetaDao.modificar(tarjeta);
	         }else{ 
	        	this.addError("tarjetaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Tarjeta tarjeta) throws BusinessErrorHelper {
		try{
			 if(this.tarjetaDao.existe(tarjeta)){
				 this.tarjetaDao.eliminar(tarjeta);
	         }else{ 
	        	this.addError("tarjetaBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Tarjeta buscar(Tarjeta tarjeta) { 
		return this.tarjetaDao.buscar(tarjeta);
	}

	@Override
	public boolean existe(Tarjeta tarjeta) {
		return this.tarjetaDao.existe(tarjeta);
	}

	@Override
	public List<Tarjeta> getTarjetas() {
		return this.tarjetaDao.getTarjetas();
	}

	@Override
	public List<Tarjeta> getTarjetas(Tarjeta tarjeta) {
		return this.tarjetaDao.getTarjetas(tarjeta);
	}





}
