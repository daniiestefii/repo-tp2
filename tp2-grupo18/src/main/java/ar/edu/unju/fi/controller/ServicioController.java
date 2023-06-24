package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.controller.entity.Servicio;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private Servicio servicio;

	@Autowired
	private IServicioService servicioService;
     
	@Autowired
	private IEmpleadoService empleadoService;

	
	@GetMapping("/filtradoServicios")
	public String getfiltradoServicioPage(@RequestParam("dia") String dia ,Model model) {
		model.addAttribute("servicio", servicioService.getListaServicioFiltrados(dia));
		return "TablaServicios";
	}
	/**
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a
	 * la ruta "/listadoServicios".
	 * Devuelve la vista "TablaServicios" con un modelo que contiene una lista de
	 * servicios".
	 *
	 * @param model:el objeto de modelo al que se agrega la lista de servicios
	 * @return el nombre de vista "TablaServicios"
	 */
	@GetMapping("/listadoServicios")
	public String getServicioPage(Model model) {
		model.addAttribute("servicio",servicioService.getListaServicio());
		return "TablaServicios";
	}

	/**
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/nuevo".
	 * Devuelve la vista "nuevo_servicio" con un modelo que contiene un objeto "servicio".
	 *
	 * @param model:el objeto de modelo al que se agrega el objeto "servicio"
	 * @return el nombre de vista "nuevo_servicio"
	 */
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicionServicio", edicion);
		model.addAttribute("servicio",servicio);
		model.addAttribute("empleados", empleadoService.getListaEmpleado());
		return "nuevo_servicio"; 
	}

	/**
	 * Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la ruta "/guardar".
	 * Agrega un objeto "serv" a una lista de servicios en un objeto "listaSer".
	 * Devuelve la vista "TablaServicios" con un modelo que contiene la lista actualizada de servicios.
	 *
	 * @param serv:el objeto de servicio que se agrega a la lista de servicios
	 * @return el objeto ModelAndView que contiene la vista "TablaServicios" y el modelo actualizado
	 *  de servicios
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarProducto(@Valid @ModelAttribute("servicio")Servicio serv, BindingResult result) {
		ModelAndView mav = new ModelAndView("TablaServicios");
		if(result.hasErrors()) {
			mav.setViewName("nuevo_servicio");
			mav.addObject("servicio",serv);
		    mav.addObject("empleados", empleadoService.getListaEmpleado());
			return mav;
		}
		servicioService.guardar(serv);
		mav.addObject("servicio",servicioService.getListaServicio());
		return mav;
	}

	/**
	 * @method responde a la peticion de un boton de enlace de la pagina
	 * "Servicio" donde adjunta el nombre del objeto de la lista listado.
	 * el nombre es utilizado como parametro para realizar una busqueda
	 * dentro de la lista y poder enviarlo por el model a un formulario
	 * para poder modificarlo
	 *
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(Model model, @PathVariable(value="id")Long id){
		boolean edicion = true;
		Servicio servicioEncontrado = servicioService.buscar(id);
		model.addAttribute("servicio",servicioEncontrado);
		model.addAttribute("edicionServicio", edicion);
		model.addAttribute("empleados", empleadoService.getListaEmpleado());
		return "nuevo_servicio";
	}
	/**
	 * @method tras recibir el objeto, el objeto modificado este actualiza
	 * dicho objeto que pertence a la lista.
	 */
	@PostMapping("/modificar")
	public String modificarServicio(@Valid @ModelAttribute("servicio")Servicio servi, BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicionServicio",edicion);
			model.addAttribute("servicio",servi);
			model.addAttribute("empleados", empleadoService.getListaEmpleado());
			return "nuevo_servicio";
		}
		servicioService.modificar(servi);
		return "redirect:/servicios/listadoServicios";
	}
	/**
	 * @method elimina un objeto dentro de la lista
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")Long id) {
		servicioService.eliminar(servicioService.buscar(id));
		return "redirect:/servicios/listadoServicios";
	}
}