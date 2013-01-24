package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.SucursalBo;
import com.shiatsu.dao.SucursalDao;
import com.shiatsu.domain.Sucursal;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class SucursalBoImpl extends BusinessObjectHelper implements SucursalBo {

	private SucursalDao sucursalDao;
	
	/**
	 * @param SucursalDao the SucursalDao to set
	 */
	public void setSucursalDao(SucursalDao sucursalDao) {
		this.sucursalDao = sucursalDao;
	}

	@Override
	public void agregar(Sucursal sucursal) throws BusinessErrorHelper {
		try{
			 if(!this.existe(sucursal)){
			 	sucursal.setPvObUsuario(Utilidades.getUsuario());
			 	sucursal.setPvDaModifica(new Date());
				 this.sucursalDao.agregar(sucursal);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("sucursalBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Sucursal sucursal) throws BusinessErrorHelper {
		try{
			 if(this.sucursalDao.existe(sucursal)){
				 sucursal.setPvDaModifica(new Date());
				 this.sucursalDao.modificar(sucursal);
	         }else{ 
	        	this.addError("sucursalBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Sucursal sucursal) throws BusinessErrorHelper {
		try{
			 if(this.sucursalDao.existe(sucursal)){
				 this.sucursalDao.eliminar(sucursal);
	         }else{ 
	        	this.addError("sucursalBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Sucursal buscar(Sucursal sucursal) { 
		return this.sucursalDao.buscar(sucursal);
	}

	@Override
	public boolean existe(Sucursal sucursal) {
		return this.sucursalDao.existe(sucursal);
	}

	@Override
	public List<Sucursal> getSucursales() {
		return this.sucursalDao.getSucursales();
	}

	@Override
	public List<Sucursal> getSucursales(Sucursal sucursal) {
		return this.sucursalDao.getSucursales(sucursal);
	}





}
