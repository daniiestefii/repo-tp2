package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


import jakarta.validation.constraints.NotBlank;


/**
 * @model Consejo
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */
@Component
@Entity
@Table(name="Consejo")
public class Consejo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="conse_id",nullable = false)
	private long id;
	@NotBlank(message="Tiene que escribir un titulo")
	@Column(name ="conse_titulo",nullable = false)
	private String titulo;
	@NotBlank(message="Tiene que escribir un texto")
	@Column(name ="conse_texto",nullable = false)
    private String texto;
	@NotBlank(message="Tiene que escribir un autor")
	@Column(name ="conse_autor",nullable = false)
	private String autor;

	@Column(name="conse_estado",nullable = false)
	private boolean estado;

	public Consejo(long id, String titulo, String texto,String autor, boolean estado) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		this.estado = estado;
	}

	public Consejo() {
	}

	/**
	 *
	 * @Get
	 * @Set
	 */

	public long getId() {
		return id;
	}
	public void setId(long id) {
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

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
