package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Tarjeta;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface TarjetaDao {

	/**
	 * Metodo que agrega un registro en la tabla de tarjeta
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Tarjeta tarjeta) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de tarjeta
	 * @param tarjeta
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Tarjeta tarjeta) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Tarjeta
	 * @param Tarjeta
	 */
	public void eliminar(Tarjeta tarjeta) throws BusinessErrorHelper;
	
	/**
     * Busca una tarjeta por su código
     * @param tarjeta
     * @return El ajuste correspondiente
     */
    public Tarjeta buscar(Tarjeta tarjeta);
    
    /**Metodo existe
    * Permite verificar la existencia de un tarjeta en la base de datos
    *@param tarjeta
    *@return true si el Tarjeta existe, false en caso contrario
    */
    public boolean existe(Tarjeta tarjeta);
    
    /**Metodo getTarjeta
    * Devuelve los Tarjetas existentes en la base de datos
    *@return Lista de Tarjetas, lista vacía en caso contrario.
    */
    public List<Tarjeta>getTarjetas();

	/**Metodo getTarjeta
	* Devuelve los Tarjeta cuya descripción coincida con los datos dados
	*@param Tarjeta
	*@return Lista de Tarjetas, lista vacia en caso contrario
	*/
	public List<Tarjeta> getTarjetas(Tarjeta tarjeta);
 
}
