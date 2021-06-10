package com.example.springMarket2.servicios;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springMarket2.daos.RespuestaDao;
import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.entidades.Respuesta;
import com.example.springMarket2.entidades.Usuario;

@Transactional
@Service
public class RespuestaServicioImpl implements RespuestaServicio{
	
	@Autowired RespuestaDao respuestaDao;
	
	@Autowired UsuarioServicio usuarioServicio;
	
	@Autowired PreguntaServicio preguntaServicio;

	@Override
	public Respuesta crearRespuesta(String respuesta, Long idUsuario, Long idPregunta) {
		
		Usuario u=usuarioServicio.obtenerUsuario(idUsuario);
		
		Pregunta p=preguntaServicio.obtenerPregunta(idPregunta);
		
		LocalDate fechaPregunta=LocalDate.now();
		
		Respuesta r=new Respuesta(respuesta,fechaPregunta,p,u);
		
		Respuesta persistida=respuestaDao.crear(r);
		
		return persistida;
	}

	@Override
	public Respuesta obtenerRespuesta(Long id) {
		Respuesta r=respuestaDao.buscar(id);
		return r;
	}

	@Override
	public void borrarRespuesta(Long idRespuesta) {
		respuestaDao.borrar(idRespuesta);
		
	}

}
