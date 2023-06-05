package ar.edu.unju.fi.controller.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
/**
 * @model Servicio
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */

public class Servicio {
	@NotBlank(message = "El dia no puede estar vacío")
	private String dia;
	@NotBlank(message = "El horario no puede estar vacío")
	private String horario;
	@NotBlank(message = "El nombre no puede estar vacío")
   private String nombre;
public Servicio(String dia, String horario, String nombre) {
	super();
	this.dia = dia;
	this.horario = horario;
	this.nombre = nombre;
}
	/**
	 *
	 * @Get
	 * @Set
	 */

public String getDia() {
	return dia;
}
public void setDia(String dia) {
	this.dia = dia;
}
public String getHorario() {
	return horario;
}
public void setHorario(String horario) {
	this.horario = horario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
    
}
