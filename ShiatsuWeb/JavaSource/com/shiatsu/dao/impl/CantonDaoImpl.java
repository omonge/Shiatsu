/**
 * CantonDaoImpl.java
 */
package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.CantonDao;
import com.shiatsu.domain.Canton;
import com.shiatsu.domain.Profesion;
import com.shiatsu.domain.Provincia;
import com.utilidades.business.BusinessErrorHelper;


public class CantonDaoImpl extends HibernateDaoSupport implements CantonDao {


	@SuppressWarnings("unchecked")
	@Override
	public Canton buscar(Canton canton) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Canton canton WHERE UPPER(canton.pvStCodigo) = ?";
        Object[] values = {canton.getPvInCodigo()};
        List<Canton> cantons = hibernate.find(hql,values);
        if(cantons.isEmpty()){
        	return null;
        }else{
        	return cantons.get(0);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Canton> getCanton() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Canton canton ORDER BY canton.pvStNombre";
        List<Canton> cantons = hibernate.find(hql);
        return cantons; 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Canton> getCanton(Canton canton) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Canton canton WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Canton> lista = new ArrayList<Canton>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((canton.getPvInCodigo() != null) && (!Profesion.PROFESION_DEFAULT.equals(canton.getPvInCodigo())) ) {
            if(and){
                hql += "AND (canton.pvInCodigo = ?) ";
            }else{
                hql += "(canton.pvInCodigo = ?) ";
            } 
            filtros.add(canton.getPvInCodigo());
            and = true;
        }
        if((canton.getPvStEstado() != null) && (!Canton.ESTADO_DEFAULT.equals(canton.getPvStEstado())) ) {
            if(and){
                hql += "AND (canton.pvStEstado = ?) ";
            }else{
                hql += "(canton.pvStEstado = ?) ";
            } 
            filtros.add(canton.getPvStEstado());
            and = true;
        } 
        if((canton.getPvStDescripcion() != null) && (!"".equals(canton.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(canton.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(canton.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+canton.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((canton.getPvPrProvincia() != null) && (canton.getPvPrProvincia().getPvInCodigo() != null) &&  (!Provincia.PROVINCIA_DEFAULT.equals(canton.getPvPrProvincia().getPvInCodigo()))  ){
            if(and){
                hql += "AND (canton.pvPrProvincia.pvInCodigo = ?) ";
            }else{
                hql += "(canton.pvPrProvincia.pvInCodigo = ?) ";
            }
            filtros.add(canton.getPvPrProvincia().getPvInCodigo());
            and = true;
        }
        if(and){
            hql += " ORDER BY canton.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}


	@Override
	public void agregar(Canton canton) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(canton);
	}


	@Override
	public void modificar(Canton canton) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(canton);
	}


	@Override
	public void eliminar(Canton canton) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(canton);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Canton canton) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT canton.pvStCodigo FROM Canton canton WHERE canton.pvStCodigo = ?";
        Object[] values = {canton.getPvInCodigo()};
        List<Object> cantons = hibernate.find(hql,values);
        if(cantons.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

}
