package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.UsuarioDao;
import com.shiatsu.domain.Usuario;
import com.utilidades.business.BusinessErrorHelper;

public class UsuarioDaoImpl extends HibernateDaoSupport implements  UsuarioDao{

	@Override
	public void agregar(Usuario usuario) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(usuario);
	}

	@Override
	public void modificar(Usuario usuario) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(usuario);
	}

	@Override
	public void eliminar( Usuario usuario) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Usuario buscar(Usuario usuario) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Usuario usuario WHERE usuario.pvInCodigo = ?";
        Object[] values = {usuario.getPvInCodigo()};
        List<Usuario> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Usuario usuario) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT usuario.pvInCodigo FROM Usuario usuario WHERE usuario.pvInCodigo = ?";
        Object[] values = {usuario.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM  Usuario  usuario ORDER BY usuario.pvStDescripcion";
        List<Usuario> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getUsuarios(Usuario usuario) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM  Usuario  usuario WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Usuario> lista = new ArrayList<Usuario>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((usuario.getPvInCodigo() != null) && !(usuario.getPvInCodigo().equals(Integer.valueOf(0)))) {
            hql += "(usuario.pvInCodigo = ?) ";
            filtros.add(usuario.getPvInCodigo());
            and = true;
        }
        
        if((usuario.getPvStDescripcion() != null)&& (!"".equals(usuario.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(usuario.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(usuario.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+usuario.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((usuario.getPvStEstado() != null) && (!Usuario.ESTADO_DEFAULT.equals(usuario.getPvStEstado())) ) {
            if(and){
                hql += "AND (usuario.pvStEstado = ?) ";
            }else{
                hql += "(usuario.pvStEstado = ?) ";
            } 
            filtros.add(usuario.getPvStEstado());
            and = true;
        } 
        if(and){
            hql += " ORDER BY usuario.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values);
        }
        return lista;
	}

	 

}
