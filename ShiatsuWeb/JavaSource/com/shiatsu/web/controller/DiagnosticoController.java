/**
 * 
 */
package com.shiatsu.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable; 
import javax.faces.model.SelectItem;
import com.shiatsu.domain.Cita;
import com.shiatsu.domain.Diagnostico;
import com.shiatsu.domain.Provincia;
import com.shiatsu.domain.TipoAlopecia;
import com.shiatsu.web.bundles.Bundle;
import com.utilidades.business.BusinessErrorHelper;
import com.shiatsu.bo.CantonBo;
import com.shiatsu.bo.DiagnosticoBo;
import com.shiatsu.bo.DistritoBo;
import com.shiatsu.bo.PaisBo;
import com.shiatsu.bo.ProfesionBo;
import com.shiatsu.bo.ProvinciaBo;
import com.shiatsu.bo.TipoAlopeciaBo;
import com.shiatzu.util.Controller;

/**
 * @author msaikol.salamanca
 *
 */
public class DiagnosticoController extends Controller {
	 
    private HtmlDataTable 		listaDataTableDiagnostico;
    private List<Diagnostico> 	listaDiagnostico; 
    private Diagnostico 	  	diagnostico;
	private DiagnosticoBo	  	diagnosticoBo;  
	private PaisBo	  	  		paisBo;  
	private ProfesionBo	  		profesionBo;  
	private TipoAlopeciaBo		tipoAlopeciaBo; 
	private ProvinciaBo	  		provinciaBo; 
	private CantonBo	  		cantonBo; 
	private DistritoBo	  		distritoBo; 
	
	
	public DiagnosticoController() { 
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
		this.diagnostico=new Diagnostico();
	}
	
