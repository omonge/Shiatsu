<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />

<html lang="es"><!-- InstanceBegin template="/Templates/plantillaPopup.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Content-Type"         content="text/html; charset=ISO-8859-1">
    <meta http-equiv="Content-Style-Type"   content="text/css">
    <meta http-equiv="X-UA-Compatible"      content="IE=EmulateIE7"/> 
	<!-- InstanceBeginEditable name="doctitle" -->
<title>Shiatsu</title>
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
	<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable --> 
</head> 



<f:view locale="es_CR">
<f:loadBundle var="rcs" basename="com.shiatsu.web.bundles.recursos"  />
<body bgcolor="#ffffff">
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">  
   <tr>
   <td colspan="7" valign="top">
   <h2>
   <!-- InstanceBeginEditable name="titulo" -->
   			  <h:outputText styleClass="outputText" value="#{rcs['titulo.diagnostico.popup']}"/> 
   <!-- InstanceEndEditable -->
   </h2>
   </td>
   <td><img src="theme/plantilla/spacer.gif" width="1" height="33" border="0" alt="" /></td>
  </tr>
  <tr height="100%">
   <td colspan="7" valign="top" height="100%"><!-- InstanceBeginEditable name="contenido" -->
   
   
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
									<h:commandLink styleClass="commandLink" id="link1" action="#{diagnosticoController.cargarObjetoPopUp}">
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
   </td>
   </tr>
</table>
</body>
</f:view>
<!-- InstanceEnd --></html>
