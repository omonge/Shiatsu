package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.ProductoBo;
import com.shiatsu.dao.ProductoDao;
import com.shiatsu.domain.Producto;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class ProductoBoImpl extends BusinessObjectHelper implements ProductoBo {

	private ProductoDao productoDao;
	
	/**
	 * @param ProductoDao the ProductoDao to set
	 */
	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}

	@Override
	public void agregar(Producto producto) throws BusinessErrorHelper {
		try{
			 if(!this.existe(producto)){
			 	producto.setPvObUsuario(Utilidades.getUsuario());
			 	producto.setPvDaModifica(new Date());
				 this.productoDao.agregar(producto);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("productoBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Producto producto) throws BusinessErrorHelper {
		try{
			 if(this.productoDao.existe(producto)){
				 producto.setPvDaModifica(new Date());
				 this.productoDao.modificar(producto);
	         }else{ 
	        	this.addError("productoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Producto producto) throws BusinessErrorHelper {
		try{
			 if(this.productoDao.existe(producto)){
				 this.productoDao.eliminar(producto);
	         }else{ 
	        	this.addError("productoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Producto buscar(Producto producto) { 
		return this.productoDao.buscar(producto);
	}

	@Override
	public boolean existe(Producto producto) {
		return this.productoDao.existe(producto);
	}

	@Override
	public List<Producto> getProductos() {
		return this.productoDao.getProductos();
	}

	@Override
	public List<Producto> getProductos(Producto producto) {
		return this.productoDao.getProductos(producto);
	}





}
