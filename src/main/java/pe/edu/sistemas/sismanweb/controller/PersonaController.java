package pe.edu.sistemas.sismanweb.controller;

import java.io.IOException;

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
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	Persona persona;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//@RequestMapping(value="/hola",method=RequestMethod.GET)
	@GetMapping("/hola")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		persona = personaService.obtenerPersonaXID(1);
		logger.info("Returning hello view"+ "-- Datos: "+ persona.getPersonaNombre());
		ModelAndView mav = new ModelAndView("contacts");		
		mav.addObject("persona", persona);        
        return mav;
    }	

}
