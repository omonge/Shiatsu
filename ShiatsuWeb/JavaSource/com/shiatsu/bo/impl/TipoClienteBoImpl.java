package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.TipoClienteBo;
import com.shiatsu.dao.TipoClienteDao;
import com.shiatsu.domain.TipoCliente;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class TipoClienteBoImpl extends BusinessObjectHelper implements TipoClienteBo {

	private TipoClienteDao tipoClienteDao;
	
	/**
	 * @param TipoClienteDao the TipoClienteDao to set
	 */
	public void setTipoClienteDao(TipoClienteDao tipoClienteDao) {
		this.tipoClienteDao = tipoClienteDao;
	}

	@Override
	public void agregar(TipoCliente tipoCliente) throws BusinessErrorHelper {
		try{
			 if(!this.existe(tipoCliente)){
			 	tipoCliente.setPvObUsuario(Utilidades.getUsuario());
			 	tipoCliente.setPvDaModifica(new Date());
				 this.tipoClienteDao.agregar(tipoCliente);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("tipoClienteBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(TipoCliente tipoCliente) throws BusinessErrorHelper {
		try{
			 if(this.tipoClienteDao.existe(tipoCliente)){
				 tipoCliente.setPvDaModifica(new Date());
				 this.tipoClienteDao.modificar(tipoCliente);
	         }else{ 
	        	this.addError("tipoClienteBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(TipoCliente tipoCliente) throws BusinessErrorHelper {
		try{
			 if(this.tipoClienteDao.existe(tipoCliente)){
				 this.tipoClienteDao.eliminar(tipoCliente);
	         }else{ 
	        	this.addError("tipoClienteBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public TipoCliente buscar(TipoCliente tipoCliente) { 
		return this.tipoClienteDao.buscar(tipoCliente);
	}

	@Override
	public boolean existe(TipoCliente tipoCliente) {
		return this.tipoClienteDao.existe(tipoCliente);
	}

	@Override
	public List<TipoCliente> getTipoClientes() {
		return this.tipoClienteDao.getTipoClientes();
	}

	@Override
	public List<TipoCliente> getTipoClientes(TipoCliente tipoCliente) {
		return this.tipoClienteDao.getTipoClientes(tipoCliente);
	}





}
