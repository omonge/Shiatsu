/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.FrecuenciaAsistencia;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface FrecuenciaAsistenciaBo {
/**
	 * Metodo que agrega un registro en la tabla de frecuenciaAsistencia
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de frecuenciaAsistencia
	 * @param frecuenciaAsistencia
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de frecuenciaAsistencia
	 * @param frecuenciaAsistencia
	 */
	public void eliminar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper;
	
	/**
     * Busca una FrecuenciaAsistencia por su código
     * @param frecuenciaAsistencia
     * @return El ajuste correspondiente
     */
    public FrecuenciaAsistencia buscar(FrecuenciaAsistencia frecuenciaAsistencia);
    
    /**Metodo existe
    * Permite verificar la existencia de un FrecuenciaAsistencia en la base de datos
    *@param frecuenciaAsistencia
    *@return true si el FrecuenciaAsistencia existe, false en caso contrario
    */
    public boolean existe(FrecuenciaAsistencia frecuenciaAsistencia);
    
    /**Metodo getFrecuenciaAsistenciaes
    * Devuelve las getFrecuenciaAsistenciaes existentes en la base de datos
    *@return Lista de frecuenciaAsistencia, lista vacía en caso contrario.
    */
    public List<FrecuenciaAsistencia> getFrecuenciaAsistencias();

	/**Metodo getFrecuenciaAsistencias
	* Devuelve las FrecuenciaAsistencias cuya descripción coincida con los datos dados
	*@param frecuenciaAsistencia
	*@return Lista de getFrecuenciaAsistenciaes, lista vacia en caso contrario
	*/
	public List<FrecuenciaAsistencia> getFrecuenciaAsistencias(FrecuenciaAsistencia frecuenciaAsistencia);
}
