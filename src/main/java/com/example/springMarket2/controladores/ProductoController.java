package com.example.springMarket2.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {
	@Autowired
	ProductoServicio productoService;
	
	@RequestMapping(method= RequestMethod.GET, value = "lista")
	public ModelAndView listarProductos() {
		ModelAndView mav = new ModelAndView();
		
		List<Producto> lProducto = productoService.listarProductos();
		mav.addObject("productos", lProducto);
		mav.setViewName("producto/lista");
		return mav;
	}
	
	
	@GetMapping("/crear")
	public String showForm() {
		return "producto/crear";
	}
	
	@PostMapping("/crear")
	public String crearProducto(HttpServletRequest request) {
		String nombre = request.getParameter("nombreProducto");
		String descripcion = request.getParameter("descripcionProducto");
		String precio = request.getParameter("precioProducto");
		String descuento = request.getParameter("descuentoProducto");
		
		Producto p = new Producto();
		p.setNombreProducto(nombre);
		p.setDescripcionProducto(descripcion);
		p.setPrecioProducto(Long.parseLong(precio));
		p.setDescuentoProducto(Long.parseLong(descuento));
		
		Producto prod = productoService.crearProducto(p);
		
		return "redirect:/producto/lista";
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProducto(@PathVariable("id") long IdProducto,HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		Producto p1= productoService.obtenerProducto(IdProducto);
		
		
		m.addObject("producto",p1);
		m.setViewName("/producto/perfil");
		
		return m;
		
		
	}
}
