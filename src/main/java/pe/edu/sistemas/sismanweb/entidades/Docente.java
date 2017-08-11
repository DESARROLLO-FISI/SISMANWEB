package pe.edu.sistemas.sismanweb.entidades;
// Generated 10/08/2017 03:08:17 PM by Hibernate Tools 4.3.1.Final

/**
 * Docente generated by hbm2java
 */
public class Docente implements java.io.Serializable {

	private Integer iddocente;
	private CategoriaDocente categoriaDocente;
	private Clase clase;
	private DepartamentoAcademico departamentoAcademico;
	private Persona persona;
	private String docenteClave;
	private String docenteGrupoOcupacional;
	private String docenteNivel;
	private String docenteObservacionTiempoServicio;
	private String docenteObservacionLimiteEdad;
	private String docenteObservacionOtros;
	private String docenteDocumentos;
	private int docenteRegular;
	private Integer historialServicioIdhistorialServicio;

	public Docente() {
	}

	public Docente(Persona persona, String docenteClave, int docenteRegular) {
		this.persona = persona;
		this.docenteClave = docenteClave;
		this.docenteRegular = docenteRegular;
	}

	public Docente(CategoriaDocente categoriaDocente, Clase clase, DepartamentoAcademico departamentoAcademico,
			Persona persona, String docenteClave, String docenteGrupoOcupacional, String docenteNivel,
			String docenteObservacionTiempoServicio, String docenteObservacionLimiteEdad,
			String docenteObservacionOtros, String docenteDocumentos, int docenteRegular,
			Integer historialServicioIdhistorialServicio) {
		this.categoriaDocente = categoriaDocente;
		this.clase = clase;
		this.departamentoAcademico = departamentoAcademico;
		this.persona = persona;
		this.docenteClave = docenteClave;
		this.docenteGrupoOcupacional = docenteGrupoOcupacional;
		this.docenteNivel = docenteNivel;
		this.docenteObservacionTiempoServicio = docenteObservacionTiempoServicio;
		this.docenteObservacionLimiteEdad = docenteObservacionLimiteEdad;
		this.docenteObservacionOtros = docenteObservacionOtros;
		this.docenteDocumentos = docenteDocumentos;
		this.docenteRegular = docenteRegular;
		this.historialServicioIdhistorialServicio = historialServicioIdhistorialServicio;
	}

	public Integer getIddocente() {
		return this.iddocente;
	}

	public void setIddocente(Integer iddocente) {
		this.iddocente = iddocente;
	}

	public CategoriaDocente getCategoriaDocente() {
		return this.categoriaDocente;
	}

	public void setCategoriaDocente(CategoriaDocente categoriaDocente) {
		this.categoriaDocente = categoriaDocente;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public DepartamentoAcademico getDepartamentoAcademico() {
		return this.departamentoAcademico;
	}

	public void setDepartamentoAcademico(DepartamentoAcademico departamentoAcademico) {
		this.departamentoAcademico = departamentoAcademico;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDocenteClave() {
		return this.docenteClave;
	}

	public void setDocenteClave(String docenteClave) {
		this.docenteClave = docenteClave;
	}

	public String getDocenteGrupoOcupacional() {
		return this.docenteGrupoOcupacional;
	}

	public void setDocenteGrupoOcupacional(String docenteGrupoOcupacional) {
		this.docenteGrupoOcupacional = docenteGrupoOcupacional;
	}

	public String getDocenteNivel() {
		return this.docenteNivel;
	}

	public void setDocenteNivel(String docenteNivel) {
		this.docenteNivel = docenteNivel;
	}

	public String getDocenteObservacionTiempoServicio() {
		return this.docenteObservacionTiempoServicio;
	}

	public void setDocenteObservacionTiempoServicio(String docenteObservacionTiempoServicio) {
		this.docenteObservacionTiempoServicio = docenteObservacionTiempoServicio;
	}

	public String getDocenteObservacionLimiteEdad() {
		return this.docenteObservacionLimiteEdad;
	}

	public void setDocenteObservacionLimiteEdad(String docenteObservacionLimiteEdad) {
		this.docenteObservacionLimiteEdad = docenteObservacionLimiteEdad;
	}

	public String getDocenteObservacionOtros() {
		return this.docenteObservacionOtros;
	}

	public void setDocenteObservacionOtros(String docenteObservacionOtros) {
		this.docenteObservacionOtros = docenteObservacionOtros;
	}

	public String getDocenteDocumentos() {
		return this.docenteDocumentos;
	}

	public void setDocenteDocumentos(String docenteDocumentos) {
		this.docenteDocumentos = docenteDocumentos;
	}

	public int getDocenteRegular() {
		return this.docenteRegular;
	}

	public void setDocenteRegular(int docenteRegular) {
		this.docenteRegular = docenteRegular;
	}

	public Integer getHistorialServicioIdhistorialServicio() {
		return this.historialServicioIdhistorialServicio;
	}

	public void setHistorialServicioIdhistorialServicio(Integer historialServicioIdhistorialServicio) {
		this.historialServicioIdhistorialServicio = historialServicioIdhistorialServicio;
	}

}
