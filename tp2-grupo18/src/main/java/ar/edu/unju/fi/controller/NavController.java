package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.INoticiaService;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.IServicioService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;
@Controller
public class NavController {

	@Autowired
	//@Qualifier("IProductoService")
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