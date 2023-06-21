package ar.edu.unju.fi.controller.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
/**
 * @model Producto
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */
@Component
@Entity
@Table(name="Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Prod_id")
    private long id;
	@NotBlank(message = "El nombre no puede estar vacío")
	@Column(name="Prod_name",nullable = false)
	private String nombre;
	@NotNull(message = "El codigo no puede ser nulo")
	@Min(value = 1, message ="el valor debe ser mayor a 0")
	@Column(name="Prod_codigo",nullable = false)
	private int codigo;
	@Positive(message = "El precio siempre debe ser positivo")
	@NotNull(message = "No puede quedar vacio")
	@Column(name="Prod_precio",nullable = false)
	private double precio;
	@NotBlank(message = "Seleccione una opcion!")
	@Column(name="Prod_categoria",nullable = false)
	private String categoria;
	@Min(value = 0, message = "El descuento no puede ser negativo")
	@Max(value = 100, message = "El descuento no puede ser mayor a 100")
	@NotNull(message = "este campo no puede estar vacio")
	@Column(name="Prod_descuento",nullable = false)
	private int descuento;
	@Column(name="Prod_estado",nullable = false)
	private boolean estado;
	
	
	  public Producto(long id,String nombre,int codigo,double precio,String categoria,int descuento, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.estado = estado;
	}
	  
	  public Producto() {
		  
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


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}