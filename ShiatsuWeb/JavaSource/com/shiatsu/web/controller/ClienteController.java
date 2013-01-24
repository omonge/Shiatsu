/**
 * 
 */
package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable; 
import javax.faces.model.SelectItem;

import com.shiatsu.domain.Canton;
import com.shiatsu.domain.Cita;
import com.shiatsu.domain.Cliente;
import com.shiatsu.domain.Diagnostico;
import com.shiatsu.domain.Distrito;
import com.shiatsu.domain.Pais;
import com.shiatsu.domain.Profesion;
import com.shiatsu.domain.Provincia;
import com.shiatsu.domain.TipoAlopecia;
import com.shiatsu.web.bundles.Bundle;
import com.utilidades.business.BusinessErrorHelper;
import com.shiatsu.bo.CantonBo;
import com.shiatsu.bo.ClienteBo;
import com.shiatsu.bo.DistritoBo;
import com.shiatsu.bo.PaisBo;
import com.shiatsu.bo.ProfesionBo;
import com.shiatsu.bo.ProvinciaBo;
import com.shiatsu.bo.TipoAlopeciaBo;
import com.shiatzu.util.Controller;

/**
 * @author oscar.monge
 *
 */
public class ClienteController extends Controller {
	 
    private HtmlDataTable 	listaDataTableCliente;
    private List<Cliente> 	listaCliente; 
    private Cliente 	  	cliente;
	private ClienteBo	  	clienteBo;  
	private PaisBo	  	  	paisBo;  
	private ProfesionBo	  	profesionBo;  
	private TipoAlopeciaBo	tipoAlopeciaBo; 
	private ProvinciaBo	  	provinciaBo; 
	private CantonBo	  	cantonBo; 
	private DistritoBo	  	distritoBo; 
	
	
	public ClienteController() { 
		this.reiniciarController();
	}
	
	@Override
	protected void reiniciarController(){
		this.reiniciarFiltro();
		this.reiniciarDatos(); 
	}
	
	@Override
	protected void reiniciarFiltro(){ 
		this.agregar=Boolean.TRUE;
		this.cliente=new Cliente();
	}
	
	@Override
	protected void reiniciarDatos(){ 
		this.listaDataTableCliente=new HtmlDataTable();
		this.listaCliente = new ArrayList<Cliente>(); 
	}
	
	
	/****************** METODOS *************************************/
 
	 /**
	 * @return the init
	 */ 
	public boolean getInit() {  
		Object dato = this.getFacesContext().getExternalContext().getRequestParameterMap().get("init");
        if (dato != null) {
           this.reiniciarController();
           this.buscarTodos();
        } 
        return init;
	}
	 
	  
    /**
     * MÈtodo abrirPopUpDiagnostico
     * Abre el pop up 
     * @return success
     */
    public String abrirPopUpDiagnostico() {
        this.getFacesContext().getApplication().createValueBinding("#{diagnosticoController.diagnostico}").setValue(this.getFacesContext(), new Diagnostico());
        return "success";
    }
 
    /**
     * MÈtodo cerrarPopUpDiagnostico
     * Cierra el pop up
     * @return success
     */ 
    public String cerrarPopUpDiagnostico(){
    	Diagnostico diagnostico = (Diagnostico) this.getFacesContext().getApplication().createValueBinding("#{diagnosticoController.diagnostico}").getValue(this.getFacesContext());
        this.cliente.setPvDiDiagnostico(diagnostico);
        return "success";
    }


