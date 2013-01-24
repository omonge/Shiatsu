<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />

<!-- saved from url=(0014)about:internet -->

<html lang="es"><!-- InstanceBegin template="/Templates/plantilla.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Content-Type"         content="text/html; charset=ISO-8859-1">
    <meta http-equiv="Content-Style-Type"   content="text/css">
    <meta http-equiv="X-UA-Compatible"      content="IE=EmulateIE7"/> 
	<!-- InstanceBeginEditable name="doctitle" -->
<title>Shiatsu - Inicio </title>
<!-- InstanceEndEditable --> 
	<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
	<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %> 
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
	<%@ taglib uri="http://www.jenia.org/jsf/popup" prefix="jp" %>
	<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <link href="html5/normalize.css"                rel="stylesheet" type="text/css" /> 
    <link href="html5/plantilla_html5.css"          rel="stylesheet" type="text/css" />
    <link href="theme/hmenu/src/skin-modern3.css"   rel="stylesheet" type="text/css" />
    <link href="theme/styles/SIGETR.css"            rel="stylesheet" type="text/css" />
    <link href="theme/styles/shiatzu.css"              rel="stylesheet" type="text/css" />
    <link href="theme/styles/menu.css"              rel="stylesheet" type="text/css" />
    <link href="theme/styles/stylesheet.css"        rel="stylesheet" type="text/css" />
    <link href="theme/styles/tablas.css"            rel="stylesheet" type="text/css" />
    <link href="theme/stylesheet.css"               rel="stylesheet" type="text/css" />
    <link href="theme/tabpanel.css"                 rel="stylesheet" type="text/css" />
    <link href="theme/Master.css"                   rel="stylesheet" type="text/css" />
    
    <script type="text/javascript" src="html5/jquery.js"></script> 
    <script type="text/javascript" src="html5/plantilla_html5.js"></script> 
    <script type="text/javascript" src="theme/hmenu/src/hmenu.js"></script>
    <script type="text/javascript">document.writeln("<style type='text/css'>#menu { display: none; }</style>");</script>    
</head> 

