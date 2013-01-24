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
					<!-- InstanceBeginEditable name="titulo" --><h:outputText styleClass="outputText" value="#{rcs['titulo.diagnostico.mantenimiento']}"/><!-- InstanceEndEditable -->
                    </div>
                    <div id="cuerpo" class="Text">
						<!-- InstanceBeginEditable name="contenido" -->
					
					<h:form  styleClass="form" id="form1"  >
					<h:inputHidden value="#{diagnosticoController.init}" ></h:inputHidden>
					   		<table border="0">
					<tbody>
						<tr>
					  		<td class="Tit04Tabla">
					  			<h:outputText styleClass="outputText" id="txt1" value="#{rcs['diagnostico.codigo']}"></h:outputText>
						    </td>
					  	    <td class="formPaddingData">
					  	    	<h:inputText styleClass="inputText" id="txtPvLoCodigo"
					  	    				 value="#{diagnosticoController.diagnostico.pvStCodigo}" size="22" maxlength="22" >
					  	    	</h:inputText> 
					  	    	<h:message styleClass="error" id="msgTxtCodigo" for="txtPvLoCodigo" errorClass="error" infoClass="info" warnClass="warn"></h:message>
					  	   </td>
					    </tr>
					    <tr>
						  		<td class="Tit04Tabla"> 
						  			<h:outputText styleClass="outputText" id="lblNombre"
									value="#{rcs['diagnostico.nombre']}"></h:outputText>
							    </td>
						  	    <td class="formPaddingData">
						  	    	<h:inputText styleClass="inputText" id="txtPvStNombre"
										value="#{diagnosticoController.diagnostico.pvStNombre}"
										size="50" maxlength="50">
									</h:inputText> <h:message styleClass="error" id="msgTxtNombre" for="txtPvStNombre" errorClass="error" infoClass="info" warnClass="warn"></h:message>
						  	   </td>
						</tr>  
						 
						 <tr>
						  		<td class="Tit04Tabla"> 
						  			<h:outputText styleClass="outputText" id="lblCaspa"
									value="#{rcs['diagnostico.caspa']}"></h:outputText>
							    </td>
						  	    <td class="formPaddingData">
						  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStCaspa" value="#{diagnosticoController.diagnostico.pvStCaspa}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
								   </h:selectOneMenu>
						  	    <h:message styleClass="error" id="msgTxtCaspa" for="txtPvStCaspa" errorClass="error" infoClass="info" warnClass="warn"></h:message>
						  	   </td>
						</tr>  
				  		
					<tr>
				  		<td class="Tit04Tabla"> 
				  			<h:outputText styleClass="outputText" id="lblHongo"
							value="#{rcs['diagnostico.hongo']}"></h:outputText>
					    </td>
				  	    <td class="formPaddingData">
				  	    	<h:inputText styleClass="inputText" id="txtPvStHongo"
								value="#{diagnosticoController.diagnostico.pvStHongo}"
								size="50" maxlength="50">
							</h:inputText> <h:message styleClass="error" id="msgTxtHongo" for="txtPvStHongo" errorClass="error" infoClass="info" warnClass="warn"></h:message>
				  	   </td>
					</tr>  
						
			        <tr>
			            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblTipoAlopecia" value="#{rcs['diagnostico.tipoAlopecia']}"></h:outputText></td>
			            <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvStTipoAlopecia" value="#{diagnosticoController.diagnostico.pvInTipoAlopecia}">
												<f:selectItems value="#{diagnosticoController.tipoAlopeciaItems}"/>
								</h:selectOneMenu>
			                <h:message styleClass="error" id="msgCmbPvInTipoAlopecia" for="cmbPvInTipoAlopecia" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
			            </td>
			        </tr>
			       
			        <tr>
					  		<td class="Tit04Tabla"> 
					  			<h:outputText styleClass="outputText" id="lblPorcentajePerdida"
								value="#{rcs['diagnostico.porcentajePerdida']}"></h:outputText>
						    </td>
					  	    <td class="formPaddingData">
					  	    	<h:inputText styleClass="inputText" id="txtPvDoPorcentajePerdida"
									value="#{diagnosticoController.diagnostico.pvDoPorcentajePerdida}"
									size="5" maxlength="5">
								</h:inputText> <h:message styleClass="error" id="msgTxtPvDoPorcentajePerdida" for="txtPvDoPorcentajePerdida" errorClass="error" infoClass="info" warnClass="warn"></h:message>
					  	   </td>
					</tr>  
				  	
				  	 <tr>
					  		<td class="Tit04Tabla"> 
					  			<h:outputText styleClass="outputText" id="lblDermatitisOleosa"
								value="#{rcs['diagnostico.dermatitisOleosa']}"></h:outputText>
						    </td>
					  	    <td class="formPaddingData">
					  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStDermatitisOleosa" value="#{diagnosticoController.diagnostico.pvStDermatitisOleosa}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
								</h:selectOneMenu>
								<h:message styleClass="error" id="msgTxtPvStDermatitisOleosa" for="txtPvStDermatitisOleosa" errorClass="error" infoClass="info" warnClass="warn"></h:message>
					  	   </td>
					</tr>  
						
					 <tr>
				  		<td class="Tit04Tabla"> 
				  			<h:outputText styleClass="outputText" id="lblDermatitisSeca"
							value="#{rcs['diagnostico.dermatitisSeca']}"></h:outputText>
					    </td>
				  	    <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStDermatitisSeca" value="#{diagnosticoController.diagnostico.pvStDermatitisSeca}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
								</h:selectOneMenu>
				  	        <h:message styleClass="error" id="msgTxtPvStDermatitisSeca" for="txtPvStDermatitisSeca" errorClass="error" infoClass="info" warnClass="warn"></h:message>
				  	   </td>
					</tr> 
					
					 <tr>
				  		<td class="Tit04Tabla"> 
				  			<h:outputText styleClass="outputText" id="lblDermatitisSeborreica"
							value="#{rcs['diagnostico.dermatitisSeborreica']}"></h:outputText>
					    </td>
				  	    <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStDermatitisSeborreica" value="#{diagnosticoController.diagnostico.pvStDermatitisSeborreica}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
							</h:selectOneMenu>
							<h:message styleClass="error" id="msgTxtPvStDermatitisSeborreica" for="txtPvStDermatitisSeborreica" errorClass="error" infoClass="info" warnClass="warn"></h:message>
				  	   </td>
					</tr> 
					
					<tr>
				  		<td class="Tit04Tabla"> 
				  			<h:outputText styleClass="outputText" id="lblDeshidratacion"
							value="#{rcs['diagnostico.deshidratacion']}"></h:outputText>
					    </td>
				  	    <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStDeshidratacion" value="#{diagnosticoController.diagnostico.pvStDeshidratacion}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
							</h:selectOneMenu>
							 <h:message styleClass="error" id="msgTxtPvStDeshidratacion" for="txtPvStDeshidratacion" errorClass="error" infoClass="info" warnClass="warn"></h:message>
				  	   </td>
					</tr> 
					
					
					<tr>
				  		<td class="Tit04Tabla"> 
				  			<h:outputText styleClass="outputText" id="lblPsoriasis"
							value="#{rcs['diagnostico.psoriasis']}"></h:outputText>
					    </td>
				  	    <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStPsoriasis" value="#{diagnosticoController.diagnostico.pvStPsoriasis}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
							</h:selectOneMenu>
				  	    	<h:message styleClass="error" id="msgTxtPvStPsoriasis" for="txtPvStPsoriasis" errorClass="error" infoClass="info" warnClass="warn"></h:message>
				  	   </td>
					</tr> 
			       
			       
			       <tr>
				  		<td class="Tit04Tabla"> 
				  			<h:outputText styleClass="outputText" id="lblTelanocitos"
							value="#{rcs['diagnostico.telanocitos']}"></h:outputText>
					    </td>
				  	    <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="txtPvStTelanocitos" value="#{diagnosticoController.diagnostico.pvStTelanocitos}">
												<f:selectItems value="#{diagnosticoController.tipoSINOItems}"/>
							</h:selectOneMenu>
							 <h:message styleClass="error" id="msgTxtPvStTelanocitos" for="txtPvStTelanocitos" errorClass="error" infoClass="info" warnClass="warn"></h:message>
				  	   </td>
					</tr> 
					
					<tr>
			            <td  class="Tit04Tabla"><h:outputText styleClass="outputText" id="lblEstado" value="#{rcs['diagnostico.estado']}"></h:outputText></td>
			            <td class="formPaddingData">
				  	    	<h:selectOneMenu styleClass="selectOneMenu" id="cmbPvStEstado" value="#{diagnosticoController.diagnostico.pvStEstado}">
												<f:selectItems value="#{diagnosticoController.estadoItems}"/>
								</h:selectOneMenu>
			                <h:message styleClass="error" id="msgCmbPvStEstado" for="cmbPvStEstado" errorClass="error" infoClass="info" warnClass="warn" ></h:message>
			            </td>
			        </tr>
			       <tr>
			            <td colspan="2">
				            <h:commandButton type="submit" value="#{rcs['boton.buscar']}"   styleClass="commandButton" id="btnBuscar"   action="#{diagnosticoController.buscar}"></h:commandButton>
				    
			            </td>
			        </tr>
					</tbody>
				</table>
	
						<br/>
						<h:messages styleClass="messages" id="messages1" globalOnly="true" infoClass="info" errorClass="error" warnClass="warn"/>
						<br/>
						 
					   <h:dataTable border="0" columnClasses="" headerClass="Tit04Tabla"
									footerClass="Tit04Tabla" rowClasses="even,odd"  
									styleClass="dataTable" id="table1"
									value="#{diagnosticoController.listaDiagnostico}" var="dato" rows="20" 
									binding="#{diagnosticoController.listaDataTableDiagnostico}">		
							<h:column id="Columna1">
								<f:facet name="header">
									<h:outputText styleClass="outputText"
										value="#{rcs['diagnostico.codigo']}"
										id="lbl1"></h:outputText>
								</f:facet>
									<h:commandLink styleClass="commandLink" id="link1" action="#{diagnosticoController.cargarObjeto}">
										<h:outputText styleClass="pad-right" id="text1"
											value="#{dato.pvStCodigo}">
										</h:outputText>
										<f:attribute value="center" name="align" />
									</h:commandLink>
							</h:column>
							<h:column id="Columna2">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['diagnostico.nombre']}"
										id="lbl2"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text2"
										value="#{dato.pvStNombre}">					
								</h:outputText>
								<f:attribute value="center" name="align" />
							</h:column>
							<h:column id="Columna3">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['diagnostico.porcentajePerdida']}"
										id="lbl3"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text3"
									value="#{dato.pvDoPorcentajePerdida}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
							<h:column id="Columna4">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['diagnostico.caspa']}"
										id="lbl4"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text4"
									value="#{dato.pvStCaspa}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
							<h:column id="Columna5">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['diagnostico.hongo']}"
										id="lbl5"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text5"
									value="#{dato.pvStHongo}">
								</h:outputText>			
								<f:attribute value="center" name="align" />
							</h:column>		
							
							<h:column id="Columna7">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['diagnostico.estado']}"
										id="lbl7"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="text7"
									value="#{dato.estadoDescripcion}">
								</h:outputText>		
								<f:attribute value="center" name="align" />	
							</h:column>
						<h:column id="colFecha">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['usuario.fechaModificacion']}"
										id="lblColFecha"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="lblFechaModificacion"
										value="#{dato.pvDaModifica}">					
								</h:outputText>
								<f:attribute value="center" name="align" />
							</h:column>

							<h:column id="colUsuario">
								<f:facet name="header">
									<h:outputText styleClass="outputText pad-right"
										value="#{rcs['usuario.usuario']}"
										id="lblColUsuario"></h:outputText>
								</f:facet>			
								<h:outputText styleClass="outputText pad-right" id="lblUsuario"
										value="#{dato.pvObUsuario.pvStDescripcion}">					
								</h:outputText>
								<f:attribute value="center" name="align" />
							</h:column>
							 
						</h:dataTable>
						<t:dataScroller for="table1" fastStep="10" pageCountVar="pageCount"
									pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
									paginatorMaxPages="9" paginatorTableClass="paginator"
									paginatorActiveColumnStyle="font-weight:bold;" immediate="true">
							<f:facet name="first">
								<t:graphicImage url="theme/arrow-first.gif" />
							</f:facet>
							<f:facet name="last">
								<t:graphicImage url="theme/arrow-last.gif" />
							</f:facet>
							<f:facet name="previous">
								<t:graphicImage url="theme/arrow-previous.gif" />
							</f:facet>
							<f:facet name="next">
								<t:graphicImage url="theme/arrow-next.gif" />
							</f:facet>
							<f:facet name="fastforward">
								<t:graphicImage url="theme/arrow-ff.gif" />
							</f:facet>
							<f:facet name="fastrewind">
								<t:graphicImage url="theme/arrow-fr.gif"  />
							</f:facet>
						</t:dataScroller>					
						<div align="left">
							<h:commandButton type="submit" value="#{rcs['boton.agregar']}" styleClass="commandButton" id="btnAgregarBottom" action="#{diagnosticoController.irAgregar}"></h:commandButton>
						</div>
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