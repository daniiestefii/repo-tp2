package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.controller.entity.Servicio;

@Component
public class ListaServicio{
   private List<Servicio>servicios;

	/*
	 * Esta lista de servicios contiene objetos de la clase "Servicio".
	 */
   public ListaServicio() {
	   servicios = new ArrayList<Servicio>();
	   servicios.add(new Servicio("Lunes","9 a 12 - 16 a 18","Juan Perez"));
	   servicios.add(new Servicio("Martes","9 a 12 - 16 a 18","Lucas Diaz"));
	   servicios.add(new Servicio("Miercoles","9 a 12 - 16 a 18","Juan Perez"));
	   servicios.add(new Servicio("Jueves","9 a 12 - 16 a 18","Maria Gomez"));
	   servicios.add(new Servicio("Viernes","9 a 12 - 16 a 18","Lucas Diaz"));
	   servicios.add(new Servicio("Sabado","9 a 12 - 16 a 18","Roberto Vazquez"));
   }

public List<Servicio> getServicios() {
	return servicios;
}

public void setServicios(List<Servicio> servicios) {
	this.servicios = servicios;
}
   
}