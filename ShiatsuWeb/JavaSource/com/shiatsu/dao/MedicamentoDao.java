/**
 * MedicamentoDao.java
 */
package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.Medicamento;
import com.utilidades.business.BusinessErrorHelper;


public interface MedicamentoDao {
	/**
	 * Metodo que agrega un registro en la tabla de Ajuste
	 * @param Medicamento
	 */
	public void agregar(Medicamento medicamento) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de Medicamento
	 * @param Medicamento
	 */
	public void modificar(Medicamento medicamento)throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de Medicamento
	 * @param Medicamento
	 */
	public void eliminar(Medicamento medicamento)throws BusinessErrorHelper;
	
	/**
     * Busca una Medicamento por su código
     * @param Medicamento
     * @return El ajuste correspondiente
     */
    public Medicamento buscar(Medicamento medicamento);
    
    /**Metodo existe
    * Permite verificar la existencia de un Medicamento en la base de datos
    *@param Medicamento
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
 	*@param nombre
 	*@return Lista de Medicamentos, lista vacia en caso contrario
 	*/
 	public List<Medicamento> getMedicamento(Medicamento medicamento);
}
