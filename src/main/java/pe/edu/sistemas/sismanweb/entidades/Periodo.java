package pe.edu.sistemas.sismanweb.entidades;
// Generated 03/05/2017 02:54:05 AM by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Periodo generated by hbm2java
 */
public class Periodo implements java.io.Serializable {

	private int idperiodo;
	private String periodoNombre;
	private Date periodoFechaInicio;
	private Date periodoFechaFin;
	private Set cursoPeriodos = new HashSet(0);

	public Periodo() {
	}

	public Periodo(int idperiodo, String periodoNombre) {
		this.idperiodo = idperiodo;
		this.periodoNombre = periodoNombre;
	}

	public Periodo(int idperiodo, String periodoNombre, Date periodoFechaInicio, Date periodoFechaFin,
			Set cursoPeriodos) {
		this.idperiodo = idperiodo;
		this.periodoNombre = periodoNombre;
		this.periodoFechaInicio = periodoFechaInicio;
		this.periodoFechaFin = periodoFechaFin;
		this.cursoPeriodos = cursoPeriodos;
	}

	public int getIdperiodo() {
		return this.idperiodo;
	}

	public void setIdperiodo(int idperiodo) {
		this.idperiodo = idperiodo;
	}

	public String getPeriodoNombre() {
		return this.periodoNombre;
	}

	public void setPeriodoNombre(String periodoNombre) {
		this.periodoNombre = periodoNombre;
	}

	public Date getPeriodoFechaInicio() {
		return this.periodoFechaInicio;
	}

	public void setPeriodoFechaInicio(Date periodoFechaInicio) {
		this.periodoFechaInicio = periodoFechaInicio;
	}

	public Date getPeriodoFechaFin() {
		return this.periodoFechaFin;
	}

	public void setPeriodoFechaFin(Date periodoFechaFin) {
		this.periodoFechaFin = periodoFechaFin;
	}

	public Set getCursoPeriodos() {
		return this.cursoPeriodos;
	}

	public void setCursoPeriodos(Set cursoPeriodos) {
		this.cursoPeriodos = cursoPeriodos;
	}

}
