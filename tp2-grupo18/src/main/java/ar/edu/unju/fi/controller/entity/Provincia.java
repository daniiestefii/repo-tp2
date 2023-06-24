package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Provincias")

public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="provi_id")
    private Long id;
    @NotBlank(message="no puede estar vacio")
    @Column(name = "provi_nombre",nullable = false)
    private String nombre;
    @Column(name = "provi_estado",nullable = false)
    private Boolean estado;


    public Provincia() {

    }
    public Provincia(Long id ,String nombre,boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
