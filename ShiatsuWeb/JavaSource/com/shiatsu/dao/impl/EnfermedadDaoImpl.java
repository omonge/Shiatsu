package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.EnfermedadDao; 
import com.shiatsu.domain.Enfermedad;
import com.utilidades.business.BusinessErrorHelper;

public class EnfermedadDaoImpl extends HibernateDaoSupport implements EnfermedadDao{

	@Override
	public void agregar(Enfermedad enfermedad) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(enfermedad);
	}

	@Override
	public void modificar(Enfermedad enfermedad) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(enfermedad);
	}

	@Override
	public void eliminar(Enfermedad enfermedad) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(enfermedad);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enfermedad buscar(Enfermedad enfermedad) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Enfermedad enfermedad WHERE enfermedad.pvInCodigo = ?";
        Object[] values = {enfermedad.getPvInCodigo()};
        List<Enfermedad> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Enfermedad enfermedad) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT enfermedad.pvInCodigo FROM Enfermedad enfermedad WHERE enfermedad.pvInCodigo = ?";
        Object[] values = {enfermedad.getPvInCodigo()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enfermedad> getEnfermedad() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Enfermedad enfermedad ORDER BY enfermedad.pvStDescripcion";
        List<Enfermedad> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enfermedad> getEnfermedad(Enfermedad enfermedad) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Enfermedad enfermedad WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Enfermedad> lista = new ArrayList<Enfermedad>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((enfermedad.getPvInCodigo() != null) && (!Enfermedad.ENFERMEDAD_DEFAULT.equals(enfermedad.getPvInCodigo())) ) {
            if(and){
                hql += "AND (enfermedad.pvInCodigo = ?) ";
            }else{
                hql += "(enfermedad.pvInCodigo = ?) ";
            } 
            filtros.add(enfermedad.getPvInCodigo());
            and = true;
        }
        if((enfermedad.getPvStEstado() != null) && (!Enfermedad.ESTADO_DEFAULT.equals(enfermedad.getPvStEstado())) ) {
            if(and){
                hql += "AND (enfermedad.pvStEstado = ?) ";
            }else{
                hql += "(enfermedad.pvStEstado = ?) ";
            } 
            filtros.add(enfermedad.getPvStEstado());
            and = true;
        } 
        if((enfermedad.getPvStDescripcion() != null) && (!"".equals(enfermedad.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(enfermedad.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(enfermedad.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+enfermedad.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY enfermedad.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}

	 

}
