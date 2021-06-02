package com.example.springMarket2.servicios;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springMarket2.daos.PreguntaDao;

import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.entidades.Usuario;

@Transactional
@Service
public class PreguntaServicioImpl implements PreguntaServicio{
	
	
	@Autowired PreguntaDao preguntaDao;
	
	@Autowired ProductoServicio productoServicio;

	@Autowired
	private UsuarioServicio usuarioServicio;

	@Override
	public Pregunta crearPregunta(String pregunta, Long idUsuario,Long idProducto) {
		
		Usuario u=usuarioServicio.obtenerUsuario(idUsuario);
		
		Producto product=productoServicio.obtenerProducto(idProducto);
		
		LocalDate fechaPregunta=LocalDate.now();
		
		Pregunta p=new Pregunta(pregunta,fechaPregunta,u,product);
		
		Pregunta persistida=preguntaDao.crear(p);
		
		return persistida;
	}

	@Override
	public Pregunta obtenerPregunta(Long id) {
		Pregunta p=preguntaDao.buscar(id);
		return p;
		
	}

	@Override
	public void borrarPregunta(Long idPregunta) {
		
		preguntaDao.borrar(idPregunta);
		
	}

}
