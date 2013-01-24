package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.BodegaDao; 
import com.shiatsu.domain.Bodega;
import com.utilidades.business.BusinessErrorHelper;

public class BodegaDaoImpl extends HibernateDaoSupport implements  BodegaDao{

	@Override
	public void agregar(Bodega bodega) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(bodega);
	}

	@Override
	public void modificar(Bodega bodega) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(bodega);
	}

	@Override
	public void eliminar( Bodega bodega) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(bodega);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Bodega buscar(Bodega bodega) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Bodega bodega WHERE bodega.pvInCodigo = ?";
        Object[] values = {bodega.getPvInCodigo()};
        List<Bodega> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Bodega bodega) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT bodega.pvInCodigo FROM Bodega bodega WHERE bodega.pvInCodigo = ?";
        Object[] values = {bodega.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bodega> getBodegas() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Bodega  bodega ORDER BY bodega.pvStDescripcion";
        List<Bodega> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bodega> getBodegas(Bodega bodega) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Bodega  bodega WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Bodega> lista = new ArrayList<Bodega>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((bodega.getPvInCodigo()!=null) && !(bodega.getPvInCodigo().equals(Integer.valueOf(0)))) {
            hql += "(bodega.pvInCodigo = ?) ";
            filtros.add(bodega.getPvInCodigo());
            and = true;
        }
        
        if((bodega.getPvStDescripcion() != null)&& (!"".equals(bodega.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(bodega.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(bodega.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+bodega.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((bodega.getPvStEstado() != null) && (!Bodega.ESTADO_DEFAULT.equals(bodega.getPvStEstado())) ) {
            if(and){
                hql += "AND (bodega.pvStEstado = ?) ";
            }else{
                hql += "(bodega.pvStEstado = ?) ";
            } 
            filtros.add(bodega.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY bodega.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
