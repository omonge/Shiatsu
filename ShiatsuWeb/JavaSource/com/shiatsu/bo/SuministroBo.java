/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Suministro;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface SuministroBo {
/**
	 * Metodo que agrega un registro en la tabla de suministro
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Suministro suministro) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de suministro
	 * @param suministro
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Suministro suministro) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de suministro
	 * @param suministro
	 */
	public void eliminar(Suministro suministro) throws BusinessErrorHelper;
	
	/**
     * Busca una Suministro por su código
     * @param suministro
     * @return El ajuste correspondiente
     */
    public Suministro buscar(Suministro suministro);
    
    /**Metodo existe
    * Permite verificar la existencia de un Suministro en la base de datos
    *@param suministro
    *@return true si el Suministro existe, false en caso contrario
    */
    public boolean existe(Suministro suministro);
    
    /**Metodo getSuministros
    * Devuelve los Suministros existentes en la base de datos
    *@return Lista de suministro, lista vacía en caso contrario.
    */
    public List<Suministro> getSuministros();

	/**Metodo getSuministros
	* Devuelve los Suministro cuya descripción coincida con los datos dados
	*@param suministro
	*@return Lista de Suministros, lista vacia en caso contrario
	*/
	public List<Suministro> getSuministros(Suministro suministro);
}
