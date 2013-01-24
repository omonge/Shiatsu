/**
 * 
 */
package com.shiatsu.bo;

import java.util.List;

import com.shiatsu.domain.Usuario;
import com.utilidades.business.BusinessErrorHelper;

/**
 * @author omonge
 *
 */
public interface UsuarioBo {
/**
	 * Metodo que agrega un registro en la tabla de usuario
	 * @param ajuste
	 * @throws BusinessObjectHelper 
	 */
	public void agregar(Usuario usuario) throws BusinessErrorHelper;
	
	/**
	 * Metodo que modifica un registro en la tabla de usuario
	 * @param usuario
	 * @throws BusinessErrorHelper 
	 */
	public void modificar(Usuario usuario) throws BusinessErrorHelper;
	
	/**
	 * Metodo que elimina un registro en la tabla de usuario
	 * @param usuario
	 */
	public void eliminar(Usuario usuario) throws BusinessErrorHelper;
	
	/**
     * Busca una Usuario por su código
     * @param usuario
     * @return El ajuste correspondiente
     */
    public Usuario buscar(Usuario usuario);
    
    /**Metodo existe
    * Permite verificar la existencia de un Usuario en la base de datos
    *@param usuario
    *@return true si el Usuario existe, false en caso contrario
    */
    public boolean existe(Usuario usuario);
    
    /**Metodo getUsuarios
    * Devuelve los Usuarios existentes en la base de datos
    *@return Lista de usuario, lista vacía en caso contrario.
    */
    public List<Usuario>getUsuarios();

	/**Metodo getUsuarios
	* Devuelve los Usuario cuya descripción coincida con los datos dados
	*@param usuario
	*@return Lista de Usuarios, lista vacia en caso contrario
	*/
	public List<Usuario> getUsuarios(Usuario usuario);
}
