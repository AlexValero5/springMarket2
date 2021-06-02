package com.example.springMarket2.daos;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Compra;
import com.example.springMarket2.entidades.Usuario;


@Repository
@Component("CompraDao")
public class CompraDaoImpl extends DaoGenericoImpl<Compra> implements CompraDao  {
	
	
	@Override
	public List<Compra> listar() {
		Query query = (Query) this.em.createQuery("FROM Compra");
		List<Compra> c = query.getResultList();
		return c;
	}
//	@Override
//	public List<Compra> buscarPorUsuario(Usuario usuario) {
//		Query query = this.em.createQuery("select u FROM Compra u where u.usuario =  :usuario");
//		query.setParameter("usuario", usuario);
//		
//		List<Compra> c = query.getResultList();
//		return c;
//
//	}

}
