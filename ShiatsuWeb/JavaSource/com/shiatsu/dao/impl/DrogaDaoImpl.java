package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.DrogaDao;
import com.shiatsu.domain.Droga;
import com.utilidades.business.BusinessErrorHelper;

public class DrogaDaoImpl extends HibernateDaoSupport implements  DrogaDao{

	@Override
	public void agregar(Droga droga) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(droga);
	}

	@Override
	public void modificar(Droga droga) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(droga);
	}

	@Override
	public void eliminar( Droga droga) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(droga);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Droga buscar(Droga droga) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Droga droga WHERE droga.pvInCodigo = ?";
        Object[] values = {droga.getPvInCodigo()};
        List<Droga> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Droga droga) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT droga.pvInCodigo FROM Droga droga WHERE droga.pvInCodigo = ?";
        Object[] values = {droga.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Droga> getDrogas() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Droga  droga ORDER BY droga.pvStDescripcion";
        List<Droga> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Droga> getDrogas(Droga droga) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Droga  droga WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Droga> lista = new ArrayList<Droga>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((droga.getPvInCodigo() != null) && !(droga.getPvInCodigo().equals(Integer.valueOf(0)))) {
            hql += "(droga.pvInCodigo = ?) ";
            filtros.add(droga.getPvInCodigo());
            and = true;
        }
        
        if((droga.getPvStDescripcion() != null)&& (!"".equals(droga.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(droga.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(droga.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+droga.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((droga.getPvStEstado() != null) && (!Droga.ESTADO_DEFAULT.equals(droga.getPvStEstado())) ) {
            if(and){
                hql += "AND (droga.pvStEstado = ?) ";
            }else{
                hql += "(droga.pvStEstado = ?) ";
            } 
            filtros.add(droga.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY droga.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
