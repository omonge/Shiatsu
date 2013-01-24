package com.shiatsu.dao;

import java.util.List;

import com.shiatsu.domain.FrecuenciaAsistencia;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public interface FrecuenciaAsistenciaDao {

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
	 * Metodo que elimina un registro en la tabla de FrecuenciaAsistencia
	 * @param FrecuenciaAsistencia
	 */
	public void eliminar(FrecuenciaAsistencia frecuenciaAsistencia) throws BusinessErrorHelper;
	
	/**
     * Busca una frecuenciaAsistencia por su código
     * @param frecuenciaAsistencia
     * @return El ajuste correspondiente
     */
    public FrecuenciaAsistencia buscar(FrecuenciaAsistencia frecuenciaAsistencia);
    
    /**Metodo existe
    * Permite verificar la existencia de un frecuenciaAsistencia en la base de datos
    *@param frecuenciaAsistencia
    *@return true si el FrecuenciaAsistencia existe, false en caso contrario
    */
    public boolean existe(FrecuenciaAsistencia frecuenciaAsistencia);
    
    /**Metodo getFrecuenciaAsistencias
    * Devuelve los FrecuenciaAsistencias existentes en la base de datos
    *@return Lista de FrecuenciaAsistencias, lista vacía en caso contrario.
    */
    public List<FrecuenciaAsistencia> getFrecuenciaAsistencias();

	/**Metodo getFrecuenciaAsistencia
	* Devuelve los FrecuenciaAsistencias cuya descripción coincida con los datos dados
	*@param FrecuenciaAsistencia
	*@return Lista de FrecuenciaAsistencias, lista vacia en caso contrario
	*/
	public List<FrecuenciaAsistencia> getFrecuenciaAsistencias(FrecuenciaAsistencia frecuenciaAsistencia);
 
}
