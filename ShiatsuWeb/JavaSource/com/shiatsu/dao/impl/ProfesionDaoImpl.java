package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.ProfesionDao; 
import com.shiatsu.domain.Profesion;
import com.utilidades.business.BusinessErrorHelper;

public class ProfesionDaoImpl extends HibernateDaoSupport implements ProfesionDao{

	@Override
	public void agregar(Profesion profesion) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(profesion);
	}

	@Override
	public void modificar(Profesion profesion) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(profesion);
	}

	@Override
	public void eliminar(Profesion profesion) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(profesion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Profesion buscar(Profesion profesion) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Profesion  profesion WHERE profesion.pvInCodigo = ?";
        Object[] values = {profesion.getPvInCodigo()};
        List<Profesion> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Profesion profesion) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT profesion.pvInCodigo FROM Profesion profesion WHERE profesion.pvInCodigo = ?";
        Object[] values = {profesion.getPvInCodigo()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesion> getProfesion() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Profesion profesion ORDER BY profesion.pvStDescripcion";
        List<Profesion> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesion> getProfesion(Profesion profesion) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Profesion profesion WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Profesion> lista = new ArrayList<Profesion>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((profesion.getPvInCodigo() != null) && (!Profesion.PROFESION_DEFAULT.equals(profesion.getPvInCodigo())) ) {
            if(and){
                hql += "AND (profesion.pvInCodigo = ?) ";
            }else{
                hql += "(profesion.pvInCodigo = ?) ";
            } 
            filtros.add(profesion.getPvInCodigo());
            and = true;
        }
        if((profesion.getPvStEstado() != null) && (!Profesion.ESTADO_DEFAULT.equals(profesion.getPvStEstado())) ) {
            if(and){
                hql += "AND (profesion.pvStEstado = ?) ";
            }else{
                hql += "(profesion.pvStEstado = ?) ";
            } 
            filtros.add(profesion.getPvStEstado());
            and = true;
        } 
        if((profesion.getPvStDescripcion() != null) && (!"".equals(profesion.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(profesion.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(profesion.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+profesion.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY profesion.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}

	 

}
