package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Empleados")
public class Empleado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Emple_id")
    private Long id;
    @NotBlank(message="debe ingresar un nombre")
    @Column(name = "Emple_nombre",nullable = false)
    private String nombre;
    @NotBlank(message="debe ingresar un apellido")
    @Column(name = "Emple_apellido",nullable = false)
    private String apellido;
    @NotNull(message="no puede estar vacio")
    @Positive(message="debe ser un numero valido")
    @Column(name = "Emple_dni",nullable = false)
    private int dni;
    @OneToMany(mappedBy = "empleado")
    private List<Servicio> servicio;
    @Column(name = "Emple_estado",nullable = false)
    private Boolean estado;
    

    public Empleado(Long id ,String nombre,String apellido, int dni,List<Servicio> servicio,boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.servicio = servicio;
        this.estado = estado;
        
    }
    public Empleado() {

    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public List<Servicio> getServicio(){
		return servicio;
	}
	public void setServicio(List<Servicio> servicio){
		this.servicio = servicio;
	}
	
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
