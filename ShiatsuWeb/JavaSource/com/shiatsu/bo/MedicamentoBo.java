/**
 * MedicamentoBo.java
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Medicamento;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;


/**
 * @author oscar.monge
 *
 */
public interface MedicamentoBo {
	/**
	 * Metodo que agrega un registro en la tabla de Medicamento
	 * @param medicamento
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Medicamento medicamento) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Medicamento
	 * @param medicamento
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Medicamento medicamento) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Medicamento
	 * @param medicamento
	 */
	public void eliminar(Medicamento medicamento) throws BusinessErrorHelper;
	
	/**
     * Busca una Medicamento por su código
     * @param medicamento
     * @return El ajuste correspondiente
     */
    public Medicamento buscar(Medicamento medicamento);
    
    /**Metodo existe
    * Permite verificar la existencia de un Medicamento en la base de datos
    *@param medicamento
    *@return true si el Medicamento existe, false en caso contrario
    */
    public boolean existe(Medicamento medicamento);
    
    /**Metodo getMedicamento
    * Devuelve los Medicamentos existentes en la base de datos
    *@return Lista de Medicamentos, lista vacía en caso contrario.
    */
    public List<Medicamento>getMedicamento();

	/**Metodo getMedicamento
	* Devuelve los Medicamentos cuya descripción coincida con los datos dados
	*@param medicamento
	*@return Lista de Medicamentos, lista vacia en caso contrario
	*/
	public List<Medicamento> getMedicamento(Medicamento medicamento);
	
}
