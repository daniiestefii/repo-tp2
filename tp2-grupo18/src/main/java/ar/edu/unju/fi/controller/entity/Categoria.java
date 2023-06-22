package ar.edu.unju.fi.controller.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Categoria")
public class Categoria {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="cate_id",nullable = false)
   private long id;
   @Column(name="cate_nombre",nullable = false)
   private String nombre;
   @Column(name="cate_estado",nullable = false)
   private boolean estado;
public Categoria(long id, String nombre, boolean estado) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.estado = estado;
}
   public Categoria() {
   }
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
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
