package com.example.springMarket2.servicios;

import com.example.springMarket2.entidades.Pregunta;

public interface PreguntaServicio {

	public  Pregunta crearPregunta(String pregunta,Long idUsuario,Long idProducto) ;
	
	public Pregunta obtenerPregunta(Long id);
	
	public void borrarPregunta(Long idPregunta);
		
	
}
