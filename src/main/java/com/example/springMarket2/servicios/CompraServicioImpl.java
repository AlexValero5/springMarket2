package com.example.springMarket2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springMarket2.daos.CompraDao;
import com.example.springMarket2.entidades.Compra;
import com.example.springMarket2.entidades.ItemCarrito;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.entidades.Usuario;

@Transactional
@Service
public class CompraServicioImpl implements CompraServicio{
	
	@Autowired CompraDao compradao;
	
	@Autowired UsuarioServicio usuarioservicio;
	
	@Autowired ProductoServicio productoservicio;
	
	@Autowired CompraServicio compraservicio;

	@Override
	public Compra crearCompra(Compra compra) {
		return compradao.crear(compra);
	}

	

	@Override
	public Compra obtenerCompra(Long id) {
		return compradao.buscar(id);
	}

	@Override
	public void borrarCompra(Long id) {
		compradao.borrar(id);
	}



	@Override
	public Compra modificarCompra(Compra compra) {
		return compradao.actualizar(compra);
	}



	@Override
	public Compra comprar(Long idUsuario, List<ItemCarrito> carro) {
		Usuario u=usuarioservicio.obtenerUsuario(idUsuario);
		
		Compra compra=new Compra();
		
		
		if(carro!=null && !carro.isEmpty()) {
			for(ItemCarrito item: carro) {
				Producto p=productoservicio.obtenerProducto(item.getIdProducto());
				p.setCantidadProducto(item.getCantidad());
				compra.anadirProducto(p);
				
			}
			
		}
		
		compra.setUsuario(u);
		Compra c=compraservicio.crearCompra(compra);
		
		
		
		
		return c;
	}



	@Override
	public List borrarCarro(Long idProducto, List<ItemCarrito> carro) {
		List<ItemCarrito> resultado= new ArrayList<ItemCarrito>();
		
		for(ItemCarrito item: carro) {
			if(item.getIdProducto()!=idProducto)
				resultado.add(item);
		}
		return resultado;
		
	}

//	@Override
//	public List<Compra> buscarPorUsuario() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
