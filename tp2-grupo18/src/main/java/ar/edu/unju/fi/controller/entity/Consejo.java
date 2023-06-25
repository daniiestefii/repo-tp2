package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;

/**
 * @model Consejo
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */

/** estableciendo como una entidad de base de datos*/
@Component
@Entity
@Table(name="Consejo")
public class Consejo{

	/** identificador*/
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

	/** establece una relacion con autor*/
	@ManyToOne
	@JoinColumn(name="autor_id",nullable = false)
	private Autor autor;

	@Column(name="conse_estado",nullable = false)
	private boolean estado;

	public Consejo(long id, String titulo, String texto,Autor autor, boolean estado) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		this.estado = estado;
	}

	public Consejo() {
	}

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

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
