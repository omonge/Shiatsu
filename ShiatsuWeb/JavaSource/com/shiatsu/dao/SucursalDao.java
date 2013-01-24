package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Sucursal;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface SucursalDao {

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
	 * Metodo que elimina un registro en la tabla de Sucursal
	 * @param Sucursal
	 */
	public void eliminar(Sucursal sucursal) throws BusinessErrorHelper;
	
	/**
     * Busca una sucursal por su código
     * @param sucursal
     * @return El ajuste correspondiente
     */
    public Sucursal buscar(Sucursal sucursal);
    
    /**Metodo existe
    * Permite verificar la existencia de un sucursal en la base de datos
    *@param sucursal
    *@return true si el Sucursal existe, false en caso contrario
    */
    public boolean existe(Sucursal sucursal);
    
    /**Metodo getSucursales
    * Devuelve los Sucursales existentes en la base de datos
    *@return Lista de Sucursals, lista vacía en caso contrario.
    */
    public List<Sucursal> getSucursales();

	/**Metodo getSucursal
	* Devuelve los Sucursales cuya descripción coincida con los datos dados
	*@param Sucursal
	*@return Lista de Sucursales, lista vacia en caso contrario
	*/
	public List<Sucursal> getSucursales(Sucursal sucursal);
 
}
