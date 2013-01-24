/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Sucursal;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface SucursalBo {
/**
	 * Metodo que agrega un registro en la tabla de sucursal
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Sucursal sucursal) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de sucursal
	 * @param sucursal
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Sucursal sucursal) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de sucursal
	 * @param sucursal
	 */
	public void eliminar(Sucursal sucursal) throws BusinessErrorHelper;
	
	/**
     * Busca una Sucursal por su código
     * @param sucursal
     * @return El ajuste correspondiente
     */
    public Sucursal buscar(Sucursal sucursal);
    
    /**Metodo existe
    * Permite verificar la existencia de un Sucursal en la base de datos
    *@param sucursal
    *@return true si el Sucursal existe, false en caso contrario
    */
    public boolean existe(Sucursal sucursal);
    
    /**Metodo getSucursales
    * Devuelve las getSucursales existentes en la base de datos
    *@return Lista de sucursal, lista vacía en caso contrario.
    */
    public List<Sucursal> getSucursales();

	/**Metodo getSucursales
	* Devuelve las Sucursales cuya descripción coincida con los datos dados
	*@param sucursal
	*@return Lista de getSucursales, lista vacia en caso contrario
	*/
	public List<Sucursal> getSucursales(Sucursal sucursal);
}