<f:view locale="es-CR">
    <f:loadBundle var="rcs" basename="com.shiatsu.web.bundles.recursos" />
        <body onload="DynarchMenu.setup('menu'); getFocus();">
            <div id="wrap"> 
                <header id="tablaBanner">
                </header>
                <nav>
                    <h:form id="formBanner" >
                        
                            <div id="menus">
                                <div id="usuario" class="flotarIzquierda"> 
                                        <h:outputText styleClass="outputText" id="usuario" value="Shiatzu"/>  
                                </div>
                                <div id="menu_fecha" class="flotarDerecha">
                                    <script language="JavaScript">mostrarFecha();</script> - <h:outputText value="#{rcs['version']}"></h:outputText>
                                </div> 
                                <div id="menu_mes_contable" class="flotarDerecha">
                                    <label></label>  
                                </div>
                            </div>
                            <div style="clear: both"></div>
                            <div id="raya_amarilla"></div>
                            <div id="menu_page">
								<ul id="menu">	 
								<li><a href="shiatsuInicio.jsf?init=true">Inicio</a></li>
								<li>Cat&aacute;logos
								  <ul>
									<li>Clientes
									  <ul>
										<li><a href="shiatsuActCliente.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsClientes.jsf?init=true">Consulta</a> </li> 
										<li><a href="shiatsuListaClientes.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Diagn&oacute;stico
									  <ul>
										<li><a href="shiatsuActDiagnostico.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsDiagnostico.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaDiagnostico.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Enfermedad
									  <ul>
										<li><a href="shiatsuActEnfermedad.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsEnfermedad.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaEnfermedad.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Medicamento
									  <ul>
										<li><a href="shiatsuActMedicamaento.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsMedicamento.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaMedicamento.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Tipo Alopecia
									  <ul>
										<li><a href="shiatsuActTipoAlopecia.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsTipoAlopecia.jsf?init=true">Consulta</a></li> 
										<li><a href="shiatsuListaTipoAlopecia.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Pa&iacute;s 
									  <ul>
										<li><a href="shiatsuActPais.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsPais.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaPais.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>  
									<li>Profesi&oacute;n
									  <ul>
										<li><a href="shiatsuActProfesion.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsProfesion.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaProfesion.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Bodega
									  <ul>
										<li><a href="shiatsuActBodega.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsBodega.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaBodega.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Frecuencia Asistencia
									  <ul>
										<li><a href="shiatsuActFrecuenciaAsistencia.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsFrecuenciaAsistencia.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaFrecuenciaAsistencia.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Producto
									  <ul>
										<li><a href="shiatsuActProducto.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsProducto.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaProducto.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Droga
									  <ul>
										<li><a href="shiatsuActDroga.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsDroga.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaDroga.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>TipoCliente
									  <ul>
										<li><a href="shiatsuActTipoCliente.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsTipoCliente.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaTipoCliente.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Suministro
									  <ul>
										<li><a href="shiatsuActSuministro.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsSuministro.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaSuministro.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
									<li>Usuario
									  <ul>
										<li><a href="shiatsuActUsuario.jsf?init=true">Agregar</a></li>
										<li><a href="shiatsuConsUsuario.jsf?init=true">Consulta</a></li>
										<li><a href="shiatsuListaUsuario.jsf?init=true">Mantenimiento</a></li>
									  </ul>
									</li>
								  </ul>
								</li>
								<li><a href="#">Salir</a> </li>
							  </ul> 
                      </div> 
                  </h:form>
                </nav>
                <section id="main"> 
                    <div id="titulo" class="Tit_04_naranja">
					<!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.cliente.mantenimiento']}"/><!-- InstanceEndEditable -->
                    </div>
                    <div id="cuerpo" class="Text">
						<!-- InstanceBeginEditable name="contenido" -->
       <h:form  styleClass="form" id="form1" >
       <h:inputHidden value="#{clienteController.init}" ></h:inputHidden>
   <table border="0">
		<tbody>
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="txt1" value="#{rcs['cliente.codigo']}"></h:outputText>
			    </td>
		  	    <td class="formPaddingData">
		  	    	<h:inputText styleClass="inputText" id="txtPvLoCodigo"
		  	    				 value="#{clienteController.cliente.pvDiDiagnostico.pvStCodigo}" size="10" maxlength="10" readonly="true" style="text-transform: uppercase">
		  	    	</h:inputText> 
		  	    	 <jp:popupFrame width="650" height="400" title="#{rcs['titulo.diagnostico.popup']}" id="diagnosticoPopUp"
                             actionOpen="#{clienteController.abrirPopUpDiagnostico}" 
                             actionClose="#{clienteController.cerrarPopUpDiagnostico}" center="true"> 
                          <h:commandButton type="submit" image="images/buscar.gif" styleClass="commandExButton" id="btnBuscarDiagnostico" title="#{rcs['titulo.diagnostico.popup']}"></h:commandButton>
                     </jp:popupFrame>
		  	    	<h:message styleClass="error" id="msgTxtCodigo" for="txtPvLoCodigo" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
		    </tr>
		    <tr>
			  		<td class="Tit04Tabla"> 
			  			<h:outputText styleClass="outputText" id="lblNombre"
						value="#{rcs['cliente.nombre']}"></h:outputText>
				    </td>
			  	    <td class="formPaddingData">
			  	    	<h:inputText styleClass="inputText" id="txtPvStNombre" 
			  	    				 value="#{clienteController.cliente.pvDiDiagnostico.pvStNombre}"   readonly="true" size="50" maxlength="50" style="text-transform: uppercase">
			  	    	</h:inputText> 
			  	    	<h:message styleClass="error" id="msgTxtNombre" for="txtPvStNombre" errorClass="error" infoClass="info" warnClass="warn"></h:message>
			  	   </td>
			</tr>
			<tr>
			  		<td class="Tit04Tabla"> 
			  			<h:outputText styleClass="outputText" id="lblProvincia"
						value="#{rcs['cliente.provincia']}"></h:outputText>
				    </td>
			  	    <td class="formPaddingData">
			  	    	 <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInProvincia" value="#{clienteController.cliente.pvInProvincia}" onchange="submit();" >
									<f:selectItems value="#{clienteController.provinciaItems}"/>
							</h:selectOneMenu>
		                <h:message styleClass="error" id="msgCmbPvInProvincia" for="cmbPvInProvincia" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
		           </td>
			</tr>
			<tr>
			  		<td class="Tit04Tabla"> 
			  			<h:outputText styleClass="outputText" id="lblCanton"
						value="#{rcs['cliente.canton']}"></h:outputText>
				    </td>
			  	    <td class="formPaddingData">
			  	    	 <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInCanton" value="#{clienteController.cliente.pvInCanton}"  onchange="submit();">
									<f:selectItems value="#{clienteController.cantonItems}"/>
							</h:selectOneMenu>
		                <h:message styleClass="error" id="msgCmbPvInCanton" for="cmbPvInCanton" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
		           </td>
			</tr>
			<tr>
			  		<td class="Tit04Tabla"> 
			  			<h:outputText styleClass="outputText" id="lblDistrito"
						value="#{rcs['cliente.canton']}"></h:outputText>
				    </td>
			  	    <td class="formPaddingData">
			  	    	 <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInDistrito" value="#{clienteController.cliente.pvInDistrito}">
									<f:selectItems value="#{clienteController.distritoItems}"/>
							</h:selectOneMenu>
		                <h:message styleClass="error" id="msgCmbPvInDistrito" for="cmbPvInDistrito" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
		           </td>
			</tr>
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="lblDireccion"
					value="#{rcs['cliente.direccion']}"></h:outputText>
			    </td>
		  	    <td class="formPaddingData">
		  	    	<h:inputText styleClass="inputText" id="txtPvStDireccion" 
		  	    				 value="#{clienteController.cliente.pvStDireccion}" size="50" maxlength="50" style="text-transform: uppercase">
		  	    	</h:inputText> 
		  	    	<h:message styleClass="error" id="msgTxtDireccion" for="txtPvStDireccion" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
		    </tr>
			<tr>
		  		<td class="Tit04Tabla">
		  			<h:outputText styleClass="outputText" id="lblEmails"
					value="#{rcs['cliente.email']}"></h:outputText>
			    </td>
			     <td class="formPaddingData">
		  	    	<h:inputText styleClass="inputText" id="txtPvStEmail1" 
		  	    				 value="#{clienteController.cliente.pvStEmail1}" size="50" maxlength="50">
		  	    	</h:inputText> 
		  	    	<h:message styleClass="error" id="msgTxtStEmail1" for="txtPvStEmail1" errorClass="error" infoClass="info" warnClass="warn"></h:message>
		  	   </td>
			 </tr> 
			<tr>
	  		<td class="Tit04Tabla">
	  			<h:outputText styleClass="outputText" id="lblCelular"
				value="#{rcs['cliente.telefonoCelular']}"></h:outputText>
		    </td>
		    <td class="formPaddingData">
	  			
		    <h:inputText styleClass="inputText" id="txtPvLoTelefonoCelular" value="#{clienteController.cliente.pvLoTelefonoCelular}" size="8" maxlength="8">
	  	    	</h:inputText><h:message styleClass="error" id="msgTxtpvInTelefonoCelular" for="txtPvLoTelefonoCelular" errorClass="error" infoClass="info" warnClass="warn"></h:message></td>
		 </tr> 
		 <tr>
	  	   	<td class="Tit04Tabla">	
	  	   		 
	  	    	<h:outputText styleClass="outputText" id="lblCasa" value="#{rcs['cliente.telefonoCasa']}"></h:outputText>
	  	   </td>
	  	    <td class="formPaddingData">
	  	    	<h:inputText styleClass="inputText" id="txtPvLoTelefonoCasa" 
	  	    				 value="#{clienteController.cliente.pvLoTelefonoCasa}" size="8" maxlength="8">
	  	    	</h:inputText> 
	  	    	<h:message styleClass="error" id="msgTxtpvInTelefonoCasa" for="txtPvLoTelefonoCasa" errorClass="error" infoClass="info" warnClass="warn"></h:message>
	  	   	</td>
	    </tr>
	    <tr>
            <td class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblFacturaANombre" value="#{rcs['cliente.facturaANombre']}"></h:outputText></td>
            <td class="formPaddingData">
              	<h:inputText styleClass="inputText" id="txtPvStFacturaNombre" 
	  	    				 value="#{clienteController.cliente.pvStFacturaNombre}" size="50" maxlength="50">
	  	    	</h:inputText>
                <h:message styleClass="error" id="msgTxtPvStFacturaNombre" for="txtPvStFacturaNombre" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblFrecuenciaCita" value="#{rcs['cliente.frecuencia']}"></h:outputText></td>
            <td class="formPaddingData">
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInFrecuenciaCita" value="#{clienteController.cliente.pvInFrecuenciaCita}">
									<f:selectItems value="#{clienteController.frecuenciasCitasItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvInFrecuenciaCita" for="cmbPvInFrecuenciaCita" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblProfesion" value="#{rcs['cliente.profesion']}"></h:outputText></td>
            <td class="formPaddingData">
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvIntProfesion" value="#{clienteController.cliente.pvInProfesion}">
									<f:selectItems value="#{clienteController.profesionItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvIntProfesion" for="cmbPvIntProfesion" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla" ><h:outputText styleClass="outputText" id="lblLugarProfesion" value="#{rcs['cliente.lugarProfesion']}"></h:outputText></td>
            <td class="formPaddingData">
              	<h:inputText styleClass="inputText" id="txtPvStLugarProfesion" 
	  	    				 value="#{clienteController.cliente.pvStLugarProfesion}" size="50" maxlength="50" style="text-transform: uppercase">
	  	    	</h:inputText>
                <h:message styleClass="error" id="msgTxtPvStLugarProfesion" for="txtPvStLugarProfesion" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla" ><h:outputText styleClass="outputText" id="lblNacionalidad" value="#{rcs['cliente.nacionalidad']}"></h:outputText></td>
            <td class="formPaddingData">
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInNacionalidad" value="#{clienteController.cliente.pvInNacionalidad}">
									<f:selectItems value="#{clienteController.nacionalidadItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvInNacionalidad" for="cmbPvInNacionalidad" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td class="Tit04Tabla" ><h:outputText styleClass="outputText" id="lblNacimiento" value="#{rcs['cliente.nacimiento']}"></h:outputText></td>
            <td> <t:inputCalendar id="txtPvDaNacimiento" 
				    maxlength="10" 
				    value="#{clienteController.cliente.pvDaNacimiento}"
				    monthYearRowClass="monthYearRowClass" 
				    weekRowClass="weekRowClass" 
				    dayCellClass="dayCellClass" 
				    currentDayCellClass="currentDayCellClass"
				    popupTodayString="Hoy :" 
				    popupWeekString="Wk" renderAsPopup="true"
				    renderPopupButtonAsImage="true" 
				    popupDateFormat="dd/MM/yyyy"
				    alt="Calendario" title="Calendario">
				 </t:inputCalendar>
  				<h:message styleClass="error" id="msgTxtPvDaNacimiento" for="txtPvDaNacimiento" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <tr>
            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblSexo" value="#{rcs['cliente.sexo']}"></h:outputText></td>
            <td class="formPaddingData">
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvIntSexo" value="#{clienteController.cliente.pvStSexo}">
									<f:selectItems value="#{clienteController.sexoItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgTxtPvIntSexo" for="cmbPvIntSexo" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
      	<tr>
            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblTipoAlopecia" value="#{rcs['cliente.tipoAlopecia']}"></h:outputText></td>
            <td class="formPaddingData">
	  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInTipoAlopecia" value="#{clienteController.cliente.pvInTipoAlopecia}">
									<f:selectItems value="#{clienteController.tipoAlopeciaItems}"/>
					</h:selectOneMenu>
                <h:message styleClass="error" id="msgCmbPvInTipoAlopecia" for="cmbPvInTipoAlopecia" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
            </td>
        </tr>
        <c:if test="${!clienteController.agregar}">	
			<tr>
	            <td class="Tit04Tabla" ><h:outputText styleClass="outputText" id="lblEstado" value="#{rcs['cliente.estado']}"/></td>
	            <td class="formPaddingData">
	                <h:selectOneMenu styleClass="selectOneMenu" id="cmbPvInEstado" value="#{clienteController.cliente.pvStEstado}">
									<f:selectItems value="#{clienteController.estadoItems}"/>
					</h:selectOneMenu>
	                <h:message styleClass="error" id="msgTxtEstado" for="cmbPvInEstado" errorClass="error" infoClass="info" warnClass="warn"/>
	            </td>
	        </tr>
		</c:if>
		<tr>
            <td colspan="2">
	            <h:commandButton type="submit" value="#{rcs['boton.agregar']}"   styleClass="commandButton" id="btnAgregar"   rendered="#{clienteController.agregar}" 	action="#{clienteController.insertar}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.modificar']}" styleClass="commandButton" id="btnModificar" rendered="#{!clienteController.agregar}" 	action="#{clienteController.modificar}"></h:commandButton>
	            <h:commandButton type="submit" value="#{rcs['boton.eliminar']}"  styleClass="commandButton" id="btnEliminar"  rendered="#{!clienteController.agregar}"  	action="#{clienteController.eliminar}" onclick="return confirmEliminar('e','Cliente');"></h:commandButton>
			    <h:commandButton type="submit" value="#{rcs['boton.regresar']}"  styleClass="commandButton" id="bntRegresar"  action="#{clienteController.regresar}"></h:commandButton>	            
            </td>
        </tr>
		</tbody>
	</table>
		
		<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"></h:messages>
	</h:form>
					<!-- InstanceEndEditable -->   
                    </div>
                </section>
            </div>
            <div id="footer">
                <footer>
                </footer>
            </div> 
            <form method="post" action="Templates/ibm_security_logout" name="logout" id="logout">
                <input type="hidden" name="logoutExitPage" value="main.jsf" />
            </form>   
        </body>
    </f:view>
<!-- InstanceEnd --></html>