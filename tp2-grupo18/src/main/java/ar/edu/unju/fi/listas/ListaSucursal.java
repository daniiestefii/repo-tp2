package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.controller.model.Sucursal;

public class ListaSucursal{
   private List<Sucursal>sucursales;
   
   public ListaSucursal() {
	   sucursales = new ArrayList<Sucursal>();
	   sucursales.add(new Sucursal("3915 Av. General Belgrano","388-4999999","Luneas a viernes","9:00 a. m. 8 p. m","contactos@mail.com.ar"));
   }

public List<Sucursal> getSucursales() {
	return sucursales;
}

public void setSucursales(List<Sucursal> sucursales) {
	this.sucursales = sucursales;
}
   
}