package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.controller.entity.Sucursal;
import jakarta.validation.Valid;

import java.util.List;

public interface ISucursalService {
	/**
	 * @method Devuelve una lista de todos los Productos
	 */
	List<Sucursal> getListaSucursales();
	/**
	 * @method Guarda un nueva Sucursal
	 */
	void guardar(@Valid Sucursal sucursal);
	/**
	 * @method  Devuelve la Sucursal cuyo id coincide con el parámetro id.
	 */
	Sucursal buscar(long id);
	/**
	 * @method Modifica un Sucursal existente
	 */
	void modificar(Sucursal sucursal);
	/**
	 * @method Elimina una sucursal existente
	 */
	void eliminar(Sucursal sucursalEncontrado);
	/**
	 * @method Devuelve un nuevo objeto Sucursal
	 */
	Sucursal getSucursal();

	List<Sucursal> getListaSucursalesFiltradosForFecha(String dia,String dia1);

}
