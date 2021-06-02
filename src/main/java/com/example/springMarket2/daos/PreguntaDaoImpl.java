package com.example.springMarket2.daos;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Producto;
import javax.persistence.Query;

@Repository
@Component("Pregunta")
public class PreguntaDaoImpl extends DaoGenericoImpl<Pregunta> implements PreguntaDao{

	@Override
	public List<Pregunta> listarPreguntas(Producto p) {
		Query query =  this.em.createQuery("FROM Pregunta as p where p.producto = :producto");
		query.setParameter("producto", p);
		List<Pregunta> preguntas =  query.getResultList();

		if (preguntas != null) {
			return preguntas;
		}
		return null;
	}

}