	/**
     * MÈtodo para validar el cÛdigo, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;

    	 
    	if ((this.cliente.getPvLoTelefonoCasa() != null) && (this.cliente.getPvLoTelefonoCasa().longValue() > Cliente.TELEFONO_DEFAULT.longValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvLoTelefonoCelular()!= null) && (this.cliente.getPvLoTelefonoCelular().longValue() > Cliente.TELEFONO_DEFAULT.longValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInFrecuenciaCita()!= null) && (this.cliente.getPvInFrecuenciaCita().intValue() > Cliente.FRECUENCIA_CITA_DEFAULT.intValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInProfesion() != null) && (this.cliente.getPvInProfesion().intValue() > Cliente.PROFESION_DEFAULT.intValue())) {
            correcto = true;
    	}
    	if ((this.cliente.getPvInNacionalidad() != null) && (this.cliente.getPvInNacionalidad().intValue() > Cliente.NACIONALIDAD_DEFAULT.intValue())) {
            correcto = true;
    	}    	
    	if ((this.cliente.getPvStSexo() != null) && (!Cliente.SEXO_DEFAULT.equals(this.cliente.getPvStSexo()))) {
            correcto = true;
    	} 
    	if ((this.cliente.getPvInTipoAlopecia() != null) && (this.cliente.getPvInTipoAlopecia().intValue()  > Cliente.ALOPECIA_DEFAULT.intValue() )) {
            correcto = true;
    	}
    	if ((this.cliente.getPvStEstado() != null) && (!Cliente.ESTADO_DEFAULT.equals(this.cliente.getPvStEstado()))) {
            correcto = true;
    	}
        return correcto;
    }

    /**
     * Metodo validarObjetoId Metodo que valida el id del objeto que se quiere buscar, agregar o modificar
     * @return bool
     */
    private boolean validarObjetoId() { 
        boolean correcto = false;
        if((this.cliente.getPvStCodigo()!=null) && (!Cliente.CLIENTE_DEFAULT.equals(this.cliente.getPvStCodigo()))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * MÈtodo buscar Busca las listaCliente que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTableCliente != null){this.listaDataTableCliente.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Cliente cliente = this.clienteBo.buscar(this.cliente);
            if (cliente != null) {
                this.listaCliente.add(cliente);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.listaCliente = this.clienteBo.getClientes(this.cliente);
        		respuesta = "success";
        	}
            else{ 
                this.addWarning(null, Bundle.rcs.getString("todosLosRegistros"));
                this.buscarTodos();
            }
        } 
        if ((respuesta == "success") && (this.listaCliente.isEmpty())) { 
            this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        } else if (respuesta == "success") {
            this.reiniciarFiltro();
            this.addInfo(null, Bundle.rcs.getString("operacionExitosa"));
        }
        return respuesta;
    }
 
	public void buscarTodos(){
		this.listaCliente = this.clienteBo.getClientes();
        if(this.listaCliente.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la p√°gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.cliente = (Cliente) this.listaDataTableCliente.getRowData();
	     this.agregar = false;
		 return "success";
	}
	/**
     * Retorna una lista de selectItems que contienen estados del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cliente.ESTADO_ACTIVO,    Cliente.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(Cliente.ESTADO_INACTIVO,  Cliente.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getFrecuenciasCitasItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cita.CITA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cita.CITA_SEMANAL,  	Cita.CITA_SEMANAL_DESCRIPCION));
		items.add(new SelectItem(Cita.CITA_QUINCENAL,  	Cita.CITA_QUINCENAL_DESCRIPCION));
		items.add(new SelectItem(Cita.CITA_MENSUAL,  	Cita.CITA_MENSUAL_DESCRIPCION));
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getProfesionItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.PROFESION_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		List<Profesion> lista = this.profesionBo.getProfesion();
		for (Profesion profesion : lista) {
			items.add(new SelectItem(profesion.getPvInCodigo(),  profesion.getPvStDescripcion()));
		}
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getNacionalidadItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.NACIONALIDAD_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		List<Pais> lista = this.paisBo.getPais();
		for (Pais pais : lista) {
			items.add(new SelectItem(pais.getPvInCodigo(),  pais.getPvStDescripcion()));
		}
		return items;
	}
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getSexoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.SEXO_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cliente.SEXO_FEMENINO,  	Cliente.SEXO_FEMENINO_DESCRIPCION));
		items.add(new SelectItem(Cliente.SEXO_MASCULINO,  	Cliente.SEXO_MASCULINO_DESCRIPCION));
		return items;
	}
	
	/** Retorna una lista de selectItems que contiene las provincia
     * @return Lista de objetos <code>SelectItem</code> que contienen las provincias
     */
	public List<SelectItem> getProvinciaItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Provincia.PROVINCIA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		List<Provincia> lista = this.provinciaBo.getProvincia();
		for (Provincia provincia : lista) {
			items.add(new SelectItem(provincia.getPvInCodigo(),  provincia.getPvStDescripcion()));
		}
		return items;
	}
	
