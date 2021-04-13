package com.example.springMarket2.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springMarket2.daos.ProductoDao;
import com.example.springMarket2.entidades.Producto;



@Transactional
@Service
public class ProductoServiceImpl implements ProductoServicio {

	@Autowired
	private ProductoDao productoDao;
	@Override
	public Producto crearProducto(Producto producto) {
		return productoDao.crear(producto);
	}

	@Override
	public void eliminarProducto(long idProducto) {
		productoDao.borrar(idProducto);
		
	}

	@Override
	public Producto obtenerProducto(long idProducto) {
		return productoDao.buscar(idProducto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		productoDao.actualizar(producto);
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		return productoDao.listarProductos();
	}
	
	@Override
	public List<Producto> listarProductoPorNombre(String nombre) {
		return productoDao.buscarPorNombre(nombre);
	}

}
