package com.example.springMarket2.daos;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Producto;


public interface PreguntaDao extends DaoGenerico<Pregunta>{

	public List<Pregunta> listarPreguntas(Producto producto);
}
