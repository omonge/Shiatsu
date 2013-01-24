/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Bodega;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface BodegaBo {
/**
	 * Metodo que agrega un registro en la tabla de bodega
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Bodega bodega) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de bodega
	 * @param bodega
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Bodega bodega) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de bodega
	 * @param bodega
	 */
	public void eliminar(Bodega bodega) throws BusinessErrorHelper;
	
	/**
     * Busca una Bodega por su código
     * @param bodega
     * @return El ajuste correspondiente
     */
    public Bodega buscar(Bodega bodega);
    
    /**Metodo existe
    * Permite verificar la existencia de un Bodega en la base de datos
    *@param bodega
    *@return true si el Bodega existe, false en caso contrario
    */
    public boolean existe(Bodega bodega);
    
    /**Metodo getBodegaes
    * Devuelve las getBodegaes existentes en la base de datos
    *@return Lista de bodega, lista vacía en caso contrario.
    */
    public List<Bodega> getBodegas();

	/**Metodo getBodegaes
	* Devuelve las Bodegaes cuya descripción coincida con los datos dados
	*@param bodega
	*@return Lista de getBodegaes, lista vacia en caso contrario
	*/
	public List<Bodega> getBodegas(Bodega bodega);
}
