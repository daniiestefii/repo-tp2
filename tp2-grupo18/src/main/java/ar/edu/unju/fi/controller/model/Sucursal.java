package ar.edu.unju.fi.controller.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @model Sucursal
 * @author DOrdonez
 */
public class Sucursal {
	@NotBlank(message = "El lugar no puede estar vacío")
	private String lugar;
	@NotBlank(message = "El telefono no puede estar vacío")
	private String telefono;
	@NotBlank(message = "El dia no puede estar vacío")
	private String dia;
	@NotBlank(message = "El horario no puede estar vacío")
	private String horario;
	@NotBlank(message = "El gmail no puede estar vacío")
	@Email(message = "El gmail debe ser una dirección de correo electrónico válida")
	private String gmail;
public Sucursal(String lugar, String telefono, String dia, String horario, String gmail) {
	super();
	this.lugar = lugar;
	this.telefono = telefono;
	this.dia = dia;
	this.horario = horario;
	this.gmail = gmail;
}
	/**
	 *
	 * @Get
	 * @Set
	 */

public String getLugar() {
	return lugar;
}
public void setLugar(String lugar) {
	this.lugar = lugar;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
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
public String getGmail() {
	return gmail;
}
public void setGmail(String gmail) {
	this.gmail = gmail;
}
   
}
