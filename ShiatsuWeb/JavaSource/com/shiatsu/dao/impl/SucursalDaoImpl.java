package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.SucursalDao; 
import com.shiatsu.domain.Sucursal;
import com.utilidades.business.BusinessErrorHelper;

public class SucursalDaoImpl extends HibernateDaoSupport implements  SucursalDao{

	@Override
	public void agregar(Sucursal sucursal) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(sucursal);
	}

	@Override
	public void modificar(Sucursal sucursal) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(sucursal);
	}

	@Override
	public void eliminar( Sucursal sucursal) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(sucursal);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Sucursal buscar(Sucursal sucursal) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Sucursal sucursal WHERE sucursal.pvInCodigo = ?";
        Object[] values = {sucursal.getPvInCodigo()};
        List<Sucursal> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Sucursal sucursal) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT sucursal.pvInCodigo FROM Sucursal sucursal WHERE sucursal.pvInCodigo = ?";
        Object[] values = {sucursal.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sucursal> getSucursales() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Sucursal  sucursal ORDER BY sucursal.pvStDescripcion";
        List<Sucursal> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sucursal> getSucursales(Sucursal sucursal) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Sucursal  sucursal WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Sucursal> lista = new ArrayList<Sucursal>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((sucursal.getPvInCodigo()!=null) && !(sucursal.getPvInCodigo().equals(Sucursal.DEFAULT))) {
            hql += "(sucursal.pvInCodigo = ?) ";
            filtros.add(sucursal.getPvInCodigo());
            and = true;
        }
        
        if((sucursal.getPvStDescripcion() != null)&& (!"".equals(sucursal.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(sucursal.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(sucursal.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+sucursal.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY sucursal.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
