package ar.edu.unju.fi.controller.entity;

import org.springframework.stereotype.Component;


import jakarta.validation.constraints.NotBlank;


/**
 * @model Consejo
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */
@Component
public class Consejo{
	@NotBlank(message="Tiene que escribir un titulo")
	private String titulo;
	@NotBlank(message="Tine que escribir un texto")
   private String texto;
public Consejo(String titulo, String texto) {
	super();
	this.titulo = titulo;
	this.texto = texto;
}

	public Consejo() {
	}

	/**
	 *
	 * @Get
	 * @Set
	 */


public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
}
