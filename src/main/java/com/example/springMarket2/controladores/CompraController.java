package com.example.springMarket2.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springMarket2.entidades.Compra;
import com.example.springMarket2.entidades.ItemCarrito;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.entidades.Usuario;
import com.example.springMarket2.servicios.CompraServicio;
import com.example.springMarket2.servicios.ProductoServicio;
import com.example.springMarket2.servicios.UsuarioServicio;

@Controller
@RequestMapping(value = "/compra")
public class CompraController {
	
	@Autowired CompraServicio compraservicio;
	
	@Autowired UsuarioServicio usuarioservicio;
	
	@Autowired ProductoServicio productoservicio;
	
	@RequestMapping(method = RequestMethod.GET, value = "/carritoCompra")
	public ModelAndView mostrarCarrito(HttpServletRequest request) {
		
		HttpSession s= request.getSession();
		
		Long id= (Long) s.getAttribute("idUsuario");
		
		Usuario u1= usuarioservicio.obtenerUsuario(id);
		
		List<ItemCarrito> l= (List<ItemCarrito>) s.getAttribute("carrito");
		
		ModelAndView mav= new ModelAndView();
		
		mav.addObject("carrito",l);
		mav.setViewName("compra/carritoCompra");
		
		return mav;
	}

		
		@RequestMapping(method = RequestMethod.GET, value="/finalizarCompra")
		public String comprar(HttpServletRequest request) {
			Compra compra=new Compra();
			
			
			
			HttpSession s = request.getSession();
			
			Long id=(Long) s.getAttribute("idUsuario");
			
			List<ItemCarrito> carro=(List<ItemCarrito>) s.getAttribute("carrito");
			
			if(carro!=null) {
			
			compra=compraservicio.comprar(id, carro);
			
			List<ItemCarrito> vacio=new ArrayList<ItemCarrito>();
			
			s.setAttribute("carrito", vacio);
			
			return "redirect:/compra/misCompras"; 
			}
			else return "redirect:/index";
			
			
			
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/eliminarProductoCarro/{idProducto}")
		public String eliminarProductoCarro(HttpServletRequest request, @PathVariable("idProducto") long idProducto) {
			
			HttpSession s =request.getSession();
			
			List<ItemCarrito> carro= (List<ItemCarrito>) s.getAttribute("carrito");
			
			
			
			List<ItemCarrito> resultado=compraservicio.borrarCarro(idProducto, carro);
			
			s.setAttribute("carrito", resultado);
			
			return "redirect:/compra/carritoCompra";
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/misCompras")
		public ModelAndView mostrarCompras(HttpServletRequest request) {
			
			HttpSession s = request.getSession();
			
			Usuario u = usuarioservicio.obtenerUsuario((long) s.getAttribute("idUsuario"));
			
			
			ModelAndView mav= new ModelAndView();
			
			mav.addObject("compras",u.getCompras());
			mav.addObject("usuario",u);
			mav.setViewName("/compra/misCompras");
			
			return mav;
			
		}
		
		@RequestMapping(method= RequestMethod.GET, value = "/productosCompra/{idCompra}")
		public ModelAndView mostrarProductosCompra(@PathVariable("idCompra") long idCompra) {
			
			Compra c=compraservicio.obtenerCompra(idCompra);
			
			ModelAndView mav=new ModelAndView();
			
			mav.addObject("productosCompra",c.getProductos());
			mav.setViewName("/compra/perfilCompra");
			
			return mav;
			
		}
		
		
	}


