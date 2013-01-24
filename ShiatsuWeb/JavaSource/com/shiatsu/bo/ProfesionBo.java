package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Profesion;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface ProfesionBo {

	/**
	 * Metodo que agrega un registro en la tabla de Profesion
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Profesion profesion) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Profesion
	 * @param Profesion
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Profesion profesion) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Profesion
	 * @param Profesion
	 */
	public void eliminar(Profesion profesion) throws BusinessErrorHelper;
	
	/**
     * Busca una Profesion por su código
     * @param Profesion
     * @return El ajuste correspondiente
     */
    public Profesion buscar(Profesion profesion);
    
    /**Metodo existe
    * Permite verificar la existencia de un Profesion en la base de datos
    *@param Profesion
    *@return true si el Profesion existe, false en caso contrario
    */
    public boolean existe(Profesion profesion);
    
    /**Metodo getProfesion
    * Devuelve los Profesions existentes en la base de datos
    *@return Lista de Profesions, lista vacía en caso contrario.
    */
    public List<Profesion>getProfesion();

	/**Metodo getProfesion
	* Devuelve los profesion cuya descripción coincida con los datos dados
	*@param profesion
	*@return Lista de Profesions, lista vacia en caso contrario
	*/
	public List<Profesion> getProfesion(Profesion profesion);
 

}
