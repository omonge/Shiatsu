package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.MedicamentoDao; 
import com.shiatsu.domain.Medicamento;
import com.utilidades.business.BusinessErrorHelper;

public class MedicamentoDaoImpl extends HibernateDaoSupport implements MedicamentoDao{

	@Override
	public void agregar(Medicamento medicamento) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.save(medicamento);
	}

	@Override
	public void modificar(Medicamento medicamento) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(medicamento);
	}

	@Override
	public void eliminar(Medicamento medicamento) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(medicamento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Medicamento buscar(Medicamento medicamento) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Medicamento medicamento WHERE medicamento.pvInCodigo = ?";
        Object[] values = {medicamento.getPvInCodigo()};
        List<Medicamento> lista = hibernate.find(hql,values);
        if(lista.isEmpty()){
        	return null;
        }else{
        	return lista.get(0);
        } 
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Medicamento medicamento) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT medicamento.pvInCodigo FROM Medicamento medicamento WHERE medicamento.pvInCodigo = ?";
        Object[] values = {medicamento.getPvInCodigo()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicamento> getMedicamento() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Medicamento medicamento ORDER BY medicamento.pvStDescripcion";
        List<Medicamento> lista = hibernate.find(hql);
        return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicamento> getMedicamento(Medicamento medicamento) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Medicamento medicamento WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Medicamento> lista = new ArrayList<Medicamento>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((medicamento.getPvInCodigo() != null) && (!Medicamento.MEDICAMENTO_DEFAULT.equals(medicamento.getPvInCodigo())) ) {
            if(and){
                hql += "AND (medicamento.pvInCodigo = ?) ";
            }else{
                hql += "(medicamento.pvInCodigo = ?) ";
            } 
            filtros.add(medicamento.getPvInCodigo());
            and = true;
        }
        if((medicamento.getPvStEstado() != null) && (!Medicamento.ESTADO_DEFAULT.equals(medicamento.getPvStEstado())) ) {
            if(and){
                hql += "AND (medicamento.pvStEstado = ?) ";
            }else{
                hql += "(medicamento.pvStEstado = ?) ";
            } 
            filtros.add(medicamento.getPvStEstado());
            and = true;
        } 
        if((medicamento.getPvStDescripcion() != null) && (!"".equals(medicamento.getPvStDescripcion())) ){
            if(and){
                hql += "AND (UPPER(medicamento.pvStDescripcion) like ?) ";
            }else{
                hql += "(UPPER(medicamento.pvStDescripcion) like ?) ";
            }
            filtros.add("%"+medicamento.getPvStDescripcion().toUpperCase()+"%");
            and = true;
        }
        if(and){
            hql += " ORDER BY medicamento.pvStDescripcion ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            } 
            lista = ht.find(hql,values); 
        }
        return lista;
	}

	 

}
