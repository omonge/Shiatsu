<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es"><!-- InstanceBegin template="/Templates/plantillaSinMenu.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Content-Type"         content="text/html; charset=ISO-8859-1">
    <meta http-equiv="Content-Style-Type"   content="text/css">
    <meta http-equiv="X-UA-Compatible"      content="IE=EmulateIE7"/> 
	<!-- InstanceBeginEditable name="doctitle" --><title>GICE</title><!-- InstanceEndEditable --> 
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
                    
                </nav>
                <section id="main"> 
                    <div id="titulo" class="Tit_04_naranja">
					<!-- InstanceBeginEditable name="titulo" --><!-- InstanceEndEditable -->
                    </div>
                    <div id="cuerpo" class="Text">
						<!-- InstanceBeginEditable name="contenido" -->
						<form action="j_security_check" method="post" name="form1">
			                <table   background="images/login/login.png" border="0" cellpadding="0" cellspacing="0" width="350" align="center">
			                  <tbody>
			                  <tr>
			                    <td width="158" height="73" border="0" ></td>
			                    <td width="192" height="73" border="0" ></td>
			                  </tr>
			                  
			                  <tr>
			                    <td width="158" height="50" ></td>
			                    <td  width="192" height="50">
			                        <input type="text" name="j_username" size="18" maxlength="20"/>
			                    </td>  
			                  </tr>
			                  
			                  <tr>
			                    <td width="158" height="53" border="0" /></td>
			                    <td width="192" height="53">
			                        <input type="password" name="j_password" size="18" maxlength="20" />
			                    </td>                  
			                  </tr>
			                  
			                  <tr>
			                   <td colspan="2"  width="350" height="74">
			                        <div align="center">
			                            <input name="Submit" type="submit" value="Ingresar" />
			                        </div>
			                   </td>
			                  </tr>
			         
			                  </tbody>
			                </table>
			                <div align="center"><a href="http://prd2.infocom.ice/passwd/" target="_blank">Cambiar Contrase?a</a></div>
			            </form> 
		           
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
