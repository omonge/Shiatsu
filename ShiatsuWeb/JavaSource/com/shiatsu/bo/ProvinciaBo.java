package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Provincia;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface ProvinciaBo {

	/**
	 * Metodo que agrega un registro en la tabla de Provincia
	 * @param provincia
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Provincia provincia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Provincia
	 * @param provincia
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Provincia provincia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Provincia
	 * @param provincia
	 */
	public void eliminar(Provincia provincia) throws BusinessErrorHelper;
	
	/**
     * Busca una Provincia por su código
     * @param provincia
     * @return El ajuste correspondiente
     */
    public Provincia buscar(Provincia provincia);
    
    /**Metodo existe
    * Permite verificar la existencia de un Provincia en la base de datos
    *@param provincia
    *@return true si el Provincia existe, false en caso contrario
    */
    public boolean existe(Provincia provincia);
    
    /**Metodo getProvincia
    * Devuelve los Provincias existentes en la base de datos
    *@return Lista de provincia, lista vacía en caso contrario.
    */
    public List<Provincia>getProvincia();

	/**Metodo getProvincia
	* Devuelve los provincia cuya descripción coincida con los datos dados
	*@param provincia
	*@return Lista de Provincias, lista vacia en caso contrario
	*/
	public List<Provincia> getProvincia(Provincia provincia);
 

}
