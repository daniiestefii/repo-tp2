package ar.edu.unju.fi.controller.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

/**
 * @model Sucursal
 * @author DOrdonez, MiltonDelgado
 */

/**
 * estableciendo como una entidad de base de datos
 **/
@Component
@Entity
@Table(name="Sucursal")

/** identificador*/
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="sucu_id",nullable = false)
	private long id;
	@NotBlank(message= "Debe tener un nombre")
	@Column(name ="sucu_nombre",nullable = false)
	private String nombre;
	@NotBlank(message = "El lugar no puede estar vacío")
	@Column(name ="sucu_lugar",nullable = false)
	private String lugar;
	@NotBlank(message = "El telefono no puede estar vacío")
	@Column(name ="sucu_telefono",nullable = false)
	private String telefono;
	@NotBlank(message = "El dia no puede estar vacío")
	@Column(name ="sucu_dia",nullable = false)
	private String dia;
	@NotBlank(message = "El horario no puede estar vacío")
	@Column(name ="sucu_horario",nullable = false)
	private String horario;
	@NotBlank(message = "El email no puede estar vacío")
	@Email(message = "El email debe ser una dirección de correo electrónico válida")
	@Column(name ="sucu_gmail",nullable = false)
	private String gmail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="La fecha no puede ser nula")
	@Column(name ="sucu_fechainicio",nullable = false)
	@Past(message="la fecha debe ser menor a la fecha actual")
	private LocalDate fechainicio;

	/** establece una relacion con provincia*/
	@ManyToOne
	@JoinColumn(name="provi_id",nullable = false)
	private Provincia provincia;

	@Column(name="sucu_estado",nullable = false)
	private boolean estado;

	public Sucursal() {
		
	}
	public Sucursal(long id, String nombre, String lugar, String telefono, String dia, String horario, String gmail, @NotNull(message = "La fecha no puede ser nula") LocalDate fechainicio,@NotNull(message = "Debe seleccionarse una provincia") Provincia provincia, boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.lugar = lugar;
		this.telefono = telefono;
		this.dia = dia;
		this.horario = horario;
		this.gmail = gmail;
		this.fechainicio = fechainicio;
		this.provincia = provincia;
		this.estado = estado;
	}

	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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
	public LocalDate getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(LocalDate fechainicio) {
		this.fechainicio = fechainicio;
	}
	public boolean isEstado() {return estado;}
	public void setEstado(boolean estado) {this.estado = estado;}

	public Provincia getProvincia() {return provincia;}

	public void setProvincia(Provincia provincia) {this.provincia = provincia;}
}

