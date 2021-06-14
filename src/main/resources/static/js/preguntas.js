$("body").on('click', '#publicarPregunta', publicarPreguntametodo);

 
$("body").on('click', '#botonResponder', botonParaResponder);
$("body").on('click', '#botonParaEditar', botonParaResponder);

$("body").on('click', '#borraRespuesta', borrarRespuesta);

$("body").on('click', '#botonRespuesta', publicarRespuestametodo);
$(document).ready(function() {
	var boton= document.getElementsByClassName('btn-danger');

    	for (var i = 0 ; i < boton.length; i++) {
    		boton[i].addEventListener('click' , borrarPreguntaMetodo , false ) ; 
    	}
});


/////////////////////////////////////////////////////////////////////////
function publicarPreguntametodo() {
    var textoPregunta= $('#textoPregunta').val();
    
	$('#textoPregunta').val('');
	
    var idProducto = $('#idProducto').val();   
    
    if (textoPregunta == "") {
		return document.location.reload(true);
	} 


    var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
	});


    var cuerpo= {
        "textoPregunta" : textoPregunta,    
        "idProducto" : idProducto
    }


    $.ajax({
		url: "/pregunta/crearPregunta/",
		contentType: "application/json;charset=utf-8",
        dataType:"json",
		data: JSON.stringify(cuerpo),
		type: "POST",
		success: function(response){
		
		

            
            var fila=document.createElement("tr");
            var columnaUsuario=document.createElement("td");
            var columnaFecha=document.createElement("td");
            var columnaTexto=document.createElement("td");
            var columnaOpciones=document.createElement("td");
            var respuestas=document.createElement("td");
            var formulario = document.createElement("div");
            var botonResponder=document.createElement("button");
            var divRespuesta=document.createElement("div");
            var textoRespuesta=document.createElement("textarea");
            var confirmarRespuesta=document.createElement("button");
            var idOculto=document.createElement("td");
            
            var lista=document.createElement("ul");
            var listaLi=document.createElement("li");
            var listaUsuario=document.createElement("span");
            var listaTexto=document.createElement("span");
            var listaFecha=document.createElement("span");
            var listaOpciones=document.createElement("span");
            
            
            
            listaUsuario.appendChild(document.createTextNode("Usuarios"));
            listaTexto.appendChild(document.createTextNode(" Respuesta"));
            listaFecha.appendChild(document.createTextNode(" FechaRespuesta"));
            listaOpciones.appendChild(document.createTextNode(" Opciones"));
            
            respuestas.id="Respuesta"+response.idPregunta;
            
            lista.style="padding:0.5em";
            listaUsuario.style="padding;0.5em";
            
            
            
            
            
            var borrarPregunta=document.createElement("button");
            var divBoton=document.createElement("div");
            
	         divRespuesta.style.display="none";
            textoRespuesta.id = "textoRespuesta";
			textoRespuesta.name = "textoRespuesta";
			
			fila.id=response.idPregunta;
			
			confirmarRespuesta.type= "button";
			confirmarRespuesta.id = "botonRespuesta";
			confirmarRespuesta.classList="btn btn-primary";
			confirmarRespuesta.value=response.idPregunta;
			
			
			
			
			borrarPregunta.id="borraPregunta";
			borrarPregunta.classList="btn btn-danger";
			borrarPregunta.value= response.idPregunta;
            
            
             botonResponder.type="button";
            botonResponder.id = "botonResponder";
            botonResponder.classList="btn btn-primary";
            
			borrarPregunta.appendChild(document.createTextNode("Borrar"));
			
            columnaUsuario.appendChild(document.createTextNode(response.nombreUsuario));
            columnaTexto.appendChild(document.createTextNode(textoPregunta));
            columnaFecha.appendChild(document.createTextNode(response.fechaPregunta));
            confirmarRespuesta.appendChild(document.createTextNode("Confirmar"));
            
            botonResponder.appendChild(document.createTextNode("Responder"));
            
            divRespuesta.appendChild(textoRespuesta);
            divRespuesta.appendChild(confirmarRespuesta);
            
            listaLi.appendChild(listaUsuario);
            listaLi.appendChild(listaTexto);
            listaLi.appendChild(listaFecha);
            listaLi.appendChild(listaOpciones);
            
            lista.appendChild(listaLi); 
            respuestas.appendChild(lista);
            
           	divBoton.appendChild(borrarPregunta);
			formulario.appendChild(botonResponder);
			formulario.appendChild(divRespuesta);
			formulario.appendChild(divBoton);
			columnaOpciones.appendChild(formulario);
            fila.appendChild(columnaUsuario);
            fila.appendChild(columnaTexto);
            
            fila.appendChild(columnaFecha);
            
            fila.appendChild(columnaOpciones);
            fila.appendChild(respuestas);
            
           
           
           
           

            $('#tablaPreguntas').append(fila);
            
            
            var boton= document.getElementsByClassName('btn-danger');
    	for (var i = 0 ; i < boton.length; i++) {
    		boton[i].addEventListener('click' , borrarPreguntaMetodo , false ) ; 
    	}
            
            

        },
        error: function(xhr, status, error) {
/*
		var alerta =
		"<div class='alert alert-danger' role='alert'>" +
		"Error" +
		"</div>";

			$('#preguntaError').html(alerta);*/
        }

    });
};

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

