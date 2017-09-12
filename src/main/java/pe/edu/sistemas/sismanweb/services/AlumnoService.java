package pe.edu.sistemas.sismanweb.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.edu.sistemas.sismanweb.dao.AlumnoDAO;
import pe.edu.sistemas.sismanweb.dao.PersonaDAO;
import pe.edu.sistemas.sismanweb.dao.PlanDAO;
import pe.edu.sistemas.sismanweb.dao.TipoAlumnoDAO;
import pe.edu.sistemas.sismanweb.domain.Alumno;
import pe.edu.sistemas.sismanweb.domain.Persona;
import pe.edu.sistemas.sismanweb.services.modelform.AlumnoModelForm;

@Service
@Transactional
public class AlumnoService {
	
	protected final Log logger = LogFactory.getLog(AlumnoService.class);
	public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	
	@Autowired private AlumnoDAO alumnoDao;	
	@Autowired private PlanDAO planDao;	
	@Autowired private TipoAlumnoDAO tipoAlumnoDao;
	@Autowired private PersonaDAO personaDao;
	
	
	public boolean insertarAlumno(Alumno alumno){
		Persona persona = personaDao.findPersonaByCodigo(alumno.getPersona().getPersonaCodigo());
		if(persona!=null){
			return true;
		}else{
			alumnoDao.save(alumno);
			return false;
		}		
	}
	
	
	public void actualizarAlumno(Alumno alumno){
		alumnoDao.save(alumno);
	}
	
	
	public void eliminarAlumno(Alumno alumno){
		alumnoDao.update(alumno);
	}

	
	public List<Alumno> obtenerAlumnos(){
		List<Alumno> resultado = alumnoDao.findAll();
		for(Alumno alu: resultado){
			alu.getPersona().getPersonaNombre();
		}		
		return resultado;
	}
	
	
	public Alumno obtenerAlumnoxID(Integer idAlumno){
		return alumnoDao.findById(idAlumno);
	}
	
	public List<Alumno> saveBulk(List<AlumnoModelForm> listaAlumnoModel){
		List<Alumno> alumnosExistentes = new ArrayList<Alumno>();
		Alumno alumno = null;
		Boolean existe;
		for(int i=0; i< listaAlumnoModel.size(); i++){
			alumno = converterToAlumno(listaAlumnoModel.get(i));
			existe = insertarAlumno(alumno);
			if(existe){
				alumnosExistentes.add(alumno);
			}			
		}
		return alumnosExistentes;		
	}
	
	
	public Alumno converterToAlumno(AlumnoModelForm formAlumnoModel){
		Alumno alumno = new Alumno();
		Persona persona = new Persona();
		persona.setPersonaCodigo(formAlumnoModel.getCodigo());
		persona.setPersonaAppaterno(formAlumnoModel.getApPaterno());
		persona.setPersonaApmaterno(formAlumnoModel.getApMaterno());
		persona.setPersonaNombre(formAlumnoModel.getNombre());
		persona.setPersonaSexo(formAlumnoModel.getSexo());
		persona.setPersonaDni(formAlumnoModel.getDni());
		persona.setPersonaTelefono(formAlumnoModel.getTelefono());
		persona.setPersonaCorreo(formAlumnoModel.getCorreo());
		persona.setPersonaDireccion(formAlumnoModel.getDireccion());
		persona.setPersonaCodigoSistema(formAlumnoModel.getCodigo());
		persona.setPersonaPasswordSistema(formAlumnoModel.getCodigo());
		persona.setPersonaPasswordSistema2(" ");
		alumno.setPersona(persona);
		alumno.setAlumnoActivo(1);
		alumno.setTipoAlumno(tipoAlumnoDao.findById(1));
		alumno.setPlan(planDao.findById(formAlumnoModel.getIdPlan()));	
		
		return alumno;
	}
	
	
	public AlumnoModelForm converterToAlumnoModelForm(Alumno alumno){
		AlumnoModelForm formAlumnModel = new AlumnoModelForm();
		Persona persona = alumno.getPersona();
		formAlumnModel.setIdPlan(alumno.getPlan().getIdplan());
		formAlumnModel.setNombre(persona.getPersonaNombre());
		formAlumnModel.setApPaterno(persona.getPersonaAppaterno());
		formAlumnModel.setApMaterno(persona.getPersonaApmaterno());
		formAlumnModel.setCodigo(persona.getPersonaCodigo());
		formAlumnModel.setCorreo(persona.getPersonaCorreo());
		formAlumnModel.setDireccion(persona.getPersonaDireccion());
		formAlumnModel.setDni(persona.getPersonaDni());
		formAlumnModel.setSexo(persona.getPersonaSexo());
		formAlumnModel.setTelefono(persona.getPersonaTelefono());
		
		return formAlumnModel;
	
	}
	

	public List<AlumnoModelForm> buscarAlumnosxCod(String codigo){
		AlumnoModelForm formAlumnModel;
		
		List<AlumnoModelForm> alumnosFormCodigo = new ArrayList<AlumnoModelForm>();
		
		List<Alumno> alumnosCodigo = alumnoDao.obtenerAlumnosxCod(codigo);
		
		for(Alumno alumno : alumnosCodigo){
			formAlumnModel = converterToAlumnoModelForm(alumno);
			alumnosFormCodigo.add(formAlumnModel);
		}
		
		return alumnosFormCodigo;
		
	}
	
}
