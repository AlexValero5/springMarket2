package com.example.springMarket2.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springMarket2.entidades.Pregunta;
import com.example.springMarket2.entidades.PreguntaDTO;
import com.example.springMarket2.entidades.Producto;
import com.example.springMarket2.servicios.PreguntaServicio;
import com.example.springMarket2.servicios.ProductoServicio;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class PreguntaRespuestaController {
	
	@Autowired PreguntaServicio preguntaServicio;
	
	@Autowired ProductoServicio productoServicio;
	
	@RequestMapping(value="/pregunta/crearPregunta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PreguntaDTO publicarPregunta(@RequestBody JsonNode values,HttpServletRequest request) {
		
		HttpSession s= request.getSession();
		
		Long idUsuario=(Long) s.getAttribute("idUsuario");
		
		String textoPregunta=values.findValue("textoPregunta").asText();
		
		Long idProducto=values.findValue("idProducto").asLong();
		
		
		Pregunta preg=preguntaServicio.crearPregunta(textoPregunta, idUsuario, idProducto);
		
		PreguntaDTO pdto = new PreguntaDTO(preg.getIdPregunta(), preg.getTextoPregunta(), preg.getFechaPregunta(), preg.getUsuario().getIdUsuario(), preg.getProducto().getIdProducto(),preg.getUsuario().getNombre());
		
		
		return pdto;
		
	}
	
	
	

}
