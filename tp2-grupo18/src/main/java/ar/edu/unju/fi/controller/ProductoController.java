package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.model.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {
   
	/** 
	 * Inyeccion de dependencia, para utilizar el objeto de la clase
	 * sin necesidad de instanciar**/
	@Autowired
	private IProductoService productoService;
	
	/**
	 * metodo getMapping para responder a una peticion /productos/
	 * listadoProductos que muestra una pagina llamada "Productos"
	 * antes de cargar la lista de productos al model y este ser usado
	 * en la pagina de return, calcula el descuento de todos los objetos
	 * de la lista antes de enviarse **/
	
	@GetMapping("/listadoProductos")
	public String getProductoPage(Model model) {
		model.addAttribute("producto",productoService.getListaProductos());
		return "Productos";
	}
	/** 
	 * metodo getMapping simple para mostrar una pagina "nuevo_producto"
	 * enviando atravez del model un objeto tipo Producto para ser utilizado**/
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("producto", productoService.getProducto());
		return "nuevo_producto"; 
	}
	/** 
	 * metodo postMapping obtiene un objeto de tipo producto para luego
	 * asignarlo dentro de la listaPro para su actualizacion y ser mostrado
	 * en la pagina "Producto",antes de eso tambien se obtienen los errores ocurridos
	 * y si estos ocurrieron al momento de querer mandar un objeto, se volvera a 
	 * solicitar el ingreso de el objeto (por lo que no se cambia de pagina)**/
	@PostMapping("/guardar")
	public ModelAndView getGuardarProducto(@Valid @ModelAttribute("producto")Producto prod, BindingResult result) {
		ModelAndView mav = new ModelAndView("Productos");
		if(result.hasErrors()){
			mav.setViewName("nuevo_producto");
			mav.addObject("producto",prod);
			return mav;
		}
		productoService.guardar(prod);
		mav.addObject("producto",productoService.getListaProductos());
		return mav;
	}
	@GetMapping("/modificar/{nombre}")
	public String getModificarProductoPage(Model model, @PathVariable(value="nombre")String nombre){
		boolean edicion = true;
		Producto productoEncontrado = productoService.buscar(nombre);
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);				
		return "nuevo_producto";
	}
	@PostMapping("/modificar")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto prod, BindingResult result) {
		productoService.modificar(prod);
		return "redirect:/productos/listadoProductos";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String eliminarProducto(@PathVariable(value="nombre")String nombre) {		
		
		productoService.eliminar(productoService.buscar(nombre));
		return "redirect:/productos/listadoProductos";
	}
}