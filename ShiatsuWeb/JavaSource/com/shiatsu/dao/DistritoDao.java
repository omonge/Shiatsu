/**
 * DistritoDao.java
 */
package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Distrito;
import com.utilidades.business.BusinessErrorHelper;


public interface DistritoDao {
	/**
	 * Metodo que agrega un registro en la tabla de Ajuste
	 * @param Distrito
	 */
	public void agregar(Distrito distrito) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Distrito
	 * @param Distrito
	 */
	public void modificar(Distrito distrito)throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Distrito
	 * @param Distrito
	 */
	public void eliminar(Distrito distrito)throws BusinessErrorHelper;
	
	/**
     * Busca una Distrito por su código
     * @param Distrito
     * @return El ajuste correspondiente
     */
    public Distrito buscar(Distrito distrito);
    
    /**Metodo existe
    * Permite verificar la existencia de un Distrito en la base de datos
    *@param Distrito
    *@return true si el Distrito existe, false en caso contrario
    */
    public boolean existe(Distrito distrito);
    /**Metodo getDistrito
     * Devuelve los Distritos existentes en la base de datos
     *@return Lista de Distritos, lista vacía en caso contrario.
     */
     public List<Distrito>getDistrito();
     /**Metodo getDistrito
 	* Devuelve los Distritos cuya descripción coincida con los datos dados
 	*@param nombre
 	*@return Lista de Distritos, lista vacia en caso contrario
 	*/
 	public List<Distrito> getDistrito(Distrito distrito);
}
