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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.controller.entity.Producto;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;
/**
 * @model Producto
 * @author DOrdonez, MiltonDelgado
 */
@Controller
@RequestMapping("/productos")

public class ProductoController {
    
	/** servicio*/
	@Autowired
	private IProductoService productoService;
	@Autowired
	/** servicio*/
	private ICategoriaService categoriaService;
	/** metodo de filtrado que muestra la misma pagina de donde se lo utiliza
	 * pero con la diferencia de los objetos a listar de la tabla*/
	@GetMapping("/filtradoProductos")
	public String getfiltradoProductoPage(@RequestParam("categoria") Categoria categoria ,Model model) {
		model.addAttribute("producto", productoService.getListaProductosFiltrados(categoria,true));
		model.addAttribute("categorias",categoriaService.getListaCategoria());
		return "Productos";
	}
	
	/**
	 * 
	 * metodo getMapping para responder a una peticion /productos/
	 * listadoProductos que muestra una pagina llamada "Productos"
	 * antes de cargar la lista de productos al model y este ser usado
	 * en la pagina de return, calcula el descuento de todos los objetos
	 * de la lista antes de enviarse
	 *  
	 * **/
	
	@GetMapping("/listadoProductos")
	public String getProductoPage(Model model){
		model.addAttribute("producto",productoService.getListaProductos());
		model.addAttribute("categorias",categoriaService.getListaCategoria());
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
		model.addAttribute("categorias", categoriaService.getListaCategoria());
		return "nuevo_producto";	
	}
	/**
	 *  
	 * metodo postMapping obtiene un objeto de tipo producto para luego
	 * asignarlo dentro de la listaPro para su actualizacion y ser mostrado
	 * en la pagina "Producto",antes de eso tambien se obtienen los errores ocurridos
	 * y si estos ocurrieron al momento de querer mandar un objeto, se volvera a 
	 * solicitar el ingreso de el objeto (por lo que no se cambia de pagina)
	 * 
	 * **/
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProducto(@Valid @ModelAttribute("producto")Producto prod, BindingResult result){
		ModelAndView mav = new ModelAndView("Productos");
		if(result.hasErrors()){
			mav.setViewName("nuevo_producto");
			mav.addObject("producto",prod);
			mav.addObject("categorias",categoriaService.getListaCategoria());
			return mav;
		}
		productoService.guardar(prod);
		mav.addObject("producto",productoService.getListaProductos());
		mav.addObject("categorias",categoriaService.getListaCategoria());
		return mav;
	}
	
	/**
     * @method responde a la peticion de un boton de enlace de la pagina
     * "Productos" donde adjunta el nombre del objeto de la lista listado.
     * el nombre es utilizado como parametro para realizar una busqueda
     * dentro de la lista y poder enviarlo por el model a un formulario
     * para poder modificarlo 
     */
	@GetMapping("/modificar/{nombre}")
	public String getModificarProductoPage(Model model, @PathVariable(value="nombre")long nombre){
		boolean edicion = true;
		Producto productoEncontrado = productoService.buscar(nombre);
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);	
		model.addAttribute("categorias", categoriaService.getListaCategoria());
		return "nuevo_producto";
	}
	/**
     * @method tras recibir el objeto el objeto modificado este actualiza
     * dicho objeto que pertence a la lista. la busqueda se realiza mediante
     * el nombre del objeto en la lista.
     */
	@PostMapping("/modificar")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto prod, BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("producto",prod);
			model.addAttribute("categorias", categoriaService.getListaCategoria());
			return "nuevo_producto";
		}
		productoService.modificar(prod);
		return "redirect:/productos/listadoProductos";
	}
	/**
     * @method elimina un objeto dentro de la lista tomando como referencia
     * de identificador el nombre que viene con la peticion a la cual
     * este metodo responde
     */
	@GetMapping("/eliminar/{nombre}")
	public String eliminarProducto(@PathVariable(value="nombre")long nombre){		
		productoService.eliminar(productoService.buscar(nombre));
		return "redirect:/productos/listadoProductos";
	}
}