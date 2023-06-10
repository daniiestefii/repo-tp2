package ar.edu.unju.fi.controller.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;
/**
 * @model Producto
 * @author DOrdonez, RicardoFlores, MiltonDelgado
 */
public class Producto {
	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;
	@NotNull(message = "El codigo no puede ser nulo")
	private int codigo;
	@Positive(message = "El precio siempre debe ser positivo")
	@NotNull(message = "No puede quedar vacio")
	private double precio;
	@NotBlank(message = "Las categoria no puede estar vacío")
	private String categoria;
	@Min(value = 0, message = "El descuento no puede ser negativo")
	@Max(value = 100, message = "El descuento no puede ser mayor a 100")
	private int descuento;
	public Producto(String nombre, int codigo, double precio, String categoria, int descuento) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}
	/**
	 *
	 * @Get
	 * @Set
	 */

	public double calcularDescuento() {
		return (this.precio-(this.precio*this.descuento)/100);
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
	
}
