/**
 * DiagnosticoBo.java
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Diagnostico;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;


/**
 * @author oscar.monge
 *
 */
public interface DiagnosticoBo {
	/**
	 * Metodo que agrega un registro en la tabla de Diagnostico
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Diagnostico diagnostico) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Diagnostico
	 * @param diagnostico
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Diagnostico diagnostico) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Diagnostico
	 * @param diagnostico
	 */
	public void eliminar(Diagnostico diagnostico) throws BusinessErrorHelper;
	
	/**
     * Busca una Diagnostico por su código
     * @param diagnostico
     * @return El ajuste correspondiente
     */
    public Diagnostico buscar(Diagnostico diagnostico);
    
    /**Metodo existe
    * Permite verificar la existencia de un Diagnostico en la base de datos
    *@param diagnostico
    *@return true si el diagnostico existe, false en caso contrario
    */
    public boolean existe(Diagnostico diagnostico);
    
    /**Metodo getDiagnosticos
    * Devuelve los diagnosticos existentes en la base de datos
    *@return Lista de Diagnosticos, lista vacía en caso contrario.
    */
    public List<Diagnostico>getDiagnosticos();

	/**Metodo getDiagnosticos
	* Devuelve los diagnosticos cuya descripción coincida con los datos dados
	*@param diagnostico
	*@return Lista de Diagnosticos, lista vacia en caso contrario
	*/
	public List<Diagnostico> getDiagnosticos(Diagnostico diagnostico);
	
}
