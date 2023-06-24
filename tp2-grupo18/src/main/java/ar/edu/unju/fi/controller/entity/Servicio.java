package ar.edu.unju.fi.controller.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@Column(name ="Serv_horario", nullable=false)
	private String horario;
	@NotNull(message="debe elegir un empleado")
	@ManyToOne
    @JoinColumn(name = "Emple_id")
	private Empleado empleado;
	@Column(name ="Serv_estado", nullable=false)
	private boolean estado;
public Servicio(Long id,String dia, String horario,Empleado empleado,boolean estado) {
	super();
	this.id =  id;
	this.dia = dia;
	this.horario = horario;
	this.empleado = empleado;
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

public Empleado getEmpleado() {
	return empleado;
}
public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}



    
}
