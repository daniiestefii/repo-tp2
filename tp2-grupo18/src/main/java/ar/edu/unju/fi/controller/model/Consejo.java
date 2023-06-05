package ar.edu.unju.fi.controller.model;

import org.springframework.stereotype.Component;

/**
 * @model Consejo
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */
public class Consejo{
	
	private String titulo;
	
   private String texto;
public Consejo(String titulo, String texto) {
	super();
	this.titulo = titulo;
	this.texto = texto;
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
