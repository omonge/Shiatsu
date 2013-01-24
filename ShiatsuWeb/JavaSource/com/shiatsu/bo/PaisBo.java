package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Pais;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface PaisBo {

	/**
	 * Metodo que agrega un registro en la tabla de Pais
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Pais pais) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Pais
	 * @param Pais
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Pais pais) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Pais
	 * @param Pais
	 */
	public void eliminar(Pais pais) throws BusinessErrorHelper;
	
	/**
     * Busca una Pais por su código
     * @param Pais
     * @return El ajuste correspondiente
     */
    public Pais buscar(Pais pais);
    
    /**Metodo existe
    * Permite verificar la existencia de un Pais en la base de datos
    *@param Pais
    *@return true si el Pais existe, false en caso contrario
    */
    public boolean existe(Pais pais);
    
    /**Metodo getPaiss
    * Devuelve los Paiss existentes en la base de datos
    *@return Lista de Paiss, lista vacía en caso contrario.
    */
    public List<Pais>getPais();

	/**Metodo getPais
	* Devuelve los pais cuya descripción coincida con los datos dados
	*@param pais
	*@return Lista de Paiss, lista vacia en caso contrario
	*/
	public List<Pais> getPais(Pais pais);
 

}
