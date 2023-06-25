package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.INoticiaService;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.IServicioService;
import ar.edu.unju.fi.service.ISucursalService;


/**
 * @model Nav
 * @author DOrdonez, MiltonDelgado
 */
@Controller
public class NavController {

	/** servicios*/
	@Autowired
	private IProductoService productoService;
	@Autowired
	private ICategoriaService categoriaService;
	@Autowired
	private IServicioService servicioService;
	@Autowired
	private ISucursalService sucursalService;
	@Autowired
	private INoticiaService noticiaService;
	@Autowired
	private IConsejoService consejoService;
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IProvinciaService provinciaService;
	
	/** 
	 * Metodo getMapping para acceder a la pagina html con el nombre
	 * "Formulario" simple clase @Controller
	 * **/
	@GetMapping("/formulario")
	public String getFormularioPage() {
	    
		return "Formulario";
	}
	/** metodo que devuelve la vista a GestionDatos una pagina que es utilizada
	 * para gestionar todas las entidas por lo que atravez de model se envia
	 * a la vista todos las entidades de cada tabla*/
	@GetMapping("/gestionDatos")
	public String getGestionDatos(Model model){
		model.addAttribute("producto", productoService.getListaProductos());
		model.addAttribute("servicio", servicioService.getListaServicio());
		model.addAttribute("sucursal", sucursalService.getListaSucursales());
		model.addAttribute("noticia", noticiaService.getListaNoticias());
		model.addAttribute("consejo", consejoService.getListaConsejos());
		model.addAttribute("categoria", categoriaService.getListaCategoria());
		model.addAttribute("empleado", empleadoService.getListaEmpleado());
		model.addAttribute("provincia", provinciaService.getListaProvincias());
		return "GestionDatos";
	}
}