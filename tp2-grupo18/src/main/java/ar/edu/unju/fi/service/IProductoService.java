package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.controller.entity.Producto;

import java.util.List;

public interface IProductoService {
	/**
     * @method Devuelve una lista de todos los Productos
     */
	List<Producto> getListaProductos();
	/**
     * @method Guarda un nuevo Producto
     */
	void guardar(Producto producto);
	/**
     * @method  Devuelve el Producto cuyo nombre coincide con el parámetro nombre.
     */
	Producto buscar(long id);
	/**
     * @method Modifica un Producto existente
     */
	void modificar(Producto producto);
	/**
     * @method Elimina un Producto existente
     */
	void eliminar(Producto productoEncontrado);
	/**
     * @method Devuelve un nuevo objeto Producto
     */
	Producto getProducto();
	
	List<Producto> getListaProductosFiltrados(Categoria categoria, boolean estado);
	
}
