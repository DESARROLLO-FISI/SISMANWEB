package PruebasPersistencia;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.edu.sistemas.sismanweb.dao.CursoBaseDAO;
import pe.edu.sistemas.sismanweb.dao.CursoConjuntoDAO;
import pe.edu.sistemas.sismanweb.entidades.CursoBase;
import pe.edu.sistemas.sismanweb.entidades.CursoConjunto;
import pe.edu.sistemas.sismanweb.entidades.Docente;
import pe.edu.sistemas.sismanweb.services.DocenteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PruebaDocente {
	
	@Autowired public DocenteService docenteService;
	
	@Autowired public CursoBaseDAO cursoBaseDao;
	
	@Autowired public CursoConjuntoDAO cursoConjuntoDao;
		

	@Test
	@Ignore
	public void seMuestraPersonas() {	
		
		List<Docente> lista = docenteService.obtenerDocentes();
		
		for(Docente p : lista){
			System.out.print(p.getPersona().getPersonaCodigo()+" : ");
			System.out.print(p.getCategoriaDocente()+" : ");
			System.out.print(p.getClase()+" : ");
			System.out.print(p.getDepartamentoAcademico().getDepartamentoAcademicoNombre()+" : ");
			System.out.println(p.getPersona().getPersonaNombre());
		}	
		
		Assert.assertEquals(10,lista.size());

	}
	
	@Test
	//@Ignore
	public void seMuestraCursoBase(){
		List<CursoBase> cursoBase = cursoBaseDao.obtenerTodoCursoBasexNombre("Curso");
		
		System.out.println(cursoBase.size());
		
		for(CursoBase cb: cursoBase){
			System.out.print(cb.getIdcursoGeneral()+" -- "+cb.getCursobCodigo()+" -- "+cb.getCursobNombre()+" -- "+cb.getCursobCreditos()+" -- "+cb.getPlan().getPlanNombre());
			System.out.println(" -- " +cb.getCursoConjuntos().size());
			
		}	
		
		CursoBase cb = new CursoBase();
		cb.setCursobCodigo("405");
		cb.setCursobNombre("miCurso");
		cb.setCursobCiclo(1);
		cb.setCursobCreditos(4);
		cb.setPlan(cursoBase.get(0).getPlan());
		
		CursoConjunto cc = new CursoConjunto();
		cc.setCursoBase(cb);
		cc.setCursocNombre(cb.getCursobNombre());
		cc.setCursocCodcomun(1);
		
		int id = cursoConjuntoDao.agregarCursoConjunto(cc);
		//int id = cursoBaseDao.agregarCursoBase(cb);
		System.out.println(id);
	
	}
	
	
	@Test
	@Ignore
	public void agregaCurso(){
		List<CursoBase> cursoBase = cursoBaseDao.obtenerTodoCursoBasexNombre("Curso");
		
		System.out.println(cursoBase.size());
		
		for(CursoBase cb: cursoBase){
			System.out.print(cb.getIdcursoGeneral()+" -- "+cb.getCursobCodigo()+" -- "+cb.getCursobNombre()+" -- "+cb.getCursobCreditos()+" -- "+cb.getPlan().getPlanNombre());
			System.out.println(" -- " +cb.getCursoConjuntos().size());
			
		}	
		
		
	}
	
	
	
	

}
