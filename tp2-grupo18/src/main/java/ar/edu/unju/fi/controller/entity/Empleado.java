package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Empleados")
public class Empleado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Emple_id")
    private Long id;
    @Column(name = "Emple_nombre",nullable = false)
    private String nombre;
    @Column(name = "Emple_apellido",nullable = false)
    private String apellido;
    @Column(name = "Emple_dni",nullable = false)
    private int dni;
    @Column(name = "Emple_estado",nullable = false)
    private Boolean estado;


    public Empleado(Long id ,String nombre,String apellido, int dni,boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

    
}
