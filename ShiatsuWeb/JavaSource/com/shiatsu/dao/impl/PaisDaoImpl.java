package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.PaisDao; 
import com.shiatsu.domain.Pais;
import com.utilidades.business.BusinessErrorHelper;

public class PaisDaoImpl extends HibernateDaoSupport implements PaisDao{

	@Override
	public void agregar(Pais pais) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(pais);
	}

	@Override
	public void modificar(Pais pais) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(pais);
	}

	@Override
	public void eliminar(Pais pais) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(pais);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pais buscar(Pais pais) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Pais  pais WHERE pais.pvInCodig = ?";
        Object[] values = {pais.getPvInCodigo()};
        List<Pais> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Pais pais) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT pais.pvInCodigo FROM Pais pais WHERE pais.pvInCodigo = ?";
        Object[] values = {pais.getPvInCodigo()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> getPais() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Pais pais ORDER BY pais.pvStDescripcion";
        List<Pais> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> getPais(Pais pais) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Pais pais WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Pais> lista = new ArrayList<Pais>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((pais.getPvInCodigo() != null) && (!Pais.PAIS_DEFAULT.equals(pais.getPvInCodigo())) ) {
            if(and){
                hql += "AND (pais.pvInCodigo = ?) ";
            }else{
                hql += "(pais.pvInCodigo = ?) ";
            } 
            filtros.add(pais.getPvInCodigo());
            and = true;
        }
        if((pais.getPvStEstado() != null) && (!Pais.ESTADO_DEFAULT.equals(pais.getPvStEstado())) ) {
            if(and){
                hql += "AND (pais.pvStEstado = ?) ";
            }else{
                hql += "(pais.pvStEstado = ?) ";
            } 
            filtros.add(pais.getPvStEstado());
            and = true;
        } 
        if((pais.getPvStDescripcion() != null) && (!"".equals(pais.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(pais.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(pais.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+pais.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY pais.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}

	 

}
