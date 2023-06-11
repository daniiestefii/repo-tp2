package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.model.Producto;
import jakarta.validation.Valid;

import java.util.List;
public interface IProductoService {

	List<Producto> getListaProductos();
	
	void guardar(@Valid Producto producto);
	
	Producto buscar(String nombre);
	
	void modificar(Producto producto);
	
	void eliminar(Producto productoEncontrado);
	
	Producto getProducto();
	
}
