/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Droga;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface DrogaBo {
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
	 * Metodo que elimina un registro en la tabla de droga
	 * @param droga
	 */
	public void eliminar(Droga droga) throws BusinessErrorHelper;
	
	/**
     * Busca una Droga por su código
     * @param droga
     * @return El ajuste correspondiente
     */
    public Droga buscar(Droga droga);
    
    /**Metodo existe
    * Permite verificar la existencia de un Droga en la base de datos
    *@param droga
    *@return true si el Droga existe, false en caso contrario
    */
    public boolean existe(Droga droga);
    
    /**Metodo getDrogas
    * Devuelve los Drogas existentes en la base de datos
    *@return Lista de droga, lista vacía en caso contrario.
    */
    public List<Droga> getDrogas();

	/**Metodo getDrogas
	* Devuelve los Droga cuya descripción coincida con los datos dados
	*@param droga
	*@return Lista de Drogas, lista vacia en caso contrario
	*/
	public List<Droga> getDrogas(Droga droga);
}
