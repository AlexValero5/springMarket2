package com.example.springMarket2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.servicios.ProductoServicio;
@Controller
public class IndexController {
	
	@Autowired
	ProductoServicio productoService;
	
	
//	@GetMapping({ "/", "index" })
//	public String index() {
//		return "index";
//
//	}
	
	
	@RequestMapping(method= RequestMethod.GET, value = { "/", "index" })
	public ModelAndView listarProductos() {
		ModelAndView mav = new ModelAndView();
		
		List<Producto> lProducto = productoService.listarProductos();
		mav.addObject("productos", lProducto.subList(0, 8));
		mav.setViewName("index");
		return mav;
	}

	
	
	

}
