package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.controller.model.Producto;

public class ListaProducto {
   private List<Producto>productos;
   
   public ListaProducto() {
	   productos = new ArrayList<Producto>();
	   productos.add(new Producto("Collar para perro",3213,5000,"Vestimenta",20));
	   productos.add(new Producto("Collar isabelino",4546,2600,"Vestimenta",10));
	   productos.add(new Producto("Cepillo de doble cerda",890,120,"Cuidado",0));
   }

public List<Producto> getProductos() {
	return productos;
}

public void setProductos(List<Producto> productos) {
	this.productos = productos;
}
   
}
