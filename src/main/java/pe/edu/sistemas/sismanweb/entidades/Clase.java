package pe.edu.sistemas.sismanweb.entidades;
// Generated 10/08/2017 03:08:17 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Clase generated by hbm2java
 */
public class Clase implements java.io.Serializable {

	private Short idclase;
	private String claseNombre;
	private Set docentes = new HashSet(0);

	public Clase() {
	}

	public Clase(String claseNombre) {
		this.claseNombre = claseNombre;
	}

	public Clase(String claseNombre, Set docentes) {
		this.claseNombre = claseNombre;
		this.docentes = docentes;
	}

	public Short getIdclase() {
		return this.idclase;
	}

	public void setIdclase(Short idclase) {
		this.idclase = idclase;
	}

	public String getClaseNombre() {
		return this.claseNombre;
	}

	public void setClaseNombre(String claseNombre) {
		this.claseNombre = claseNombre;
	}

	public Set getDocentes() {
		return this.docentes;
	}

	public void setDocentes(Set docentes) {
		this.docentes = docentes;
	}

}
