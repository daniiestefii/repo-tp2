package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.controller.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service("ProductoServiceImp")
public class ProductoServiceImp implements IProductoService {
	@Autowired
	private IProductoRepository listaProducto;
	@Autowired
	private Producto producto;
	/**
     * @method Devuelve una lista de tipo Producto, pero antes de 
     * retornar se calcula el descuento de todos los objetos producto
     * dentro de la lista
     */
	@Override
	public List<Producto> getListaProductos() {
		return listaProducto.findByEstado(true);
	}
	/**
     * @method guarda un objeto producto que llega como parametro
     * dentro de la listaProducto
     */
	@Override
	public void guardar(@Valid Producto producto) {
		producto.setEstado(true);
	   listaProducto.save(producto);
	}
	/**
     * @method busca un elemento dentro de la lista con respecto al nombre
     * que llega como parametro en este metodo, si no se encuentra entonces
     * retorna un valor nulo
     */
	@Override
	public Producto buscar(long id){
		return listaProducto.findById(id).get();
	}
	/**
     * @method modifica un objeto Producto dentro de la listaProducto
     * 
     * */
	@Override
	public void modificar(Producto producto) {
		listaProducto.save(producto);
	}	
	/**
     * @method elimina un objeto producto dentro de la listaProducto
     */
	@Override
	public void eliminar(Producto productoEncontrado) {
		productoEncontrado.setEstado(false);
		listaProducto.save(productoEncontrado);
	}
	/**
     * @method retorna un objeto producto
     */
	@Override
	public Producto getProducto() {
		return producto;
	}
}