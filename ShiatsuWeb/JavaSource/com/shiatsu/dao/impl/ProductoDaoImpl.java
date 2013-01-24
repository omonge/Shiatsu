package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.ProductoDao;
import com.shiatsu.domain.Producto;
import com.utilidades.business.BusinessErrorHelper;

public class ProductoDaoImpl extends HibernateDaoSupport implements  ProductoDao{

	@Override
	public void agregar(Producto producto) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(producto);
	}

	@Override
	public void modificar(Producto producto) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(producto);
	}

	@Override
	public void eliminar( Producto producto) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(producto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Producto buscar(Producto producto) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Producto producto WHERE producto.pvInCodigo = ?";
        Object[] values = {producto.getPvInCodigo()};
        List<Producto> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Producto producto) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT producto.pvInCodigo FROM Producto producto WHERE producto.pvInCodigo = ?";
        Object[] values = {producto.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getProductos() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Producto  producto ORDER BY producto.pvStDescripcion";
        List<Producto> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getProductos(Producto producto) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Producto  producto WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Producto> lista = new ArrayList<Producto>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((producto.getPvInCodigo()!=null) && !(producto.getPvInCodigo().equals(Producto.DEFAULT))) {            
            hql += "(producto.pvInCodigo = ?) ";
            filtros.add(producto.getPvInCodigo());
            and = true;
        }
        
        if((producto.getPvStDescripcion() != null)&& (!"".equals(producto.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(producto.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(producto.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+producto.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((producto.getPvStEstado() != null) && (!Producto.ESTADO_DEFAULT.equals(producto.getPvStEstado())) ) {
            if(and){
                hql += "AND (producto.pvStEstado = ?) ";
            }else{
                hql += "(producto.pvStEstado = ?) ";
            } 
            filtros.add(producto.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY producto.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
