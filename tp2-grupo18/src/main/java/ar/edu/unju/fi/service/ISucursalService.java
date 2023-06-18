package ar.edu.unju.fi.service;


import jakarta.validation.Valid;

import java.util.List;

import ar.edu.unju.fi.controller.entity.Sucursal;
public interface ISucursalService {

	/**
     * @method Devuelve una lista de todos las sucursales
     */
	List<Sucursal> getListaSucursal();
	/**
     * @method Guarda una nueva sucursal
     */
	void guardar(@Valid Sucursal sucursal);
	/**
     * @method  Devuelve la sucursal cuyo nombre coincide con el parámetro de sucursal.
     */
	Sucursal buscar(String nombre);
	/**
     * @method Modifica una sucursal existente
     */
	void modificar(Sucursal sucursal);
	/**
     * @method Elimina una sucursal existente
     */
	void eliminar(Sucursal sucursalEncontrado);
	/**
     * @method Devuelve un nuevo objeto sucursal
     */
	Sucursal getSucursal();
	
}
