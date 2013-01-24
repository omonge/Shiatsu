package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Provincia;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface ProvinciaDao {
	/**
	 * Metodo que agrega un registro en la tabla de Provincia
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Provincia provincia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Provincia
	 * @param Provincia
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Provincia provincia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Provincia
	 * @param Provincia
	 */
	public void eliminar(Provincia provincia) throws BusinessErrorHelper;
	
	/**
     * Busca una Provincia por su código
     * @param Provincia
     * @return El ajuste correspondiente
     */
    public Provincia buscar(Provincia provincia);
    
    /**Metodo existe
    * Permite verificar la existencia de un Provincia en la base de datos
    *@param Provincia
    *@return true si el Provincia existe, false en caso contrario
    */
    public boolean existe(Provincia provincia);
    
    /**Metodo getProvincia
    * Devuelve los Provincias existentes en la base de datos
    *@return Lista de Provincias, lista vacía en caso contrario.
    */
    public List<Provincia>getProvincia();

	/**Metodo getProvincia
	* Devuelve los provincia cuya descripción coincida con los datos dados
	*@param provincia
	*@return Lista de Provincias, lista vacia en caso contrario
	*/
	public List<Provincia> getProvincia(Provincia provincia);
 
}
