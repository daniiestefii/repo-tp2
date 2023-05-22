package ar.edu.unju.fi.controller.model;

public class Sucursal {
   private String lugar;
   private String telefono;
   private String dia;
   private String horario;
   private String gmail;
public Sucursal(String lugar, String telefono, String dia, String horario, String gmail) {
	super();
	this.lugar = lugar;
	this.telefono = telefono;
	this.dia = dia;
	this.horario = horario;
	this.gmail = gmail;
}
public String getLugar() {
	return lugar;
}
public void setLugar(String lugar) {
	this.lugar = lugar;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
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
public String getGmail() {
	return gmail;
}
public void setGmail(String gmail) {
	this.gmail = gmail;
}
   
}
