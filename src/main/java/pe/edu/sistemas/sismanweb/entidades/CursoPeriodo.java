package pe.edu.sistemas.sismanweb.entidades;
// Generated 03/05/2017 02:54:05 AM by Hibernate Tools 5.2.0.CR1

/**
 * CursoPeriodo generated by hbm2java
 */
public class CursoPeriodo implements java.io.Serializable {

	private Integer idcursoPeriodo;
	private CursoConjunto cursoConjunto;
	private Periodo periodo;
	private String cursoPeriodoNombre;

	public CursoPeriodo() {
	}

	public CursoPeriodo(CursoConjunto cursoConjunto, Periodo periodo) {
		this.cursoConjunto = cursoConjunto;
		this.periodo = periodo;
	}

	public CursoPeriodo(CursoConjunto cursoConjunto, Periodo periodo, String cursoPeriodoNombre) {
		this.cursoConjunto = cursoConjunto;
		this.periodo = periodo;
		this.cursoPeriodoNombre = cursoPeriodoNombre;
	}

	public Integer getIdcursoPeriodo() {
		return this.idcursoPeriodo;
	}

	public void setIdcursoPeriodo(Integer idcursoPeriodo) {
		this.idcursoPeriodo = idcursoPeriodo;
	}

	public CursoConjunto getCursoConjunto() {
		return this.cursoConjunto;
	}

	public void setCursoConjunto(CursoConjunto cursoConjunto) {
		this.cursoConjunto = cursoConjunto;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getCursoPeriodoNombre() {
		return this.cursoPeriodoNombre;
	}

	public void setCursoPeriodoNombre(String cursoPeriodoNombre) {
		this.cursoPeriodoNombre = cursoPeriodoNombre;
	}

}
