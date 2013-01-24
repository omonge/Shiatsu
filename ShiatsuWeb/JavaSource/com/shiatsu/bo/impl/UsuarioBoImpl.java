package com.shiatsu.bo.impl;

import java.util.List;

import com.shiatsu.bo.UsuarioBo;
import com.shiatsu.dao.UsuarioDao;
import com.shiatsu.domain.Usuario;
import com.shiatsu.web.bundles.Bundle;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class UsuarioBoImpl extends BusinessObjectHelper implements UsuarioBo {

	private UsuarioDao usuarioDao;
	
	/**
	 * @param UsuarioDao the UsuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void agregar(Usuario usuario) throws BusinessErrorHelper {
		try{
			 if(!this.existe(usuario)){
				 this.usuarioDao.agregar(usuario);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("usuarioBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Usuario usuario) throws BusinessErrorHelper {
		try{
			 if(this.usuarioDao.existe(usuario)){
				 this.usuarioDao.modificar(usuario);
	         }else{ 
	        	this.addError("usuarioBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Usuario usuario) throws BusinessErrorHelper {
		try{
			 if(this.usuarioDao.existe(usuario)){
				 this.usuarioDao.eliminar(usuario);
	         }else{ 
	        	this.addError("usuarioBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Usuario buscar(Usuario usuario) { 
		return this.usuarioDao.buscar(usuario);
	}

	@Override
	public boolean existe(Usuario usuario) {
		return this.usuarioDao.existe(usuario);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return this.usuarioDao.getUsuarios();
	}

	@Override
	public List<Usuario> getUsuarios(Usuario usuario) {
		return this.usuarioDao.getUsuarios(usuario);
	}





}
