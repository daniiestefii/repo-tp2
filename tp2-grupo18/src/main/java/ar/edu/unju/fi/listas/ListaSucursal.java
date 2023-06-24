package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.controller.entity.Sucursal;

@Component
public class ListaSucursal{
   private List<Sucursal>sucursales;

	/*
	 * Esta lista de sucursales contiene objetos de la clase "Sucursal".
	 */
   public ListaSucursal() {
	   sucursales = new ArrayList<Sucursal>();
	   //sucursales.add(new Sucursal("Buenos amigos","3915 Av. General Belgrano","388-4999999","Luneas a viernes","9:00 a. m. 8 p. m","contactos@mail.com.ar",LocalDate.of(2002,02,22)));
   }

public List<Sucursal> getSucursales() {
	return sucursales;
}

public void setSucursales(List<Sucursal> sucursales) {
	this.sucursales = sucursales;
}
   
}