package pe.edu.sistemas.sismanweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pe.edu.sistemas.sismanweb.entidades.Persona;
import pe.edu.sistemas.sismanweb.services.PersonaService;

@Controller
public class LoginController {
	
	private static final Log logger = LogFactory.getLog(LoginController.class);

	@Autowired
	PersonaService personaService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView responseLogin(){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("persona", new Persona());
		logger.info("-- Retornando vista Login --");
		return mav;
	}

	@RequestMapping(value="/validar",method=RequestMethod.POST)
	public RedirectView validarLogin(@ModelAttribute("persona") Persona persona){
		Persona resultado = personaService.obtenerPersonaXID(4504);
		logger.info("Recibiendo persona: "+persona.getPersonaCodigoSistema()+" -- Se obtuvo una persona :"+resultado.getPersonaCodigoSistema());
		if(!resultado.getPersonaCodigoSistema().equals(persona.getPersonaCodigoSistema())){
			return new RedirectView("/sismanweb/login");			
		}else{			
			return new RedirectView("/sismanweb/home");
		}	
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	
}
