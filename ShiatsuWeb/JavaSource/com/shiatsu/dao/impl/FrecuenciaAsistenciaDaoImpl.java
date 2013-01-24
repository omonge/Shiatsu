package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.FrecuenciaAsistenciaDao;
import com.shiatsu.domain.FrecuenciaAsistencia;
import com.utilidades.business.BusinessErrorHelper;

public class FrecuenciaAsistenciaDaoImpl extends HibernateDaoSupport implements  FrecuenciaAsistenciaDao{

	@Override
	public void agregar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(frecuenciaAsistencia);
	}

	@Override
	public void modificar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(frecuenciaAsistencia);
	}

	@Override
	public void eliminar( FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(frecuenciaAsistencia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  FrecuenciaAsistencia buscar(FrecuenciaAsistencia frecuenciaAsistencia) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM FrecuenciaAsistencia frecuenciaAsistencia WHERE frecuenciaAsistencia.pvInCodigo = ?";
        Object[] values = {frecuenciaAsistencia.getPvInCodigo()};
        List<FrecuenciaAsistencia> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(FrecuenciaAsistencia frecuenciaAsistencia) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT frecuenciaAsistencia.pvInCodigo FROM FrecuenciaAsistencia frecuenciaAsistencia WHERE frecuenciaAsistencia.pvInCodigo = ?";
        Object[] values = {frecuenciaAsistencia.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrecuenciaAsistencia> getFrecuenciaAsistencias() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  FrecuenciaAsistencia  frecuenciaAsistencia ORDER BY frecuenciaAsistencia.pvStDescripcion";
        List<FrecuenciaAsistencia> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrecuenciaAsistencia> getFrecuenciaAsistencias(FrecuenciaAsistencia frecuenciaAsistencia) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  FrecuenciaAsistencia  frecuenciaAsistencia WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<FrecuenciaAsistencia> lista = new ArrayList<FrecuenciaAsistencia>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((frecuenciaAsistencia.getPvInCodigo()!=null) && !(frecuenciaAsistencia.getPvInCodigo().equals(Integer.valueOf(0)))) {
            hql += "(frecuenciaAsistencia.pvInCodigo = ?) ";
            filtros.add(frecuenciaAsistencia.getPvInCodigo());
            and = true;
        }
        
        if((frecuenciaAsistencia.getPvStDescripcion() != null)&& (!"".equals(frecuenciaAsistencia.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(frecuenciaAsistencia.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(frecuenciaAsistencia.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+frecuenciaAsistencia.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((frecuenciaAsistencia.getPvStEstado() != null) && (!FrecuenciaAsistencia.ESTADO_DEFAULT.equals(frecuenciaAsistencia.getPvStEstado())) ) {
            if(and){
                hql += "AND (frecuenciaAsistencia.pvStEstado = ?) ";
            }else{
                hql += "(frecuenciaAsistencia.pvStEstado = ?) ";
            } 
            filtros.add(frecuenciaAsistencia.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY frecuenciaAsistencia.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
