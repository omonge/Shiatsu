package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Suministro;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface SuministroDao {

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
	 * Metodo que elimina un registro en la tabla de Suministro
	 * @param Suministro
	 */
	public void eliminar(Suministro suministro) throws BusinessErrorHelper;
	
	/**
     * Busca una suministro por su código
     * @param suministro
     * @return El ajuste correspondiente
     */
    public Suministro buscar(Suministro suministro);
    
    /**Metodo existe
    * Permite verificar la existencia de un suministro en la base de datos
    *@param suministro
    *@return true si el Suministro existe, false en caso contrario
    */
    public boolean existe(Suministro suministro);
    
    /**Metodo getSuministro
    * Devuelve los Suministros existentes en la base de datos
    *@return Lista de Suministros, lista vacía en caso contrario.
    */
    public List<Suministro>getSuministros();

	/**Metodo getSuministro
	* Devuelve los Suministro cuya descripción coincida con los datos dados
	*@param Suministro
	*@return Lista de Suministros, lista vacia en caso contrario
	*/
	public List<Suministro> getSuministros(Suministro suministro);
 
}
