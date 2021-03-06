package com.example.springMarket2.servicios;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springMarket2.daos.ImagenRepository;
import com.example.springMarket2.daos.ProductoDao;
import com.example.springMarket2.daos.UsuarioDao;
import com.example.springMarket2.entidades.Imagen;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.entidades.Usuario;
@Transactional
@Service
public class ImagenServicioImpl  implements ImagenServicio{
	
	@Autowired
	private ImagenRepository imagenRepository;

	@Autowired
	private ProductoDao productoDao;

	public int guardarImagen(Imagen img) {
		try {
			imagenRepository.save(img);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public Imagen obtenerImagen(Long id) {
		Imagen findById = imagenRepository.findById(id).orElse(null);
		
		if (findById != null) {
			Imagen getImageDetails = findById;
			return findById;
		} else {
			return null;
		}
	}

	public Boolean actualizarImagen(long idProducto, MultipartFile file) {

		Producto p = productoDao.buscar(idProducto);

		if (p == null)
			return false;
		try {
			byte[] image = file.getBytes();
            if (p.getImagen() != null) {

                Imagen linkedimg = p.getImagen();
                linkedimg.setImagen(image);
                p.setImagen(linkedimg);
                productoDao.actualizar(p);
                return true;
				
				

			} else {
				Imagen img = new Imagen("foto", image);
				p.anadirImagen(img);
				productoDao.actualizar(p);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}



}
