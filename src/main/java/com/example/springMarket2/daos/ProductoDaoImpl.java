package com.example.springMarket2.daos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Producto;





@Repository
@Component("ProductoDao")
public class ProductoDaoImpl extends DaoGenericoImpl<Producto> implements ProductoDao{

	@Override
	public List<Producto> buscarPorNombre(String nombreProducto) {
		Query query = this.em.createQuery("FROM Producto u where u.nombreProducto LIKE :nombreProducto");
		query.setParameter("nombreProducto","%"+nombreProducto+"%");
		List<Producto> lProducto = query.getResultList();

		if (lProducto != null) {
			return lProducto;
		}
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		Query query = this.em.createQuery("FROM Producto");
		List<Producto> lProducto = query.getResultList();

		if (lProducto != null) {
			return lProducto;
		}
		return null;
	}
	

}
