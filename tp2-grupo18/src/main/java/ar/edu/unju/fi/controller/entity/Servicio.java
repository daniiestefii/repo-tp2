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
 * @model Servicio
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */

@Component
@Entity

@Table(name="Servicios")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Serv_id", nullable=false)
	private Long id;
	@NotBlank(message = "El dia no puede estar vacío")
	@Column(name ="Serv_dia", nullable=false)
	private String dia;
	@NotBlank(message = "El horario no puede estar vacío")
	private String horario;
	@NotBlank(message = "El nombre no puede estar vacío")
	@Column(name ="Serv_nombre", nullable=false)
    private String nombre;
	@Column(name ="Serv_estado", nullable=false)
	private boolean estado;
public Servicio(Long id,String dia, String horario, String nombre,boolean estado) {
	super();
	this.id =  id;
	this.dia = dia;
	this.horario = horario;
	this.nombre = nombre;
	this.estado = estado;
}
public Servicio() {
	
}
	/**
	 *
	 * @Get
	 * @Set
	 */
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}


    
}
