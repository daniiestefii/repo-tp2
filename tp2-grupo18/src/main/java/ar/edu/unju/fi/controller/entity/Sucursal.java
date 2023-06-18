package ar.edu.unju.fi.controller.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

/**
 * @model Sucursal
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */
@Component
public class Sucursal {
	@NotBlank(message= "debe tener un nombre")
	private String nombre;
	@NotBlank(message = "El lugar no puede estar vacío")
	private String lugar;
	@NotBlank(message = "El telefono no puede estar vacío")
	private String telefono;
	@NotBlank(message = "El dia no puede estar vacío")
	private String dia;
	@NotBlank(message = "El horario no puede estar vacío")
	private String horario;
	@NotBlank(message = "El gmail no puede estar vacío")
	@Email(message = "El gmail debe ser una dirección de correo electrónico válida")
	private String gmail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="la fecha no puede ser null")
	@Past(message="la fecha debe ser menor a la fecha actual")
	private LocalDate fechainicio;
	public Sucursal(@NotBlank(message = "debe tener un nombre") String nombre,
			@NotBlank(message = "El lugar no puede estar vacío") String lugar,
			@NotBlank(message = "El telefono no puede estar vacío") String telefono,
			@NotBlank(message = "El dia no puede estar vacío") String dia,
			@NotBlank(message = "El horario no puede estar vacío") String horario,
			@NotBlank(message = "El gmail no puede estar vacío") @Email(message = "El gmail debe ser una dirección de correo electrónico válida") String gmail,
			@NotNull(message = "la fecha no puede ser null") @Past(message = "la fecha debe ser menor a la fecha actual") LocalDate fechainicio) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		this.telefono = telefono;
		this.dia = dia;
		this.horario = horario;
		this.gmail = gmail;
		this.fechainicio = fechainicio;
	}
	
	public Sucursal() {
		
	}
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
    
	
}

