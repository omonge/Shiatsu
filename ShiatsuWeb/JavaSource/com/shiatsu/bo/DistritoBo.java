package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Distrito;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface DistritoBo {

	/**
	 * Metodo que agrega un registro en la tabla de  distrito
	 * @param  distrito
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Distrito  distrito) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de  distrito
	 * @param  distrito
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Distrito  distrito) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de  distrito
	 * @param  distrito
	 */
	public void eliminar(Distrito  distrito) throws BusinessErrorHelper;
	
	/**
     * Busca una  distrito por su código
     * @param  distrito
     * @return El ajuste correspondiente
     */
    public  Distrito buscar(Distrito  distrito);
    
    /**Metodo existe
    * Permite verificar la existencia de un  distrito en la base de datos
    *@param  distrito
    *@return true si el  distrito existe, false en caso contrario
    */
    public boolean existe(Distrito  distrito);
    
    /**Metodo get distrito
    * Devuelve los  distritos existentes en la base de datos
    *@return Lista de  distritos, lista vacía en caso contrario.
    */
    public List<Distrito>getDistrito();

	/**Metodo get distrito
	* Devuelve los  distrito cuya descripción coincida con los datos dados
	*@param  distrito
	*@return Lista de  distritos, lista vacia en caso contrario
	*/
	public List<Distrito> getDistrito(Distrito  distrito);
 

}