	/** Retorna una lista de selectItems que contiene los cantones
     * @return Lista de objetos <code>SelectItem</code> que contienen los cantones
     */
	public List<SelectItem> getCantonItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Canton.DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		if((this.cliente.getPvInProvincia()!=null) && (!Provincia.PROVINCIA_DEFAULT.equals(this.cliente.getPvInProvincia()))){
			Canton elCanton = new Canton();
			elCanton.getPvPrProvincia().setPvInCodigo(this.cliente.getPvInProvincia());
			List<Canton> lista = this.cantonBo.getCanton(elCanton);
			for (Canton canton : lista) {
				items.add(new SelectItem(canton.getPvInCodigo(),  canton.getPvStDescripcion()));
			}
		}
		return items;
	}
	
	
	/** Retorna una lista de selectItems que contiene los distritos
     * @return Lista de objetos <code>SelectItem</code> que contienen los distritos
     */
	public List<SelectItem> getDistritoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Distrito.DISTRITO_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		if((this.cliente.getPvInCanton()!=null) && (!Canton.DEFAULT.equals(this.cliente.getPvInCanton()))){
			Distrito elDistrito = new Distrito();
			elDistrito.getPvPrProvincia().setPvInCodigo(this.cliente.getPvInProvincia());
			elDistrito.getPvCaCanton().setPvInCodigo(this.cliente.getPvInCanton());
			List<Distrito> lista = this.distritoBo.getDistrito(elDistrito);
			for (Distrito distrito : lista) {
				items.add(new SelectItem(distrito.getPvInCodigo(),  distrito.getPvStDescripcion()));
			}
		}
		return items;
	}

	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del cliente
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del cliente
     */
	public List<SelectItem> getTipoAlopeciaItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cliente.ALOPECIA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		List<TipoAlopecia> lista = this.tipoAlopeciaBo.getTipoAlopecia();
		for (TipoAlopecia tipoAlopecia : lista) {
			items.add(new SelectItem(tipoAlopecia.getPvInCodigo(),  tipoAlopecia.getPvStDescripcion()));
		}
		return items;
	}
	
	/*********************** NAVEGACION *******************************/
	/**Metodo irAgregar
	* 
	*@return success
	*/
	public String irAgregar(){
		this.reiniciarController();
		return "success";
	}
	public String regresar(){
		this.reiniciarFiltro();
		this.buscarTodos();
		return "success";
	}
	/*********************** VALIDACION  *******************************/
	
	/**Metodo validaInsertar
	* Valida los datos del cliente
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validaInsertar(){
		boolean correcto = true;
		try{
			if((this.cliente.getPvLoTelefonoCasa() == null) ||(Cliente.TELEFONO_DEFAULT.equals(this.cliente.getPvLoTelefonoCasa()))){
				this.addError(this.getPropertyFieldName("cliente.pvLoTelefonoCasa"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvLoTelefonoCelular() == null ||(Cliente.TELEFONO_DEFAULT.equals(this.cliente.getPvLoTelefonoCelular())))){
				this.addError(this.getPropertyFieldName("cliente.pvLoTelefonoCelular"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvStDireccion() == null) || ("".equals(this.cliente.getPvStDireccion()))){
				this.addError(this.getPropertyFieldName("cliente.pvStDireccion"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			/*if((this.cliente.getPvStEmail1() == null) || (this.cliente.getPvStEmail1().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvStEmail1"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvStEmail2() == null) || (this.cliente.getPvStEmail2().equals(""))){
				this.addError(this.getPropertyFieldName("cliente.pvStEmail2"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}*/ 
			if((this.cliente.getPvStEstado() == null) || (Cliente.ESTADO_DEFAULT.equals(this.cliente.getPvStEstado()))){
				this.addError(this.getPropertyFieldName("cliente.pvInEstado"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvInFrecuenciaCita() == null) || (Cliente.FRECUENCIA_CITA_DEFAULT.equals(this.cliente.getPvInFrecuenciaCita()))){
				this.addError(this.getPropertyFieldName("cliente.pvInFrecuenciaCita"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvInNacionalidad() == null) || (Cliente.FRECUENCIA_CITA_DEFAULT.equals(this.cliente.getPvInNacionalidad()))){
				this.addError(this.getPropertyFieldName("cliente.pvInNacionalidad"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvInProfesion() == null) || (Cliente.PROFESION_DEFAULT.equals(this.cliente.getPvInProfesion()))){
				this.addError(this.getPropertyFieldName("cliente.pvInProfesion"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvStSexo() == null) || (Cliente.SEXO_DEFAULT.equals(this.cliente.getPvStSexo()))){
				this.addError(this.getPropertyFieldName("cliente.pvInSexo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.cliente.getPvInTipoAlopecia() == null) || (Cliente.ALOPECIA_DEFAULT.equals(this.cliente.getPvInTipoAlopecia()))){
				this.addError(this.getPropertyFieldName("cliente.pvInTipoAlopecia"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
		}catch(NumberFormatException nef){
            this.addError(null, Bundle.rcs.getString("soloNumeros"));
            nef.printStackTrace();
        }catch(Exception e){
        	this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
            e.printStackTrace();
		}
		return correcto;
	}
	
	/**MÈtodo agregar
	* Agrega un cliente en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	this.cliente.setPvStEstado(Cliente.ESTADO_ACTIVO);
                this.clienteBo.agregar(this.cliente);
                this.addInfo(null, Bundle.rcs.getString("datosAgregados"));
                respuesta = "success";
                this.reiniciarFiltro();
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/**MÈtodo modificar
	* Modificar un cliente en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
                this.clienteBo.modificar(this.cliente);
                this.addInfo(null, Bundle.rcs.getString("datosModificados"));
                respuesta = "success";
            }
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	/**M√©todo eliminar
	* Eliminar un cliente en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.clienteBo.eliminar(this.cliente);
            this.addInfo(null, Bundle.rcs.getString("datosEliminados")); 
            this.reiniciarController();
            this.buscarTodos();
            respuesta = "success";
        }catch(BusinessErrorHelper be){
            this.exceptionBussinessError(be);
        }catch(Exception e){
            this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        }
        return respuesta;
	}
	@Override
	protected String getPropertyFieldName(String property) {
		if(property != null){
			if (property.equals("cliente.pvLoCodigo")) 					return "form1:txtPvLoCodigo";
			if (property.equals("cliente.pvLoTelefonoCasa")) 			return "form1:txtPvLoTelefonoCasa";
			if (property.equals("cliente.pvLoTelefonoCelular")) 		return "form1:txtPvLoTelefonoCelular";
			if (property.equals("cliente.pvStDireccion")) 				return "form1:txtPvStDireccion";
			if (property.equals("cliente.pvStEmail1")) 					return "form1:txtPvStEmail1";
			if (property.equals("cliente.pvStEmail2")) 					return "form1:txtPvStEmail2";
			if (property.equals("cliente.pvStNombre")) 					return "form1:txtPvStNombre";
			if (property.equals("clienteBo.eliminar")) 					return "form1:txtPvLoCodigo";
			if (property.equals("clienteBo.modificar")) 				return "form1:txtPvLoCodigo";
			if (property.equals("clienteBo.agregar")) 					return "form1:txtPvLoCodigo";
			if (property.equals("cliente.pvInEstado")) 	   			    return "form1:cmbPvInEstado";
			if (property.equals("cliente.buscar")) 	    				return "form1:txtBuscar";
		}
		return null;
	}
/********************** SET Y GETS ****************************/
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	} 
  
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the listaDataTableCliente
	 */
	public HtmlDataTable getListaDataTableCliente() {
		return listaDataTableCliente;
	}

	/**
	 * @param listaDataTableCliente the listaDataTableCliente to set
	 */
	public void setListaDataTableCliente(HtmlDataTable listaDataTableCliente) {
		this.listaDataTableCliente = listaDataTableCliente;
	}

	/**
	 * @return the listaCliente
	 */
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	/**
	 * @param listaCliente the listaCliente to set
	 */
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	/**
	 * @return the clienteBo
	 */
	public ClienteBo getClienteBo() {
		return clienteBo;
	}

	/**
	 * @param clienteBo the clienteBo to set
	 */
	public void setClienteBo(ClienteBo clienteBo) {
		this.clienteBo = clienteBo;
	}

	/**
	 * @return the paisBo
	 */
	public PaisBo getPaisBo() {
		return paisBo;
	}

	/**
	 * @param paisBo the paisBo to set
	 */
	public void setPaisBo(PaisBo paisBo) {
		this.paisBo = paisBo;
	}

	/**
	 * @return the profesionBo
	 */
	public ProfesionBo getProfesionBo() {
		return profesionBo;
	}

	/**
	 * @param profesionBo the profesionBo to set
	 */
	public void setProfesionBo(ProfesionBo profesionBo) {
		this.profesionBo = profesionBo;
	}

	/**
	 * @return the tipoAlopeciaBo
	 */
	public TipoAlopeciaBo getTipoAlopeciaBo() {
		return tipoAlopeciaBo;
	}

	/**
	 * @param tipoAlopeciaBo the tipoAlopeciaBo to set
	 */
	public void setTipoAlopeciaBo(TipoAlopeciaBo tipoAlopeciaBo) {
		this.tipoAlopeciaBo = tipoAlopeciaBo;
	}

	/**
	 * @return the provinciaBo
	 */
	public ProvinciaBo getProvinciaBo() {
		return provinciaBo;
	}

	/**
	 * @param provinciaBo the provinciaBo to set
	 */
	public void setProvinciaBo(ProvinciaBo provinciaBo) {
		this.provinciaBo = provinciaBo;
	}

	/**
	 * @return the cantonBo
	 */
	public CantonBo getCantonBo() {
		return cantonBo;
	}

	/**
	 * @param cantonBo the cantonBo to set
	 */
	public void setCantonBo(CantonBo cantonBo) {
		this.cantonBo = cantonBo;
	}

	/**
	 * @return the distritoBo
	 */
	public DistritoBo getDistritoBo() {
		return distritoBo;
	}

	/**
	 * @param distritoBo the distritoBo to set
	 */
	public void setDistritoBo(DistritoBo distritoBo) {
		this.distritoBo = distritoBo;
	}

	
}
