package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.controller.entity.Producto;

@Component
public class ListaProducto {
   private List<Producto>productos;
   
	/*
	 * Esta lista de productos contiene objetos de la clase "Producto".
	 */
   
   
   public ListaProducto() {
	   productos = new ArrayList<Producto>();
	   
   }

public List<Producto> getProductos() {
	return productos;
}

public void setProductos(List<Producto> productos) {
	this.productos = productos;
}
   
}
