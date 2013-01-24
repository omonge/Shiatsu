/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Producto;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface ProductoBo {
/**
	 * Metodo que agrega un registro en la tabla de producto
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Producto producto) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de producto
	 * @param producto
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Producto producto) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de producto
	 * @param producto
	 */
	public void eliminar(Producto producto) throws BusinessErrorHelper;
	
	/**
     * Busca una Producto por su código
     * @param producto
     * @return El ajuste correspondiente
     */
    public Producto buscar(Producto producto);
    
    /**Metodo existe
    * Permite verificar la existencia de un Producto en la base de datos
    *@param producto
    *@return true si el Producto existe, false en caso contrario
    */
    public boolean existe(Producto producto);
    
    /**Metodo getProductos
    * Devuelve los Productos existentes en la base de datos
    *@return Lista de producto, lista vacía en caso contrario.
    */
    public List<Producto>getProductos();

	/**Metodo getProductos
	* Devuelve los Producto cuya descripción coincida con los datos dados
	*@param producto
	*@return Lista de Productos, lista vacia en caso contrario
	*/
	public List<Producto> getProductos(Producto producto);
}
