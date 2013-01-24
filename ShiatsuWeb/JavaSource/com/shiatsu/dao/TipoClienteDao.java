package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.TipoCliente;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface TipoClienteDao {

	/**
	 * Metodo que agrega un registro en la tabla de tipoCliente
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(TipoCliente tipoCliente) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de tipoCliente
	 * @param tipoCliente
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(TipoCliente tipoCliente) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de TipoCliente
	 * @param TipoCliente
	 */
	public void eliminar(TipoCliente tipoCliente) throws BusinessErrorHelper;
	
	/**
     * Busca una tipoCliente por su código
     * @param tipoCliente
     * @return El ajuste correspondiente
     */
    public TipoCliente buscar(TipoCliente tipoCliente);
    
    /**Metodo existe
    * Permite verificar la existencia de un tipoCliente en la base de datos
    *@param tipoCliente
    *@return true si el TipoCliente existe, false en caso contrario
    */
    public boolean existe(TipoCliente tipoCliente);
    
    /**Metodo getTipoCliente
    * Devuelve los TipoClientes existentes en la base de datos
    *@return Lista de TipoClientes, lista vacía en caso contrario.
    */
    public List<TipoCliente>getTipoClientes();

	/**Metodo getTipoCliente
	* Devuelve los TipoCliente cuya descripción coincida con los datos dados
	*@param TipoCliente
	*@return Lista de TipoClientes, lista vacia en caso contrario
	*/
	public List<TipoCliente> getTipoClientes(TipoCliente tipoCliente);
 
}
