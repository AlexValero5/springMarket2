package com.example.springMarket2.daos;

import java.util.List;

import com.example.springMarket2.entidades.Producto;




public interface ProductoDao extends DaoGenerico<Producto>{
	
	public List<Producto> buscarPorNombre(String nombreProducto);
	
	public List<Producto> listarProductos();


}
