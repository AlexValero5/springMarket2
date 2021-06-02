package com.example.springMarket2.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.entidades.Usuario;
import com.example.springMarket2.servicios.UsuarioServicio;

@Controller
public class LoginController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UsuarioServicio userServicio;
	
	@GetMapping("/registro")
	public String showForm() {
		return "usuario/crear";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	@PostMapping("/login")
//	public boolean loguearse(HttpServletRequest request) {
//		
//	 Boolean logueado=false;
//	 
//	 String username = request.getParameter("username");
//	 String contraseña = request.getParameter("contraseña");
//	 
//		
//	 Usuario u1=userServicio.buscarUsuario(username);
//	 u1.setContraseña(bCryptPasswordEncoder.encode(u1.getContraseña()));
//	 
//	 String hasheada = u1.getContraseña();
//	 String nombreUsuario=u1.getUsername();
//	 
//	 
//	 
//	 
//		
//		
//		return logueado;
//	}

	
	@PostMapping("/registro")
	public String crearUsuario(HttpServletRequest request) {

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String username = request.getParameter("username");
		String direccionemail = request.getParameter("email");
		String password = request.getParameter("password");
		String direccion = request.getParameter("direccionFacturacion");
		String fecha = request.getParameter("fechaNac");
		Integer tarjeta = Integer.parseInt(request.getParameter("numeroTarjeta"));
		Integer csv = Integer.parseInt(request.getParameter("codigoSeguridad"));
		
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setUsername(username);
		u.setContraseña(password);
		u.setEmail(direccionemail);
		u.setCodigoSeguridad(csv);
		u.setDireccionFacturacion(direccion);
		u.setFechaNac(fecha);
		u.setNumeroTarjeta(tarjeta);
	
		userServicio.crearUsuario(u);
		

		return "redirect:index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/usuario/{idUsuario}")
	public ModelAndView mostrarPerfil( @PathVariable("idUsuario") long idUsuario) {

		ModelAndView mav = new ModelAndView();
		
		Usuario u= userServicio.obtenerUsuario(idUsuario);

		mav.addObject("usuario", u);
		mav.setViewName("usuario/perfil");

		return mav;
	}
}
