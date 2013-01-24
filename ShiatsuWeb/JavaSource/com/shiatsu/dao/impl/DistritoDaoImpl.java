/**
 * DistritoDaoImpl.java
 */
package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.DistritoDao;
import com.shiatsu.domain.Canton;
import com.shiatsu.domain.Distrito;
import com.shiatsu.domain.Profesion;
import com.shiatsu.domain.Provincia;
import com.utilidades.business.BusinessErrorHelper;


public class DistritoDaoImpl extends HibernateDaoSupport implements DistritoDao {


	@SuppressWarnings("unchecked")
	@Override
	public Distrito buscar(Distrito distrito) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Distrito distrito WHERE UPPER(distrito.pvStCodigo) = ?";
        Object[] values = {distrito.getPvInCodigo()};
        List<Distrito> Distritos = hibernate.find(hql,values);
        if(Distritos.isEmpty()){
        	return null;
        }else{
        	return Distritos.get(0);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> getDistrito() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Distrito distrito ORDER BY distrito.pvStNombre";
        List<Distrito> Distritos = hibernate.find(hql);
        return Distritos; 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> getDistrito(Distrito distrito) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Distrito distrito WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Distrito> lista = new ArrayList<Distrito>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((distrito.getPvInCodigo() != null) && (!Profesion.PROFESION_DEFAULT.equals(distrito.getPvInCodigo())) ) {
            if(and){
                hql += "AND (distrito.pvInCodigo = ?) ";
            }else{
                hql += "(distrito.pvInCodigo = ?) ";
            } 
            filtros.add(distrito.getPvInCodigo());
            and = true;
        }
        if((distrito.getPvStEstado() != null) && (!Distrito.ESTADO_DEFAULT.equals(distrito.getPvStEstado())) ) {
            if(and){
                hql += "AND (distrito.pvStEstado = ?) ";
            }else{
                hql += "(distrito.pvStEstado = ?) ";
            } 
            filtros.add(distrito.getPvStEstado());
            and = true;
        } 
        if((distrito.getPvStDescripcion() != null) && (!"".equals(distrito.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(distrito.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(distrito.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+distrito.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if((distrito.getPvPrProvincia() != null) && (distrito.getPvPrProvincia().getPvInCodigo() != null) &&  (!Provincia.PROVINCIA_DEFAULT.equals(distrito.getPvPrProvincia().getPvInCodigo()))  ){
            if(and){
                hql += "AND (distrito.pvPrProvincia.pvInCodigo = ?) ";
            }else{
                hql += "(distrito.pvPrProvincia.pvInCodigo = ?) ";
            }
            filtros.add(distrito.getPvPrProvincia().getPvInCodigo());
            and = true;
        }
        if((distrito.getPvCaCanton() != null) && (distrito.getPvCaCanton().getPvInCodigo() != null) &&  (!Canton.DEFAULT.equals(distrito.getPvCaCanton().getPvInCodigo()))  ){
            if(and){
                hql += "AND (distrito.pvCaCanton.pvInCodigo = ?) ";
            }else{
                hql += "(distrito.pvCaCanton.pvInCodigo = ?) ";
            }
            filtros.add(distrito.getPvCaCanton().getPvInCodigo());
            and = true;
        }
        if(and){
            hql += " ORDER BY distrito.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}


	@Override
	public void agregar(Distrito distrito) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(distrito);
	}


	@Override
	public void modificar(Distrito distrito) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(distrito);
	}


	@Override
	public void eliminar(Distrito distrito) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(distrito);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Distrito distrito) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT distrito.pvStCodigo FROM Distrito distrito WHERE distrito.pvStCodigo = ?";
        Object[] values = {distrito.getPvInCodigo()};
        List<Object> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

}
