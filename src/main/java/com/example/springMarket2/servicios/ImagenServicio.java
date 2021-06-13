package com.example.springMarket2.servicios;

import org.springframework.web.multipart.MultipartFile;

import com.example.springMarket2.entidades.Imagen;

public interface ImagenServicio {
	
	public int guardarImagen(Imagen img);
	
	public Imagen obtenerImagen(Long id);
	
	public Boolean actualizarImagen(long idProducto, MultipartFile file);

}
