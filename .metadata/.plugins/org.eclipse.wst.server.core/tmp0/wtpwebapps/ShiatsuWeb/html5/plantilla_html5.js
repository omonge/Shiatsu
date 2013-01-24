$(document).on("ready", iniciar);
//$(window).unload( cerrar );

function iniciar()
{
    var banner = document.getElementById('tablaBanner');
  	banner.style.height=localStorage.nombreShiatzu;
    
    //$("#btnCierre").click(cierre_contable());
}


function mostrarOcultarTablas(id)
{
    var banner = document.getElementById('tablaBanner');
    if(localStorage.nombreShiatzu=='100px' || localStorage.nombreShiatzu==null)
    {
        banner.style.height='0px'; 
        localStorage.nombreShiatzu='0px';
    }else{
        banner.style.height='100px';
        localStorage.nombreShiatzu='100px';
    }
}

function cerrar()
{
    delete localStorage.nombreShiatzu;
}



function limpiaMessages(){   
   var mensajes = document.getElementsByClassName('error');
   for (var i = 0; i < mensajes.length; i++){
        mensajes[i].innerHTML=" ";
   }
   var mensajes = document.getElementsByClassName('warn');
   for (var i = 0; i < mensajes.length; i++){
        mensajes[i].innerHTML=" ";
   }
   var mensajes = document.getElementsByClassName('info');
   for (var i = 0; i < mensajes.length; i++){
        mensajes[i].innerHTML=" ";
   }
}

function getFocus() {
    var forms = document.forms || [];
        for(var i = 0; i < forms.length; i++){
            for(var j = 0; j < forms[i].length; j++){
                if(!forms[i][j].readonly != undefined && forms[i][j].type != "hidden" && forms[i][j].disabled != true && forms[i][j].style.display != 'none'){
                    forms[i][j].focus();
                    return;
                }
            }
        }
    //<!--document.forms[0].elements[0].focus();-->
}

function mostrarFecha(){
    // Get today's current date.
    var now = new Date();
    
    // Array list of days.
    var days = new Array('Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sabado');
    // Array list of months.
    var months = new Array('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Setiembre','Octubre','Noviembre','Diciembre');
    // Calculate the number of the current day in the week.
    var date = ((now.getDate()<10) ? "0" : "")+ now.getDate();
    // Calculate four digit year.
    function fourdigits(number) {
        return (number < 1000) ? number + 1900 : number;
                                    }
    // Join it all together
    today =  days[now.getDay()] + " " +
             date + " de " +
             months[now.getMonth()] + " " +
             
             (fourdigits(now.getYear())) ;
    
    // Print out the data.
    document.write(today);
}

function logout(){
    if(confirm("¿Esta seguro(a) que desea salir de la aplicación?")){
        //var form = document.getElementById('logout');//document.forms["logout"];
        //form.submit();
        document.forms["logout"].submit();
    }
}

function cierre_contable(){
    if(confirm("Por SEGURIDAD, confirme la ejecución del CIERRE CONTABLE. Para control, debe ingresar la CLAVE de autorización de cierre que previamente le fue notificada cuando se le dio acceso a este proceso. Gracias")){
        //var form = document.getElementById('logout');//document.forms["logout"];
        //form.submit();
        alert("entro");
        document.forms["form1"].submit();
    }
}



