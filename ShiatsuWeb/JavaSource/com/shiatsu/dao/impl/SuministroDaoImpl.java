package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.SuministroDao;
import com.shiatsu.domain.Suministro;
import com.utilidades.business.BusinessErrorHelper;

public class SuministroDaoImpl extends HibernateDaoSupport implements  SuministroDao{

	@Override
	public void agregar(Suministro suministro) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(suministro);
	}

	@Override
	public void modificar(Suministro suministro) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(suministro);
	}

	@Override
	public void eliminar( Suministro suministro) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(suministro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Suministro buscar(Suministro suministro) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Suministro suministro WHERE suministro.pvInCodigo = ?";
        Object[] values = {suministro.getPvInCodigo()};
        List<Suministro> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Suministro suministro) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT suministro.pvInCodigo FROM Suministro suministro WHERE suministro.pvInCodigo = ?";
        Object[] values = {suministro.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suministro> getSuministros() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Suministro  suministro ORDER BY suministro.pvStDescripcion";
        List<Suministro> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suministro> getSuministros(Suministro suministro) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Suministro  suministro WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Suministro> lista = new ArrayList<Suministro>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((suministro.getPvInCodigo() != null) && !(suministro.getPvInCodigo().equals(Suministro.DEFAULT))) {
            hql += "(suministro.pvInCodigo = ?) ";
            filtros.add(suministro.getPvInCodigo());
            and = true;
        }
        
        if((suministro.getPvInCodigo()!=null) && !(suministro.getPvInCodigo().equals(Suministro.DEFAULT))) {
            if(and){
                hql += "AND (UPPER(suministro.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(suministro.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+suministro.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((suministro.getPvStEstado() != null) && (!Suministro.ESTADO_DEFAULT.equals(suministro.getPvStEstado())) ) {
            if(and){
                hql += "AND (suministro.pvStEstado = ?) ";
            }else{
                hql += "(suministro.pvStEstado = ?) ";
            } 
            filtros.add(suministro.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY suministro.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
