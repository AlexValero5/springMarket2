package com.example.springMarket2.servicios;


import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Respuesta;

public interface RespuestaServicio {
	
	
	public  Respuesta crearRespuesta(String respuesta,Long idUsuario,Pregunta pregunta) ;
	
	public Respuesta obtenerRespuesta(Long id);
	
	public void borrarRespuesta(Long idRespuesta);

}
