/**
 * DiagnosticoDaoImpl.java
 */
package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.DiagnosticoDao;
import com.shiatsu.domain.Diagnostico;
import com.utilidades.business.BusinessErrorHelper;


public class DiagnosticoDaoImpl extends HibernateDaoSupport implements DiagnosticoDao {


	@SuppressWarnings("unchecked")
	@Override
	public Diagnostico buscar(Diagnostico diagnostico) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Diagnostico diagnostico WHERE UPPER(diagnostico.pvStCodigo) = ?";
        Object[] values = {diagnostico.getPvStCodigo().toUpperCase()};
        List<Diagnostico> diagnosticos = hibernate.find(hql,values);
        if(diagnosticos.isEmpty()){
        	return null;
        }else{
        	return diagnosticos.get(0);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diagnostico> getDiagnosticos() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Diagnostico diagnostico ORDER BY diagnostico.pvStNombre";
        List<Diagnostico> diagnosticos = hibernate.find(hql);
        return diagnosticos; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diagnostico> getDiagnosticos(Diagnostico diagnostico) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Diagnostico diagnostico WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Diagnostico> lista = new ArrayList<Diagnostico>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((diagnostico.getPvStCodigo() != null) && (!"".equals(diagnostico.getPvStCodigo())) ) {
            if(and){
                hql += "AND (diagnostico.pvStCodigo = ?) ";
            }else{
                hql += "(diagnostico.pvStCodigon = ?) ";
            } 
            filtros.add(diagnostico.getPvStCodigo());
            and = true;
        }
        
        if((diagnostico.getPvStEstado() != null)  && (!"".equals(diagnostico.getPvStEstado())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStEstado)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStEstado)) = ?) ";
            }
            filtros.add(diagnostico.getPvStEstado());
            and = true;
        }
          
        if((diagnostico.getPvStNombre() != null) && (!"".equals(diagnostico.getPvStNombre())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStNombre)) like ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStNombre)) like ?) ";
            }
            filtros.add("%"+diagnostico.getPvStNombre()+"%");
            and = true;
        }
        
        if((diagnostico.getPvStDermatitisOleosa() != null)  && (!"".equals(diagnostico.getPvStDermatitisOleosa())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStDermatitisOleosa)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStDermatitisOleosa)) = ?) ";
            }
            filtros.add(diagnostico.getPvStEstado());
            and = true;
        }
        
        if((diagnostico.getPvStDermatitisSeborreica() != null)  && (!"".equals(diagnostico.getPvStDermatitisSeborreica())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStDermatitisSeborreica)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStDermatitisSeborreica)) = ?) ";
            }
            filtros.add(diagnostico.getPvStDermatitisSeborreica());
            and = true;
        }
        
        if((diagnostico.getPvStDermatitisSeca() != null)  && (!"".equals(diagnostico.getPvStDermatitisSeca())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStDermatitisSeca)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStDermatitisSeca)) = ?) ";
            }
            filtros.add(diagnostico.getPvStDermatitisSeca());
            and = true;
        }
        
        
        if((diagnostico.getPvStDeshidratacion() != null)  && (!"".equals(diagnostico.getPvStDeshidratacion())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStDeshidratacion)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStDeshidratacion)) = ?) ";
            }
            filtros.add(diagnostico.getPvStDeshidratacion());
            and = true;
        }
        
        if((diagnostico.getPvStPsoriasis() != null)  && (!"".equals(diagnostico.getPvStPsoriasis())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStPsoriasis)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStPsoriasis)) = ?) ";
            }
            filtros.add(diagnostico.getPvStPsoriasis());
            and = true;
        }
        
        if((diagnostico.getPvStTelanocitos() != null)  && (!"".equals(diagnostico.getPvStTelanocitos())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStTelanocitos)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStTelanocitos)) = ?) ";
            }
            filtros.add(diagnostico.getPvStTelanocitos());
            and = true;
        }
        
        if((diagnostico.getPvInTipoAlopecia() != null)  && (!Diagnostico.NUMERO_DEFAULT.equals(diagnostico.getPvInTipoAlopecia())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvInTipoAlopecia)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvInTipoAlopecia)) = ?) ";
            }
            filtros.add(diagnostico.getPvInTipoAlopecia());
            and = true;
        }
        
        if((diagnostico.getPvStCaspa() != null)  && (!"".equals(diagnostico.getPvStCaspa())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStCaspa)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStCaspa)) = ?) ";
            }
            filtros.add(diagnostico.getPvStCaspa());
            and = true;
        }
        
        if((diagnostico.getPvStHongo() != null)  && (!"".equals(diagnostico.getPvStHongo())) ){
            if(and){
                hql += "AND (UPPER(TRIM(diagnostico.pvStHongo)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(diagnostico.pvStHongo)) = ?) ";
            }
            filtros.add(diagnostico.getPvStHongo());
            and = true;
        }
         
        if(and){
            hql += " ORDER BY diagnostico.pvStNombre ASC";
            Object[] values = new Object[filtros.size()];
            for(int i = 0; i < filtros.size(); i++){
                values[i] = filtros.get(i);
            }
            ht.setMaxResults(200);
            lista = ht.find(hql,values);
            ht.setMaxResults(0);
        }
        return lista;
	}


	@Override
	public void agregar(Diagnostico diagnostico) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(diagnostico);
	}


	@Override
	public void modificar(Diagnostico diagnostico) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(diagnostico);
	}


	@Override
	public void eliminar(Diagnostico diagnostico) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(diagnostico);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Diagnostico diagnostico) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT diagnostico.pvStCodigo FROM Diagnostico diagnostico WHERE UPPER(diagnostico.pvStCodigo) = ?";
        Object[] values = {diagnostico.getPvStCodigo().toUpperCase()};
        List<Object> diagnosticos = hibernate.find(hql,values);
        if(diagnosticos.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

}
