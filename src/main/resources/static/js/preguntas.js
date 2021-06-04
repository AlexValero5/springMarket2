$("body").on('click', '#publicarPregunta', publicarPreguntametodo);

function publicarPreguntametodo() {
    var textoPregunta= $('#textoPregunta').val();

    var idProducto = $('#idProducto').val();    


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

            columnaUsuario.appendChild(document.createTextNode(response.nombreUsuario));
            columnaTexto.appendChild(document.createTextNode(textoPregunta));
            columnaFecha.appendChild(document.createTextNode(response.fechaPregunta));

            fila.appendChild(columnaUsuario);
            fila.appendChild(columnaTexto);
            fila.appendChild(columnaFecha);

            $('#tablaPreguntas').append(fila);

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