	@Override
	protected void reiniciarDatos(){ 
		this.listaDataTableDiagnostico=new HtmlDataTable();
		this.listaDiagnostico = new ArrayList<Diagnostico>(); 
	}
	
	
	 /**
     * Recupera el objeto seleccionado del DataTable
     * Lo carga para ser usado luego y cierra el popUp
     * @return String "jeniaClosePopupFrameWithAction"
     */
    public String cargarObjetoPopUp(){
        this.diagnostico = (Diagnostico) this.listaDataTableDiagnostico.getRowData();
        return "jeniaClosePopupFrameWithAction";
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
     * Método para validar el código, agrega el error al faces si lo hay
     * @return boolean true si es correcto, false si hay algo malo
     */
    private boolean validarFiltro() {
        boolean correcto = false;
   
		if((this.diagnostico.getPvStDermatitisOleosa()) != null && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDermatitisOleosa()))){
			correcto = true;
		}
		if((this.diagnostico.getPvStDermatitisSeborreica())  != null && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDermatitisSeborreica()))){
			correcto = true;
		}
		if((this.diagnostico.getPvStDermatitisSeca()) != null && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDermatitisSeca())) ){
			correcto = true;
		}
		if((this.diagnostico.getPvStDeshidratacion())  != null && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDeshidratacion())) ){
			correcto = true;
		}
		if((this.diagnostico.getPvStNombre()  != null) && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStNombre()))){
			correcto = true;
		}
		if((this.diagnostico.getPvStPsoriasis()  != null) && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStPsoriasis()))){
			correcto = true;
		} 
		if((this.diagnostico.getPvStTelanocitos()  != null) && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStTelanocitos()))){
			correcto = true;
		}
		if((this.diagnostico.getPvInTipoAlopecia()  != null) && (!Diagnostico.NUMERO_DEFAULT.equals(this.diagnostico.getPvInTipoAlopecia()))){
			correcto = true;
		}
		if((this.diagnostico.getPvStCaspa()  != null) && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStCaspa()))){
			correcto = true;
		} 
		if((this.diagnostico.getPvStHongo()  != null) && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStHongo()))){
			correcto = true;
		} 
		if((this.diagnostico.getPvStEstado()  != null) && (!Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStEstado()))){
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
        if((this.diagnostico.getPvStCodigo()!=null) && (!"".equals(this.diagnostico.getPvStCodigo()))) {
        	correcto = true;
        }
        return correcto;
    }


    /**
     * Método buscar Busca las listaDiagnostico que cumplan con el filtro
     * @return String "success" o "error"
     */
    public String buscar() {
        if(this.listaDataTableDiagnostico != null){this.listaDataTableDiagnostico.setFirst(0);} 
        String respuesta = "error";
        this.reiniciarDatos();
        if (this.validarObjetoId()) {
            Diagnostico diagnostico = this.diagnosticoBo.buscar(this.diagnostico);
            if (diagnostico != null) {
                this.listaDiagnostico.add(diagnostico);
            }
            respuesta = "success";
        } else{
        	if (this.validarFiltro()) {
        		this.listaDiagnostico = this.diagnosticoBo.getDiagnosticos(this.diagnostico);
        		respuesta = "success";
        	}
            else{ 
                this.addWarning(null, Bundle.rcs.getString("todosLosRegistros"));
                this.buscarTodos();
            }
        } 
        if ((respuesta == "success") && (this.listaDiagnostico.isEmpty())) { 
            this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        } else if (respuesta == "success") {
            this.reiniciarFiltro();
            this.addInfo(null, Bundle.rcs.getString("operacionExitosa"));
        }
        return respuesta;
    }
 
	public void buscarTodos(){
		this.listaDiagnostico = this.diagnosticoBo.getDiagnosticos();
        if(this.listaDiagnostico.isEmpty()){
        	this.addError(null, Bundle.rcs.getString("noHayRegistros"));
        }
	}
	/**Metodo cargarObjeto
	* Carga el objeto seleccionado de la tabla de la pÃ¡gina
	*@return success
	*/
	public String cargarObjeto(){
		 this.diagnostico = (Diagnostico) this.listaDataTableDiagnostico.getRowData();
	     this.agregar = false;
		 return "success";
	}
	/**
     * Retorna una lista de selectItems que contienen estados del diagnostico
     * @return Lista de objetos <code>SelectItem</code> que contienen los ID de los estados existentes
     */
	public List<SelectItem> getEstadoItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Diagnostico.ESTADO_DEFAULT,   Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Diagnostico.ESTADO_ACTIVO,    Diagnostico.ESTADO_ACTIVO_DESCRIPCION));
		items.add(new SelectItem(Diagnostico.ESTADO_INACTIVO,  Diagnostico.ESTADO_INACTIVO_DESCRIPCION));
		return items;
	}
	
	/**
     * Retorna una lista de selectItems que contienen frecuencia de citas del diagnostico
     * @return Lista de objetos <code>SelectItem</code> que contienen las frecuencia de citas del diagnostico
     */
	public List<SelectItem> getFrecuenciasCitasItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Cita.CITA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Cita.CITA_SEMANAL,  	Cita.CITA_SEMANAL_DESCRIPCION));
		items.add(new SelectItem(Cita.CITA_QUINCENAL,  	Cita.CITA_QUINCENAL_DESCRIPCION));
		items.add(new SelectItem(Cita.CITA_MENSUAL,  	Cita.CITA_MENSUAL_DESCRIPCION));
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
	
	
	/** Retorna una lista de selectItems que contiene los tipoAlopecia
     * @return Lista de objetos <code>SelectItem</code> que contienen los tipoAlopecia
     */
	public List<SelectItem> getTipoAlopeciaItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(TipoAlopecia.TIPO_APOPECIA_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		List<TipoAlopecia> lista = this.tipoAlopeciaBo.getTipoAlopecia();
		for (TipoAlopecia tipoAlopecia : lista) {
			items.add(new SelectItem(tipoAlopecia.getPvInCodigo(),  tipoAlopecia.getPvStDescripcion()));
		}
		return items;
	}
	
	
	/** Retorna una lista de selectItems que contiene los tipoAlopecia
     * @return Lista de objetos <code>SelectItem</code> que contienen los tipoAlopecia
     */
	public List<SelectItem> getTipoSINOItems(){
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(Diagnostico.TEXTO_DEFAULT,     Bundle.rcs.getString("seleccion.valor")));
		items.add(new SelectItem(Diagnostico.TEXTO_SI, Diagnostico.TEXTO_SI));
		items.add(new SelectItem(Diagnostico.TEXTO_NO, Diagnostico.TEXTO_NO));
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
	* Valida los datos del diagnostico
	*@return true si los datos son correctos, false en caso contrario
	*/
	private boolean validaInsertar(){
		boolean correcto = true;
		try{
			if((this.diagnostico.getPvDoPorcentajePerdida() == null) ||(Diagnostico.NUMERO_DEFAULT.equals(this.diagnostico.getPvDoPorcentajePerdida()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvDoPorcentajePerdida"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStDermatitisOleosa() == null ||(Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDermatitisOleosa())))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStDermatitisOleosa"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStDermatitisSeborreica() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDermatitisSeborreica()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStDermatitisSeborreica"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStDermatitisSeca() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDermatitisSeca())) ){
				this.addError(this.getPropertyFieldName("diagnostico.pvStDermatitisSeca"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStDeshidratacion() == null) ||  (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStDeshidratacion())) ){
				this.addError(this.getPropertyFieldName("diagnostico.pvStDeshidratacion"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStNombre() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStNombre()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStNombre"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStPsoriasis() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStPsoriasis()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStPsoriasis"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			} 
			if((this.diagnostico.getPvStTelanocitos() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStTelanocitos()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStTelanocitos"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvInTipoAlopecia() == null) || (Diagnostico.NUMERO_DEFAULT.equals(this.diagnostico.getPvInTipoAlopecia()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvInTipoAlopecia"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStCaspa() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStCaspa()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStCaspa"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStCodigo() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStCodigo()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStCodigo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			if((this.diagnostico.getPvStHongo() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStHongo()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStHongo"),Bundle.rcs.getString("campoRequerido"));
				correcto = false;
			}
			
			if((this.diagnostico.getPvStEstado() == null) || (Diagnostico.TEXTO_DEFAULT.equals(this.diagnostico.getPvStEstado()))){
				this.addError(this.getPropertyFieldName("diagnostico.pvStEstado"),Bundle.rcs.getString("campoRequerido"));
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
	
	/**Método agregar
	* Agrega un diagnostico en la base de datos
	*@return success si logra insertar, error en caso contrario
	*/
	public String insertar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
            	this.diagnostico.setPvStEstado(Diagnostico.ESTADO_ACTIVO);
                this.diagnosticoBo.agregar(this.diagnostico); 
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
	/**Método modificar
	* Modificar un diagnostico en la base de datos
	*@return success si logra modificar, error en caso contrario
	*/
	public String modificar(){
		String respuesta = "error";
        try{
            if(this.validaInsertar()){
                this.diagnosticoBo.modificar(this.diagnostico);
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
	/**MÃ©todo eliminar
	* Eliminar un diagnostico en la base de datos
	*@return success si logra eliminar, error en caso contrario
	*/
	public String eliminar(){
		String respuesta = "error";
        try{
            this.diagnosticoBo.eliminar(this.diagnostico);
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
			if (property.equals("diagnostico.pvDoPorcentajePerdida")) 		return "form1:txtPvDoPorcentajePerdida";
			if (property.equals("diagnostico.pvStDermatitisOleosa")) 		return "form1:txtPvStDermatitisOleosa";
			if (property.equals("diagnostico.pvStDermatitisSeborreica")) 	return "form1:txtPvStDermatitisSeborreica";
			if (property.equals("diagnostico.pvStDermatitisSeca")) 			return "form1:txtPvStDermatitisSeca";
			if (property.equals("diagnostico.pvStNombre")) 					return "form1:txtPvStNombre";
			if (property.equals("diagnostico.pvStPsoriasis")) 				return "form1:txtPvStPsoriasis"; 
			if (property.equals("diagnostico.pvStDeshidratacion")) 			return "form1:txtPvStDeshidratacion";
			if (property.equals("diagnostico.pvStNombre")) 					return "form1:txtPvStNombre";
			if (property.equals("diagnostico.pvStHongo")) 					return "form1:txtPvStHongo";
			if (property.equals("diagnostico.pvStCaspa")) 					return "form1:txtPvStCaspa";
			if (property.equals("diagnostico.pvStTelanocitos")) 	   		return "form1:txtPvStTelanocitos";
			if (property.equals("diagnostico.pvInTipoAlopecia")) 	    	return "form1:cmbPvInTipoAlopecia";
			if (property.equals("diagnostico.pvStCodigo")) 	    			return "form1:txtPvLoCodigo";
			if (property.equals("diagnostico.pvStEstado")) 	    			return "form1:cmbPvStEstado";
			
		}
		return null;
	}
/********************** SET Y GETS ****************************/
	/**
	 * @return the diagnostico
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	} 
  
	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the listaDataTableDiagnostico
	 */
	public HtmlDataTable getListaDataTableDiagnostico() {
		return listaDataTableDiagnostico;
	}

	/**
	 * @param listaDataTableDiagnostico the listaDataTableDiagnostico to set
	 */
	public void setListaDataTableDiagnostico(HtmlDataTable listaDataTableDiagnostico) {
		this.listaDataTableDiagnostico = listaDataTableDiagnostico;
	}

	/**
	 * @return the listaDiagnostico
	 */
	public List<Diagnostico> getListaDiagnostico() {
		return listaDiagnostico;
	}

	/**
	 * @param listaDiagnostico the listaDiagnostico to set
	 */
	public void setListaDiagnostico(List<Diagnostico> listaDiagnostico) {
		this.listaDiagnostico = listaDiagnostico;
	}

	/**
	 * @return the diagnosticoBo
	 */
	public DiagnosticoBo getDiagnosticoBo() {
		return diagnosticoBo;
	}

	/**
	 * @param diagnosticoBo the diagnosticoBo to set
	 */
	public void setDiagnosticoBo(DiagnosticoBo diagnosticoBo) {
		this.diagnosticoBo = diagnosticoBo;
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
