package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.TipoAlopeciaDao; 
import com.shiatsu.domain.TipoAlopecia;
import com.utilidades.business.BusinessErrorHelper;

public class TipoAlopeciaDaoImpl extends HibernateDaoSupport implements  TipoAlopeciaDao{

	@Override
	public void agregar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(tipoAlopecia);
	}

	@Override
	public void modificar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(tipoAlopecia);
	}

	@Override
	public void eliminar( TipoAlopecia tipoAlopecia) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(tipoAlopecia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  TipoAlopecia buscar(TipoAlopecia tipoAlopecia) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM TipoAlopecia tipoAlopecia WHERE tipoAlopecia.pvInCodigo = ?";
        Object[] values = {tipoAlopecia.getPvInCodigo()};
        List<TipoAlopecia> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(TipoAlopecia tipoAlopecia) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT tipoAlopecia.pvInCodigo FROM TipoAlopecia tipoAlopecia WHERE tipoAlopecia.pvInCodigo = ?";
        Object[] values = {tipoAlopecia.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoAlopecia> getTipoAlopecia() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  TipoAlopecia  tipoAlopecia ORDER BY tipoAlopecia.pvStDescripcion";
        List<TipoAlopecia> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoAlopecia> getTipoAlopecia(TipoAlopecia tipoAlopecia) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  TipoAlopecia  tipoAlopecia WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<TipoAlopecia> lista = new ArrayList<TipoAlopecia>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((tipoAlopecia.getPvInCodigo() != null) && (!TipoAlopecia.TIPO_APOPECIA_DEFAULT.equals(tipoAlopecia.getPvInCodigo())) ) {
            if(and){
                hql += "AND (tipoAlopecia.pvInCodigo = ?) ";
            }else{
                hql += "(tipoAlopecia.pvInCodigo = ?) ";
            } 
            filtros.add(tipoAlopecia.getPvInCodigo());
            and = true;
        }
        if((tipoAlopecia.getPvStEstado() != null) && (!TipoAlopecia.ESTADO_DEFAULT.equals(tipoAlopecia.getPvStEstado())) ) {
            if(and){
                hql += "AND (tipoAlopecia.pvStEstado = ?) ";
            }else{
                hql += "(tipoAlopecia.pvStEstado = ?) ";
            } 
            filtros.add(tipoAlopecia.getPvStEstado());
            and = true;
        } 
        if((tipoAlopecia.getPvStDescripcion() != null)&& (!"".equals(tipoAlopecia.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(tipoAlopecia.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(tipoAlopecia.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+tipoAlopecia.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY tipoAlopecia.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
