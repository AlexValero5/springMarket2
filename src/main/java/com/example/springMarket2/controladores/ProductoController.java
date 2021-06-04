package com.example.springMarket2.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springMarket2.entidades.ItemCarrito;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {
	@Autowired
	ProductoServicio productoService;
	
	
	
	
	@GetMapping("/crear")
	public String showForm() {
		return "producto/crear";
	}
	
	@PostMapping("/crear")
	public String crearProducto(HttpServletRequest request) {
		String nombre = request.getParameter("nombreProducto");
		String descripcion = request.getParameter("descripcionProducto");
		Float precio = Float.parseFloat(request.getParameter("precioProducto"));
		Integer descuento = Integer.parseInt(request.getParameter("descuentoProducto"));
		
		Producto p = new Producto();
		p.setNombreProducto(nombre);
		p.setDescripcionProducto(descripcion);
		p.setPrecioProducto(precio);
		p.setDescuentoProducto(descuento);
		
		Producto prod = productoService.crearProducto(p);
		
		return "redirect:/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProducto(@PathVariable("id") long IdProducto,HttpServletRequest request) {
		ModelAndView m = new ModelAndView();
		Producto p1= productoService.obtenerProducto(IdProducto);
		
		
		m.addObject("producto",p1);
		m.setViewName("/producto/perfil");
		
		return m;
		
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/borrar/{idProducto}")
	public String borrar( @PathVariable("idProducto") long idProducto) {

		productoService.eliminarProducto(idProducto);

		return "redirect:/index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/busqueda")
	public ModelAndView BuscarProducto(@RequestParam(name = "nombre") String nombre,
										HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Producto producto = productoService.listarProductoPorNombre(nombre);

		mav.addObject("producto", producto);
		mav.setViewName("producto/resultado");

		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/agregarProducto/{idProducto}")
	public String agregarAlCarrito( @PathVariable("idProducto") long idProducto,HttpServletRequest request) {
		HttpSession s= request.getSession();
		
		Producto p1= productoService.obtenerProducto(idProducto);
		
		boolean insertado=false;
		
		List<ItemCarrito> l= (List<ItemCarrito>) s.getAttribute("carrito");
		if(l==null) {
			l=new ArrayList<ItemCarrito>();
			
		}
		if(l.isEmpty()) {
			l.add(new ItemCarrito(p1.getIdProducto(), p1.getNombreProducto(), p1.getPrecioProducto(),1));
			insertado=true;
		}
		else 
			for (ItemCarrito itemCarrito : l) {
				if(itemCarrito.getIdProducto()==idProducto) {
					itemCarrito.setCantidad(itemCarrito.getCantidad()+1);
					insertado=true;
					break;
				}
			}
		if (!insertado)
			l.add(new ItemCarrito(p1.getIdProducto(), p1.getNombreProducto(), p1.getPrecioProducto(),1));

			request.getSession().setAttribute("carrito", l);
		
		return "redirect:/producto/perfil/"+idProducto;
	}
}
