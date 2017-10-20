package pe.edu.sistemas.sismanweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.edu.sistemas.sismanweb.domain.Docente;
import pe.edu.sistemas.sismanweb.domain.Persona;
import pe.edu.sistemas.sismanweb.services.CategoriaDocenteService;
import pe.edu.sistemas.sismanweb.services.ClaseDocenteService;
import pe.edu.sistemas.sismanweb.services.DepartamentoAcademicoService;
import pe.edu.sistemas.sismanweb.services.DocenteService;
import pe.edu.sistemas.sismanweb.services.PersonaService;
import pe.edu.sistemas.sismanweb.services.modelform.DocenteModelForm;
import pe.edu.sistemas.sismanweb.util.DeserealizarJSON;
import pe.edu.sistemas.sismanweb.util.Search;
import pe.edu.sistemas.sismanweb.util.VariablesGlobales;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	protected final Log logger = LogFactory.getLog(DocenteController.class);
	
	@Autowired DocenteService docenteService;		
	@Autowired CategoriaDocenteService categoriaDocenteService;	
	@Autowired ClaseDocenteService claseService;	
	@Autowired DepartamentoAcademicoService departamentoAcademicoService;	
	@Autowired PersonaService personaService;
	
	List<DocenteModelForm> docentes = new ArrayList<DocenteModelForm>();
	
	@ModelAttribute("modulo")
	public String modulo(){
		return "docente/docente";
	}
	
	
	@GetMapping("/all")
	public String verDocentes(Model model){
		model.addAttribute("fragmento","contentDocenteBuscador");
		model.addAttribute("search", new Search());
		model.addAttribute("listaDocente", docentes);
		logger.info("SE DEVUELVEN DOCENTES : " + docentes.size());
		docentes=new ArrayList<DocenteModelForm>();
		return VariablesGlobales.LAYOUT;	
	}
	
	@GetMapping({"/form","/form/{id}"})
	public String formularioDocente(Model model,@RequestParam(name="existe",required=false) String existe,
			@PathVariable(name="id",required=false)String id){
		model.addAttribute("fragmento","contentDocenteIndividual");
		model.addAttribute("clasesDoc",claseService.obtenerClasesDeDocentes());
		model.addAttribute("categoriasDoc",categoriaDocenteService.obtenerCategorias());
		model.addAttribute("depAcadDoc",departamentoAcademicoService.obtenerDepAcademicos());
		
		if(id!=null){
			DocenteModelForm docenteModel;
			logger.info("EDITAR DOCENTE CON ID: "+id);
			docenteModel = docenteService.converterToDocenteModelForm((docenteService.obtenerDocenteXID(Integer.parseInt(id))));
			model.addAttribute("docente", docenteModel);
		}else{
			model.addAttribute("docente", new DocenteModelForm());
		}
		model.addAttribute("existe", existe);
		
		logger.info("RETORNANDO FORMULARIO DOCENTE");
		return VariablesGlobales.LAYOUT;
	}
	
	
	@PostMapping("/add")
	public String agregarDocente(@ModelAttribute("docente") DocenteModelForm docentePersonaModel){	
		Docente docente = docenteService.converterToDocente(docentePersonaModel);
		logger.info("AGREGANDO DATOS DE: "+ docentePersonaModel.getCodigo()+" -- IDDOCENTE:"+docentePersonaModel.getIdDocente()+" -- IDPERSONA:"+docentePersonaModel.getIdPersona());
		logger.info("AGREGANDO DATOS DE: CATEGORIA: "+ docentePersonaModel.getIdCategoria()+" -- CLASE:"+docentePersonaModel.getIdClase()+" -- DEPACAD:"+docentePersonaModel.getIdDepAcad());
		boolean existe;
		if(docentePersonaModel.getIdDocente()==0){
			existe = docenteService.insertarDocente(docente);
			if(existe){
				logger.info("AGREGAR DOCENTE --- Codigo ya existente");
				return "redirect:/docente/form?existe";
			}
			logger.info("DOCENTE AGREGADO");
		}else{
			Persona persona_codigo = personaService.obtenerPersonaxCodigo(docente.getPersona().getPersonaCodigo());
			existe = docenteService.actualizarDocente(docente, persona_codigo);
			if(existe){
				logger.info("LA ACTUALIZACION NO PROCEDE");
				return "redirect:/docente/form/"+docente.getIddocente()+"?existe";
			}else{
				logger.info("DOCENTE ACTUALIZADO");
				return "redirect:/docente/form";
			}
		}		
		return "redirect:/docente/all";	
	}
	
	@GetMapping("/bulk")
	public String bulkDocentes(Model model){
		model.addAttribute("fragmento", "contentDocenteGrupal");
		logger.info("RETORNANDO VISTA CARGA MASIVA -- DOCENTE");
		return VariablesGlobales.LAYOUT;		
	}
	
	@PostMapping("/addBulk")
	public String agregarDocentes(@RequestBody String listDocente ){
		logger.info("CADENA RECIBIDA: "+listDocente);		
		JSONArray jsonArrayDocente = new JSONArray(listDocente);
		DeserealizarJSON<DocenteModelForm> deserealizador = new DeserealizarJSON<DocenteModelForm>(DocenteModelForm.class);
		List<DocenteModelForm> docentesModel = null;
		List<Docente> resultado = null;
		logger.info("CANTIDAD DE REGISTROS: "+jsonArrayDocente.length());
		
		docentesModel = deserealizador.deserealiza(jsonArrayDocente);
		
		if(jsonArrayDocente.length()!=docentesModel.size()){
			logger.error("ENVIANDO MENSAJE DE ERROR EN REGISTRO: "+(docentesModel.size()+1));
			//mav.addObject("errorRegistro", DocentesModel.size()+1);
		}else{
			resultado = docenteService.saveBulk(docentesModel);
			if(!resultado.isEmpty()){
				logger.warn("EXISTEN "+resultado.size()+" DOCENTES YA REGISTRADOS");
				//mav.addObject("errorExiste",resultado.size());
			}else{
				logger.info("SE REGISTRO EXITOSAMENTE DOCENTES");
				//mav.addObject("exito");
			}				
		}	
		
		return "redirect:/docente/all";
	}	
	
	
	@GetMapping("/search")
	public String BuscarDocentes(@ModelAttribute("search") Search search){
			
		docentes = docenteService.buscarDocentesxParam(search.getValor(),search.getFiltro());
		logger.info("SE ENCONTRO DocenteS: " + docentes.size());
		return "redirect:/docente/all";
	}

}
