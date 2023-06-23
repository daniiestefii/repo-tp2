package ar.edu.unju.fi.controller.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
/**
 * @model Noticia
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */

@Component
public class Noticia {
	@NotBlank(message = "El título no puede estar vacío")
	private String titulo;
	@NotBlank(message = "El texto no puede estar vacío")
   private String texto;
public Noticia(String titulo, String texto){
	super();
	this.titulo = titulo;
	this.texto = texto;
}
	/**
	 *
	 * @Get
	 * @Set
	 * 
	 */
  public Noticia() {
	  
  }

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
