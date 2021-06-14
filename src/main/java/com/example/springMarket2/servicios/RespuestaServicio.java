package com.example.springMarket2.servicios;


import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Respuesta;

public interface RespuestaServicio {
	
	
	public  Respuesta crearRespuesta(String respuesta,Long idUsuario,Long idPregunta) ;
	
	public Respuesta obtenerRespuesta(Long id);
	
	public void borrarRespuesta(Long idRespuesta);
	
	public Respuesta editarRespuesta(Long idRespuesta, String respuesta);

}
