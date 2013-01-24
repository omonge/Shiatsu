package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.TarjetaDao; 
import com.shiatsu.domain.Tarjeta;
import com.utilidades.business.BusinessErrorHelper;

public class TarjetaDaoImpl extends HibernateDaoSupport implements  TarjetaDao{

	@Override
	public void agregar(Tarjeta tarjeta) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(tarjeta);
	}

	@Override
	public void modificar(Tarjeta tarjeta) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(tarjeta);
	}

	@Override
	public void eliminar( Tarjeta tarjeta) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(tarjeta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Tarjeta buscar(Tarjeta tarjeta) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Tarjeta tarjeta WHERE tarjeta.pvInCodigo = ?";
        Object[] values = {tarjeta.getPvInCodigo()};
        List<Tarjeta> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Tarjeta tarjeta) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT tarjeta.pvInCodigo FROM Tarjeta tarjeta WHERE tarjeta.pvInCodigo = ?";
        Object[] values = {tarjeta.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarjeta> getTarjetas() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Tarjeta  tarjeta ORDER BY tarjeta.pvStDescripcion";
        List<Tarjeta> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarjeta> getTarjetas(Tarjeta tarjeta) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Tarjeta  tarjeta WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Tarjeta> lista = new ArrayList<Tarjeta>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((tarjeta.getPvInCodigo()!=null) && !(tarjeta.getPvInCodigo().equals(Tarjeta.DEFAULT))){
            hql += "(tarjeta.pvInCodigo = ?) ";
            filtros.add(tarjeta.getPvInCodigo());
            and = true;
        }
        
        if((tarjeta.getPvStDescripcion() != null)&& (!"".equals(tarjeta.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(tarjeta.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(tarjeta.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+tarjeta.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY tarjeta.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
