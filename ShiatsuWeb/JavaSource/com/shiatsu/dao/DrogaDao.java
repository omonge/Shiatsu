package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Droga;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface DrogaDao {

	/**
	 * Metodo que agrega un registro en la tabla de droga
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Droga droga) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de droga
	 * @param droga
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Droga droga) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Droga
	 * @param Droga
	 */
	public void eliminar(Droga droga) throws BusinessErrorHelper;
	
	/**
     * Busca una droga por su código
     * @param droga
     * @return El ajuste correspondiente
     */
    public Droga buscar(Droga droga);
    
    /**Metodo existe
    * Permite verificar la existencia de un droga en la base de datos
    *@param droga
    *@return true si el Droga existe, false en caso contrario
    */
    public boolean existe(Droga droga);
    
    /**Metodo getDroga
    * Devuelve los Drogas existentes en la base de datos
    *@return Lista de Drogas, lista vacía en caso contrario.
    */
    public List<Droga> getDrogas();

	/**Metodo getDroga
	* Devuelve los Droga cuya descripción coincida con los datos dados
	*@param Droga
	*@return Lista de Drogas, lista vacia en caso contrario
	*/
	public List<Droga> getDrogas(Droga droga);
 
}
