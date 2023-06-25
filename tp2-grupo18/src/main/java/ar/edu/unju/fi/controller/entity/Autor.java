package ar.edu.unju.fi.controller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @model Autor
 * @author DOrdonez, MiltonDelgado
 */

/** estableciendo como una entidad de base de datos*/
@Component
@Entity
@Table(name="Autor")

public class Autor {
    /** identificador*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="autor_id")
    private Long id;
    @NotBlank(message="no puede estar vacio")
    @Column(name = "autor_nombre",nullable = false)
    private String nombre;
    @OneToMany(mappedBy = "autor")
    private List<Consejo> consejos;

    @Column(name = "autor_estado",nullable = false)
    private Boolean estado;


    public Autor() {

    }

    public Autor(Long id, String nombre, List<Consejo> consejos, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.consejos = consejos;
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
    public List<Consejo> getConsejos() {
        return consejos;
    }
    public void setConsejos(List<Consejo> consejos) {
        this.consejos = consejos;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
