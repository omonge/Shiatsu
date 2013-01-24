package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.ProvinciaDao; 
import com.shiatsu.domain.Provincia;
import com.utilidades.business.BusinessErrorHelper;

public class ProvinciaDaoImpl extends HibernateDaoSupport implements ProvinciaDao{

	@Override
	public void agregar(Provincia provincia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(provincia);
	}

	@Override
	public void modificar(Provincia provincia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(provincia);
	}

	@Override
	public void eliminar(Provincia provincia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(provincia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Provincia buscar(Provincia provincia) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Provincia  provincia WHERE provincia.pvInCodigo = ?";
        Object[] values = {provincia.getPvInCodigo()};
        List<Provincia> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Provincia provincia) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT provincia.pvInCodigo FROM Provincia provincia WHERE provincia.pvInCodigo = ?";
        Object[] values = {provincia.getPvInCodigo()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> getProvincia() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Provincia provincia ORDER BY provincia.pvStDescripcion";
        List<Provincia> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> getProvincia(Provincia provincia) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Provincia provincia WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Provincia> lista = new ArrayList<Provincia>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((provincia.getPvInCodigo() != null) && (!Provincia.PROVINCIA_DEFAULT.equals(provincia.getPvInCodigo())) ) {
            if(and){
                hql += "AND (provincia.pvInCodigo = ?) ";
            }else{
                hql += "(provincia.pvInCodigo = ?) ";
            } 
            filtros.add(provincia.getPvInCodigo());
            and = true;
        }
        if((provincia.getPvStEstado() != null) && (!Provincia.ESTADO_DEFAULT.equals(provincia.getPvStEstado())) ) {
            if(and){
                hql += "AND (provincia.pvStEstado = ?) ";
            }else{
                hql += "(provincia.pvStEstado = ?) ";
            } 
            filtros.add(provincia.getPvStEstado());
            and = true;
        } 
        if((provincia.getPvStDescripcion() != null) && (!"".equals(provincia.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(provincia.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(provincia.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+provincia.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY provincia.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}

	 

}
