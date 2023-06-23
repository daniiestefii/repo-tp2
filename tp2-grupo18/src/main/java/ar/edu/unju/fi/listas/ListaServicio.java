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
   }

public List<Servicio> getServicios() {
	return servicios;
}

public void setServicios(List<Servicio> servicios) {
	this.servicios = servicios;
}
   
}