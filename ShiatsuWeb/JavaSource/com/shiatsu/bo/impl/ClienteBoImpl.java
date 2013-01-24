/**
 * ClienteBoImpl.java
 */
package com.shiatsu.bo.impl;
import java.util.Date;
import java.util.List;

import com.shiatsu.bo.ClienteBo;
import com.shiatsu.dao.ClienteDao;
import com.shiatsu.domain.Cliente;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;




/**
 * @author oscar.monge
 *
 */
public class ClienteBoImpl extends BusinessObjectHelper implements ClienteBo {
 
	private ClienteDao clienteDao;
	
	/** @param clienteDao el clienteDao a establecer */
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public List<Cliente> getClientes() {
		return this.clienteDao.getClientes();
	}

	@Override
	public List<Cliente> getClientes(Cliente cliente) {
		return this.clienteDao.getClientes(cliente);
	}

	@Override
	public void agregar(Cliente cliente) throws BusinessErrorHelper {
		try{
			 if(!this.existe(cliente)){
			 	cliente.setPvObUsuario(Utilidades.getUsuario());
			 	cliente.setPvDaModifica(new Date());
				 this.clienteDao.agregar(cliente);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("clienteBo.agregar",e.getMessage() );
            this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Cliente cliente) throws BusinessErrorHelper {
		try{
			 if(this.clienteDao.existe(cliente)){
				 cliente.setPvDaModifica(new Date());
				 this.clienteDao.modificar(cliente);
	         }else{ 
	        	this.addError("clienteBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
          e.printStackTrace();
          this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
          this.throwBussinessError();
		}
		
	}

	@Override
	public void eliminar(Cliente cliente) throws BusinessErrorHelper {
		try{
			this.clienteDao.eliminar(cliente);
		}catch (Exception e) {
            e.printStackTrace();
            this.addError("clienteBo.eliminar", Bundle.rcs.getString("noExiste"));
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            this.throwBussinessError();
		}
		
	}

	@Override
	public boolean existe(Cliente cliente) {
		boolean correcto = this.clienteDao.existe(cliente);
		return correcto;
	}

	@Override
	public Cliente buscar(Cliente cliente) { 
		return this.clienteDao.buscar(cliente);
	}

}
