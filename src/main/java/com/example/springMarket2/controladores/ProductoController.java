package com.example.springMarket2.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
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
import com.example.springMarket2.entidades.Rol;
import com.example.springMarket2.entidades.Usuario;
import com.example.springMarket2.servicios.ProductoServicio;
import com.example.springMarket2.servicios.UsuarioServicio;
import com.mysql.cj.Session;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {
	@Autowired
	ProductoServicio productoService;
	
	@Autowired 
	UsuarioServicio usuarioServicio;
	
	
	
	
	@GetMapping("/crear")
	public String showForm(HttpServletRequest request) {
		
		HttpSession s=request.getSession();
		Usuario u = usuarioServicio.obtenerUsuario((long) s.getAttribute("idUsuario"));
		boolean esAdmin=false;
		for (Rol r : u.getRoles())
            if (r.getNombreRol().equals("ROL_ADMIN"))
                esAdmin = true;

        if (esAdmin)
            return "/producto/crear";
        else
            return "redirect:/index";
		
	}
	
	@PostMapping("/crear")
	public String crearProducto(HttpServletRequest request) {
		
		HttpSession s=request.getSession();
		Usuario u = usuarioServicio.obtenerUsuario((long) s.getAttribute("idUsuario"));
		boolean esAdmin=false;
		for (Rol r : u.getRoles())
            if (r.getNombreRol().equals("ROL_ADMIN"))
                esAdmin = true;
		
		if(esAdmin) {
			
		
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
			
			return "redirect:/producto/perfil/" + p.getIdProducto();
		}
		else
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
		List<Producto> lProducto = productoService.listarProductoPorNombre(nombre);

		mav.addObject("productos", lProducto);
		mav.setViewName("index");

		return mav;
	}
	

	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/agregarProducto/{idProducto}")
	public String agregarAlCarrito( @PathVariable("idProducto") long idProducto,HttpServletRequest request) {
		HttpSession s= request.getSession();
		
		if (s.getAttribute("idUsuario") == null)
			return "redirect:/login";
		
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
