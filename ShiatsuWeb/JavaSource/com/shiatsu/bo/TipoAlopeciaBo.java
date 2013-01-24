package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.TipoAlopecia;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface TipoAlopeciaBo {

	/**
	 * Metodo que agrega un registro en la tabla de tipoAlopecia
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de tipoAlopecia
	 * @param tipoAlopecia
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de tipoAlopecia
	 * @param tipoAlopecia
	 */
	public void eliminar(TipoAlopecia tipoAlopecia) throws BusinessErrorHelper;
	
	/**
     * Busca una TipoAlopecia por su código
     * @param tipoAlopecia
     * @return El ajuste correspondiente
     */
    public TipoAlopecia buscar(TipoAlopecia tipoAlopecia);
    
    /**Metodo existe
    * Permite verificar la existencia de un TipoAlopecia en la base de datos
    *@param tipoAlopecia
    *@return true si el TipoAlopecia existe, false en caso contrario
    */
    public boolean existe(TipoAlopecia tipoAlopecia);
    
    /**Metodo gettipoAlopecia
    * Devuelve los tipoAlopecias existentes en la base de datos
    *@return Lista de tipoAlopecias, lista vacía en caso contrario.
    */
    public List<TipoAlopecia>getTipoAlopecia();

	/**Metodo getTipoAlopecia
	* Devuelve los TipoAlopecia cuya descripción coincida con los datos dados
	*@param tipoAlopecia
	*@return Lista de tipoAlopecias, lista vacia en caso contrario
	*/
	public List<TipoAlopecia> getTipoAlopecia(TipoAlopecia tipoAlopecia);
 

}
