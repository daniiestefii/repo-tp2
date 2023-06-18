package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ListaProducto listaProducto;
	@Autowired
	private Producto producto;
	
	/**
     * @method Devuelve una lista de tipo Producto, pero antes de 
     * retornar se calcula el descuento de todos los objetos producto
     * dentro de la lista
     */
	@Override
	public List<Producto> getListaProductos() {
		for (Producto i : listaProducto.getProductos()) {
            i.setPrecio(i.calcularDescuento());
        }
		return listaProducto.getProductos();
	}
	/**
     * @method guarda un objeto producto que llega como parametro
     * dentro de la listaProducto
     */
	@Override
	public void guardar(@Valid Producto producto) {
	   listaProducto.getProductos().add(producto);
	}
	/**
     * @method busca un elemento dentro de la lista con respecto al nombre
     * que llega como parametro en este metodo, si no se encuentra entonces
     * retorna un valor nulo
     */
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
	/**
     * @method modifica un objeto Producto dentro de la listaProducto
     * 
     * */
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
	/**
     * @method elimina un objeto producto dentro de la listaProducto
     */
	@Override
	public void eliminar(Producto productoEncontrado) {
		listaProducto.getProductos().remove(productoEncontrado);
		
	}
	/**
     * @method retorna un objeto producto
     */
	@Override
	public Producto getProducto() {
		return producto;
	}

}
