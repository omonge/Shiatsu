package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Bodega;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface BodegaDao {

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
	 * Metodo que elimina un registro en la tabla de Bodega
	 * @param Bodega
	 */
	public void eliminar(Bodega bodega) throws BusinessErrorHelper;
	
	/**
     * Busca una bodega por su código
     * @param bodega
     * @return El ajuste correspondiente
     */
    public Bodega buscar(Bodega bodega);
    
    /**Metodo existe
    * Permite verificar la existencia de un bodega en la base de datos
    *@param bodega
    *@return true si el Bodega existe, false en caso contrario
    */
    public boolean existe(Bodega bodega);
    
    /**Metodo getBodegas
    * Devuelve los Bodegas existentes en la base de datos
    *@return Lista de Bodegas, lista vacía en caso contrario.
    */
    public List<Bodega> getBodegas();

	/**Metodo getBodega
	* Devuelve los Bodegas cuya descripción coincida con los datos dados
	*@param Bodega
	*@return Lista de Bodegas, lista vacia en caso contrario
	*/
	public List<Bodega> getBodegas(Bodega bodega);
 
}
