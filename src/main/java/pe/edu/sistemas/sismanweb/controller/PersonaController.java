package pe.edu.sistemas.sismanweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.edu.sistemas.sismanweb.entidades.Persona;
import pe.edu.sistemas.sismanweb.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	List<Persona> listaPersonas;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//@RequestMapping(value="/hola",method=RequestMethod.GET)
	@GetMapping("/listarPersonas")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		listaPersonas = personaService.obtenerPersonas();
		logger.info("Retornando modelo y vista "+ " -- Datos: "+ listaPersonas.size());
		ModelAndView mav = new ModelAndView("personas");		
		mav.addObject("listaPersonas", listaPersonas);        
        return mav;
    }	

}