function borrarPreguntaMetodo(){

	var idPregunta = $(this).val();
	
    var obj = $(this);
    


    var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
	});


    var cuerpo= {
        "idPregunta": idPregunta
    }


    $.ajax({
		url: "/pregunta/borrarPregunta/",
		contentType: "application/json;charset=utf-8",
        dataType:"json",
		data: JSON.stringify(cuerpo),
		type: "POST",
		success: function(response){
		
           			$(obj).closest("tr").remove();
           
//			 $(this).parent("tr_padre").remove();
            
          
				
            	
            

        },
        error: function(xhr, status, error) {

		/*var alerta =
		"<div class='alert alert-danger' role='alert'>" +
		"Error" +
		"</div>";

			$('#preguntaError').html(alerta);*/
        }

    });
	

};

//////////////////////////////////////////////////////////////////////////////////////

function botonParaResponder() {

$(this).next().toggle();

}

//////////////////////////////////////////////////////////////////////////////////////

function publicarRespuestametodo() {


    var idPregunta = $(this).val();
	var textoRespuesta = $(this).prev().val();    
	$(this).prev().val('');   
	
	 if (textoRespuesta == "") {
		return document.location.reload(true);
	}  


    var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
	});


    var cuerpo= {
        "textoRespuesta" : textoRespuesta,    
        "idPregunta" : idPregunta
    }


    $.ajax({
		url: "/respuesta/publicarRespuesta/",
		contentType: "application/json;charset=utf-8",
        dataType:"json",
		data: JSON.stringify(cuerpo),
		type: "POST",
		success: function(response){
			
			var ul=document.createElement("ul");
           var fila = document.createElement("li");
			var usuario = document.createElement("span");
			var texto = document.createElement("span");
			var fecha = document.createElement("span");
			var opciones=document.createElement("span");
			
			var spanEditar=document.createElement("span");
			var textareaEditar=document.createElement("textarea");
			textareaEditar.id="textoEditarRespuesta";
			textareaEditar.name="textoEditarRespuesta";
			spanEditar.style.display="none";
			
			var botonParaEditar=document.createElement("button");
			var botonBorraRespuesta=document.createElement("button");
			var botonConfirmarEdicion=document.createElement("button");
			botonParaEditar.id="botonParaEditar";
			botonBorraRespuesta.type="button";
			botonBorraRespuesta.classList="botRespuesta";
			botonBorraRespuesta.id="borraRespuesta";
			botonBorraRespuesta.value=response.idRespuesta;
			botonConfirmarEdicion.value=response.idRespuesta;
			
			
			botonBorraRespuesta.type="button";
			botonConfirmarEdicion.classList="btn btn-primary";
			botonParaEditar.classList="btn btn-primary";
			
			botonParaEditar.appendChild(document.createTextNode("Editar"));
			botonBorraRespuesta.appendChild(document.createTextNode("Borrar"));
			botonConfirmarEdicion.appendChild(document.createTextNode("Aceptar"));
			
			
			spanEditar.appendChild(textareaEditar);
			spanEditar.appendChild(botonConfirmarEdicion);
			
			opciones.appendChild(botonBorraRespuesta);
			opciones.appendChild(botonParaEditar);
			opciones.appendChild(spanEditar);
			
			
			usuario.appendChild(document.createTextNode(response.nombreUsuario));
			texto.appendChild(document.createTextNode(" " +textoRespuesta));
			fecha.appendChild(document.createTextNode(" " +response.fechaRespuesta));
           
           fila.appendChild(usuario);
           fila.appendChild(texto);
           fila.appendChild(fecha);
           fila.appendChild(opciones);
           
           ul.appendChild(fila);
           
           
           $('#Respuesta'+response.idPregunta).append(ul);
           
            
            
            

        },
        error: function(xhr, status, error) {

		var alerta =
		"<div class='alert alert-danger' role='alert'>" +
		"Error" +
		"</div>";

			$('#preguntaError').html(alerta);
        }

    });
};

////////////////////////////////////////////////////////////////////////////////////////////////

function borrarRespuesta() {

	var idRespuesta = $(this).val();
	var obj=$(this);

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var cuerpo = {
		"idRespuesta": idRespuesta
	};

	$.ajax({
		url: "/respuesta/borrarRespuesta/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(cuerpo),
		type: "POST",
		success: function(response) {

			obj.closest("ul").remove();
			
			
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#PreguntaError').html(alerta);
		}

	});
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////

function editarRespuesta() {

	var idRespuesta = $(this).val();
	var obj=$(this);

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var cuerpo = {
		"idRespuesta": idRespuesta
	};

	$.ajax({
		url: "/respuesta/borrarRespuesta/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(cuerpo),
		type: "POST",
		success: function(response) {

			obj.closest("ul").remove();
			
			
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#PreguntaError').html(alerta);
		}

	});
}
