package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.TipoClienteDao;
import com.shiatsu.domain.TipoCliente;
import com.utilidades.business.BusinessErrorHelper;

public class TipoClienteDaoImpl extends HibernateDaoSupport implements  TipoClienteDao{

	@Override
	public void agregar(TipoCliente tipoCliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(tipoCliente);
	}

	@Override
	public void modificar(TipoCliente tipoCliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(tipoCliente);
	}

	@Override
	public void eliminar( TipoCliente tipoCliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(tipoCliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  TipoCliente buscar(TipoCliente tipoCliente) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM TipoCliente tipoCliente WHERE tipoCliente.pvInCodigo = ?";
        Object[] values = {tipoCliente.getPvInCodigo()};
        List<TipoCliente> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(TipoCliente tipoCliente) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT tipoCliente.pvInCodigo FROM TipoCliente tipoCliente WHERE tipoCliente.pvInCodigo = ?";
        Object[] values = {tipoCliente.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCliente> getTipoClientes() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  TipoCliente  tipoCliente ORDER BY tipoCliente.pvStDescripcion";
        List<TipoCliente> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCliente> getTipoClientes(TipoCliente tipoCliente) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  TipoCliente  tipoCliente WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<TipoCliente> lista = new ArrayList<TipoCliente>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((tipoCliente.getPvInCodigo() != null) && !(tipoCliente.getPvInCodigo().equals(Integer.valueOf(0)))) {
            hql += "(tipoCliente.pvInCodigo = ?) ";
            filtros.add(tipoCliente.getPvInCodigo());
            and = true;
        }
        
        if((tipoCliente.getPvStDescripcion() != null)&& (!"".equals(tipoCliente.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(tipoCliente.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(tipoCliente.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+tipoCliente.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((tipoCliente.getPvStEstado() != null) && (!TipoCliente.ESTADO_DEFAULT.equals(tipoCliente.getPvStEstado())) ) {
            if(and){
                hql += "AND (tipoCliente.pvStEstado = ?) ";
            }else{
                hql += "(tipoCliente.pvStEstado = ?) ";
            } 
            filtros.add(tipoCliente.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY tipoCliente.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
