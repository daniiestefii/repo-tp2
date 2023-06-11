package ar.edu.unju.fi.service;


import jakarta.validation.Valid;

import java.util.List;

import ar.edu.unju.fi.controller.model.Sucursal;
public interface ISucursalService {

	List<Sucursal> getListaSucursal();
	
	void guardar(@Valid Sucursal sucursal);
	
	Sucursal buscar(String nombre);
	
	void modificar(Sucursal sucursal);
	
	void eliminar(Sucursal sucursalEncontrado);
	
	Sucursal getSucursal();
	
}
