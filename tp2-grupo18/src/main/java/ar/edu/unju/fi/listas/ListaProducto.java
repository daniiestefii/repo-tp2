package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.controller.model.Producto;

public class ListaProducto {
   private List<Producto>productos;
   
   public ListaProducto() {
	   productos = new ArrayList<Producto>();
	   productos.add(new Producto("collar para perro",3213,500.50,"Vestimenta",20));
	   productos.add(new Producto("collar isabelino",4546,260.20,"Vestimenta",50));
	   productos.add(new Producto("cepillo de doble cerda",890,120.50,"Cuidado",0));
   }

public List<Producto> getProductos() {
	return productos;
}

public void setProductos(List<Producto> productos) {
	this.productos = productos;
}
   
}
