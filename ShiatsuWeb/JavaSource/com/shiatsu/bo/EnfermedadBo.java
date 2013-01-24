/**
 * EnfermedadBo.java
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Enfermedad;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;


/**
 * @author oscar.monge
 *
 */
public interface EnfermedadBo {
	/**
	 * Metodo que agrega un registro en la tabla de Enfermedad
	 * @param enfermedad
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Enfermedad enfermedad) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Enfermedad
	 * @param enfermedad
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Enfermedad enfermedad) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Enfermedad
	 * @param enfermedad
	 */
	public void eliminar(Enfermedad enfermedad) throws BusinessErrorHelper;
	
	/**
     * Busca una Enfermedad por su código
     * @param enfermedad
     * @return El ajuste correspondiente
     */
    public Enfermedad buscar(Enfermedad enfermedad);
    
    /**Metodo existe
    * Permite verificar la existencia de un Enfermedad en la base de datos
    *@param enfermedad
    *@return true si el Enfermedad existe, false en caso contrario
    */
    public boolean existe(Enfermedad enfermedad);
    
    /**Metodo getEnfermedad
    * Devuelve los Enfermedads existentes en la base de datos
    *@return Lista de Enfermedads, lista vacía en caso contrario.
    */
    public List<Enfermedad>getEnfermedad();

	/**Metodo getEnfermedad
	* Devuelve los Enfermedads cuya descripción coincida con los datos dados
	*@param enfermedad
	*@return Lista de Enfermedads, lista vacia en caso contrario
	*/
	public List<Enfermedad> getEnfermedad(Enfermedad enfermedad);
	
}
