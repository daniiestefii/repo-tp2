package ar.edu.unju.fi.controller.model;

public class Servicio {
   private String dia;
   private String horario;
   private String nombre;
public Servicio(String dia, String horario, String nombre) {
	super();
	this.dia = dia;
	this.horario = horario;
	this.nombre = nombre;
}
public String getDia() {
	return dia;
}
public void setDia(String dia) {
	this.dia = dia;
}
public String getHorario() {
	return horario;
}
public void setHorario(String horario) {
	this.horario = horario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
    
}
