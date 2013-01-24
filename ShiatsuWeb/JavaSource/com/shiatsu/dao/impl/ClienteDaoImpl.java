/**
 * ClienteDaoImpl.java
 */
package com.shiatsu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shiatsu.dao.ClienteDao;
import com.shiatsu.domain.Cliente;
import com.utilidades.business.BusinessErrorHelper;


public class ClienteDaoImpl extends HibernateDaoSupport implements ClienteDao {


	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscar(Cliente cliente) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente WHERE cliente.pvStCodigo = ?";
        Object[] values = {cliente.getPvStCodigo()};
        List<Cliente> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return null;
        }else{
        	return clientes.get(0);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getClientes() {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente ORDER BY cliente.pvDiDiagnostico.pvStNombre";
        List<Cliente> clientes = hibernate.find(hql);
        return clientes; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getClientes(Cliente cliente) {
		HibernateTemplate ht = this.getHibernateTemplate();
        String hql = "FROM Cliente cliente WHERE ";
        
        List<Object> filtros   = new ArrayList<Object>();
        List<Cliente> lista = new ArrayList<Cliente>();
        boolean and = false;//verifica que ya se haya agregado algo al where para concatener o no concatenar el operador AND
        
        if((cliente.getPvStCodigo() != null) && !(cliente.getPvStCodigo().equals(Cliente.CLIENTE_DEFAULT)) ) {
            if(and){
                hql += "AND (cliente.pvStCodigo = ?) ";
            }else{
                hql += "(cliente.pvStCodigo = ?) ";
            } 
            filtros.add(cliente.getPvStCodigo());
            and = true;
        }
        if((cliente.getPvDaNacimiento() != null) ){
            if(and){
                hql += "AND (cliente.pvDaNacimiento = ?) ";
            }else{
                hql += "(cliente.pvDaNacimiento = ?) ";
            }
            filtros.add(cliente.getPvDaNacimiento());
            and = true;
        }
        if((cliente.getPvStEstado() != null) && (!Cliente.ESTADO_DEFAULT.equals(cliente.getPvStEstado()))){
            if(and){
                hql += "AND (cliente.pvInEstado = ?) ";
            }else{
                hql += "(cliente.pvInEstado = ?) ";
            }
            filtros.add(cliente.getPvStEstado());
            and = true;
        }
        
        if( (cliente.getPvDiDiagnostico() != null) && (cliente.getPvDiDiagnostico().getPvStNombre() != null) && (!Cliente.ESTADO_DEFAULT.equals(cliente.getPvDiDiagnostico().getPvStNombre()))){
            if(and){
                hql += "AND (cliente.pvStNombre = ?) ";
            }else{
                hql += "(cliente.pvStNombre = ?) ";
            }
            filtros.add(cliente.getPvDiDiagnostico().getPvStNombre());
            and = true;
        }
        
        if((cliente.getPvInProfesion() != null) && (cliente.getPvInProfesion().intValue() > Cliente.PROFESION_DEFAULT.intValue()) ){
            if(and){
                hql += "AND (cliente.pvInProfesion = ?) ";
            }else{
                hql += "(cliente.pvInProfesion = ?) ";
            }
            filtros.add(cliente.getPvInProfesion());
            and = true;
        }
        
        if((cliente.getPvStSexo() != null) && (!Cliente.SEXO_DEFAULT.equals(cliente.getPvStSexo()))){
            if(and){
                hql += "AND (cliente.pvStSexo = ?) ";
            }else{
                hql += "(cliente.pvStSexo = ?) ";
            }
            filtros.add(cliente.getPvStSexo());
            and = true;
        }
        
        if((cliente.getPvInTipoAlopecia() != null) && (cliente.getPvInTipoAlopecia().intValue() > Cliente.ALOPECIA_DEFAULT.intValue())){
            if(and){
                hql += "AND (cliente.pvInTipoAlopecia = ?) ";
            }else{
                hql += "(cliente.pvInTipoAlopecia = ?) ";
            }
            filtros.add(cliente.getPvInTipoAlopecia());
            and = true;
        }
        
        if((cliente.getPvLoTelefonoCasa() != null)  && (cliente.getPvLoTelefonoCasa().longValue() > Cliente.TELEFONO_DEFAULT.longValue() )){
            if(and){
                hql += "AND (cliente.pvLoTelefonoCasa = ?) ";
            }else{
                hql += "(cliente.pvLoTelefonoCasa = ?) ";
            }
            filtros.add(cliente.getPvLoTelefonoCasa());
            and = true;
        }
        
        if((cliente.getPvLoTelefonoCelular() != null)  && (cliente.getPvLoTelefonoCelular().longValue() > Cliente.TELEFONO_DEFAULT.longValue())){
            if(and){
                hql += "AND (cliente.pvLoTelefonoCelular = ?) ";
            }else{
                hql += "(cliente.pvLoTelefonoCelular = ?) ";
            }
            filtros.add(cliente.getPvLoTelefonoCelular());
            and = true;
        }
        
        if((cliente.getPvStFacturaNombre() != null)  && (!"".equals(cliente.getPvStFacturaNombre())) ){
            if(and){
                hql += "AND (UPPER(TRIM(cliente.pvStFacturaNombre)) = ?) ";
            }else{
                hql += "(UPPER(TRIM(cliente.pvStFacturaNombre)) = ?) ";
            }
            filtros.add(cliente.getPvStFacturaNombre());
            and = true;
        }
          
        if(and){
            hql += " ORDER BY cliente.pvDiDiagnostico.pvStNombre ASC";
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
	public void agregar(Cliente cliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
	     hibernate.save(cliente);
	}


	@Override
	public void modificar(Cliente cliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.merge(cliente);
	}


	@Override
	public void eliminar(Cliente cliente) throws BusinessErrorHelper {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        hibernate.delete(cliente);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Cliente cliente) {
		HibernateTemplate hibernate = this.getHibernateTemplate();
        String hql = "SELECT cliente.pvStCodigo FROM Cliente cliente WHERE cliente.pvStCodigo = ?";
        Object[] values = {cliente.getPvStCodigo()};
        List<Object> clientes = hibernate.find(hql,values);
        if(clientes.isEmpty()){
        	return false;
        }else{
        	return true;
        }
	}

}
