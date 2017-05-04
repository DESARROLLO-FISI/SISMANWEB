package pe.edu.sistemas.sismanweb.entidades;
// Generated 03/05/2017 02:54:05 AM by Hibernate Tools 5.2.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * CursoBase generated by hbm2java
 */
public class CursoBase implements java.io.Serializable {

	private Integer idcursoGeneral;
	private Plan plan;
	private String cursobCodigo;
	private String cursobNombre;
	private int cursobCiclo;
	private int cursobCreditos;
	private Set cursoConjuntos = new HashSet(0);

	public CursoBase() {
	}

	public CursoBase(Plan plan, String cursobCodigo, String cursobNombre, int cursobCiclo, int cursobCreditos) {
		this.plan = plan;
		this.cursobCodigo = cursobCodigo;
		this.cursobNombre = cursobNombre;
		this.cursobCiclo = cursobCiclo;
		this.cursobCreditos = cursobCreditos;
	}

	public CursoBase(Plan plan, String cursobCodigo, String cursobNombre, int cursobCiclo, int cursobCreditos,
			Set cursoConjuntos) {
		this.plan = plan;
		this.cursobCodigo = cursobCodigo;
		this.cursobNombre = cursobNombre;
		this.cursobCiclo = cursobCiclo;
		this.cursobCreditos = cursobCreditos;
		this.cursoConjuntos = cursoConjuntos;
	}

	public Integer getIdcursoGeneral() {
		return this.idcursoGeneral;
	}

	public void setIdcursoGeneral(Integer idcursoGeneral) {
		this.idcursoGeneral = idcursoGeneral;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getCursobCodigo() {
		return this.cursobCodigo;
	}

	public void setCursobCodigo(String cursobCodigo) {
		this.cursobCodigo = cursobCodigo;
	}

	public String getCursobNombre() {
		return this.cursobNombre;
	}

	public void setCursobNombre(String cursobNombre) {
		this.cursobNombre = cursobNombre;
	}

	public int getCursobCiclo() {
		return this.cursobCiclo;
	}

	public void setCursobCiclo(int cursobCiclo) {
		this.cursobCiclo = cursobCiclo;
	}

	public int getCursobCreditos() {
		return this.cursobCreditos;
	}

	public void setCursobCreditos(int cursobCreditos) {
		this.cursobCreditos = cursobCreditos;
	}

	public Set getCursoConjuntos() {
		return this.cursoConjuntos;
	}

	public void setCursoConjuntos(Set cursoConjuntos) {
		this.cursoConjuntos = cursoConjuntos;
	}

}
