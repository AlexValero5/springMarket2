package com.example.springMarket2.servicios;

import java.util.List;

import com.example.springMarket2.entidades.Producto;



public interface ProductoServicio {
	public Producto crearProducto(Producto producto);
	
	public void eliminarProducto(long idProducto);
	
	public Producto obtenerProducto(long idProducto);
	
	public Producto modificarProducto(Producto producto);
	
	

	public List<Producto> listarProductos();
	
	public List<Producto> listarProductoPorNombre(String nombre);
}
