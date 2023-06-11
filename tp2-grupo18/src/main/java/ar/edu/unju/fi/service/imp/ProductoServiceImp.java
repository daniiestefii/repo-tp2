package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.model.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ListaProducto listaProducto;
	@Autowired
	private Producto producto;
	
	@Override
	public List<Producto> getListaProductos() {
		for (Producto i : listaProducto.getProductos()) {
            i.setPrecio(i.calcularDescuento());
        }
		return listaProducto.getProductos();
	}

	@Override
	public void guardar(@Valid Producto producto) {
	   listaProducto.getProductos().add(producto);
	}

	@Override
	public Producto buscar(String nombre) {
		Producto productoEncontrado = null;
		for(Producto prod: listaProducto.getProductos()) {
			if(prod.getNombre().equals(nombre)) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}

	@Override
	public void modificar(Producto producto) {
		for(Producto p : listaProducto.getProductos()) {
			if(p.getNombre().equals(producto.getNombre())) {
				p.setNombre(producto.getNombre());
				p.setCodigo(producto.getCodigo());
				p.setPrecio(producto.getPrecio());
				p.setCategoria(producto.getCategoria());
				p.setDescuento(producto.getDescuento());
				break;
			}
		}
	}

	@Override
	public void eliminar(Producto productoEncontrado) {
		listaProducto.getProductos().remove(productoEncontrado);
		
	}

	@Override
	public Producto getProducto() {
		return producto;
	}

}
