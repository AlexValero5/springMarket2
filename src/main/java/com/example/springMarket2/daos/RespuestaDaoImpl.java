package com.example.springMarket2.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.Respuesta;

@Repository
@Component("Respuesta")
public class RespuestaDaoImpl extends DaoGenericoImpl<Respuesta> implements RespuestaDao{

	@Override
	public List<Respuesta> listarRespuestasPregunta(Pregunta p) {
		Query query =  this.em.createQuery("FROM Respuesta as p where p.pregunta = :pregunta");
		query.setParameter("pregunta", p);
		List<Respuesta> respuestas =  query.getResultList();

		if (respuestas != null) {
			return respuestas;
		}
		return null;
	}

}
