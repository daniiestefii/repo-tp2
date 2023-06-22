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
	   servicios.add(new Servicio(1l,"Lunes","9 a 12 - 16 a 18","Juan Perez",true));
	   servicios.add(new Servicio(2l,"Martes","9 a 12 - 16 a 18","Lucas Diaz",true));
	   servicios.add(new Servicio(3l,"Miercoles","9 a 12 - 16 a 18","Juan Perez",true));
	   servicios.add(new Servicio(4l,"Jueves","9 a 12 - 16 a 18","Maria Gomez",true));
	   servicios.add(new Servicio(5l,"Viernes","9 a 12 - 16 a 18","Lucas Diaz",true));
	   servicios.add(new Servicio(6l,"Sabado","9 a 12 - 16 a 18","Roberto Vazquez",true));
   }

public List<Servicio> getServicios() {
	return servicios;
}

public void setServicios(List<Servicio> servicios) {
	this.servicios = servicios;
}
   
}