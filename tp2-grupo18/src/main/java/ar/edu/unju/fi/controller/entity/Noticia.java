package ar.edu.unju.fi.controller.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
/**
 * @model Noticia
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */

@Component
@Entity
@Table(name="Noticias")
public class Noticia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Noti_id")
	private Long id;
	@NotBlank(message = "El título no puede estar vacío")
	@Column(name ="Noti_titulo")
	private String titulo;
	@NotBlank(message = "El texto no puede estar vacío")
	@Column(name ="Noti_texto")
    private String texto;
	@Column(name ="Noti_estado")
	private boolean estado;
public Noticia(Long id,String titulo, String texto,boolean estado){
	super();
	this.id = id;
	this.titulo = titulo;
	this.texto = texto;
	this.estado = estado;
	
}
	/**
	 *
	 * @Get
	 * @Set
	 * 
	 */
  public Noticia() {
	  
  }
  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
public boolean getEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}
}
