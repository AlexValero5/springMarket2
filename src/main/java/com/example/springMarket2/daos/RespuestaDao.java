package com.example.springMarket2.daos;

import java.util.List;

import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Respuesta;

public interface RespuestaDao extends DaoGenerico<Respuesta>{
	
	public List<Respuesta> listarRespuestasPregunta(Pregunta p);
}
