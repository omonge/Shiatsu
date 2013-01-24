/**
 * CantonDao.java
 */
package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Canton;
import com.utilidades.business.BusinessErrorHelper;


public interface CantonDao {
	/**
	 * Metodo que agrega un registro en la tabla de Ajuste
	 * @param canton
	 */
	public void agregar(Canton canton) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Canton
	 * @param canton
	 */
	public void modificar(Canton canton)throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Canton
	 * @param canton
	 */
	public void eliminar(Canton canton)throws BusinessErrorHelper;
	
	/**
     * Busca una Canton por su código
     * @param canton
     * @return El ajuste correspondiente
     */
    public Canton buscar(Canton canton);
    
    /**Metodo existe
    * Permite verificar la existencia de un Canton en la base de datos
    *@param canton
    *@return true si el canton existe, false en caso contrario
    */
    public boolean existe(Canton canton);
    /**Metodo getCanton
     * Devuelve los cantons existentes en la base de datos
     *@return Lista de Cantons, lista vacía en caso contrario.
     */
     public List<Canton>getCanton();
     /**Metodo getCanton
 	* Devuelve los canton cuya descripción coincida con los datos dados
 	*@param nombre
 	*@return Lista de Cantons, lista vacia en caso contrario
 	*/
 	public List<Canton> getCanton(Canton canton);
}
