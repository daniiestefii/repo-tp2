package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

/**
 * @model Noticia
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */

@Component
@Entity
@Table(name="Noticia")
public class Noticia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="noti_id",nullable = false)
	private Long id;
	@NotBlank(message = "El título no puede estar vacío")
	@Column(name ="noti_titulo",nullable = false)
	private String titulo;
	@NotBlank(message = "El texto no puede estar vacío")
	@Column(name ="noti_texto",nullable = false)
   	private String texto;
	@NotBlank(message = "El autor no puede estar vacío")
	private String autor;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="La fecha no puede ser nula")
	@Column(name ="noti_fecha",nullable = false)
	@Past(message="la fecha debe ser menor a la fecha actual")
	private LocalDate fecha;

	@Column(name="noti_estado",nullable = false)
	private boolean estado;

	public Noticia(Long id, String titulo, String texto, String autor, @NotNull(message = "La fecha no puede ser nula") LocalDate fecha, boolean estado) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		this.fecha = fecha;
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
