package com.example.springMarket2.servicios;

import java.util.List;

import com.example.springMarket2.entidades.Compra;
import com.example.springMarket2.entidades.ItemCarrito;

public interface CompraServicio {
	
	public Compra crearCompra(Compra compra);
	
	public Compra obtenerCompra(Long id);
	
	//public List<Compra> buscarPorUsuario(Long id);
	
	public void borrarCompra(Long id);
	
	public Compra modificarCompra(Compra compra);
	
	public Compra comprar(Long idUsuario,List<ItemCarrito> carro);
	
	public List borrarCarro(Long idProducto,List<ItemCarrito> carro);
	
}
