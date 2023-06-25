package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.controller.entity.Autor;
import ar.edu.unju.fi.service.IAutorService;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.controller.entity.Consejo;
import jakarta.validation.Valid;

/**
 * @model Consejo
 * @author DOrdonez, MiltonDelgado
 */
@Controller
@RequestMapping("/consejos")
public class ConsejoController {
	@Autowired
	private Consejo consejo;

	@Autowired
	private IConsejoService consejoService;

	@Autowired
	private IAutorService autorService;

	@Autowired
	/** servicio*/
	private ICategoriaService categoriaService;

	/** metodo de filtrado que muestra la misma pagina de donde se lo utiliza
	 * pero con la diferencia de los objetos a listar de la tabla*/
	@GetMapping("/filtradoConsejos")
	public String getfiltradoConsejoPage(@RequestParam("autor") Autor autor , Model model) {
		model.addAttribute("consejo", consejoService.getListaConsejosFiltrados(autor,true));
		model.addAttribute("autores",autorService.getListaAutores());
		return "ConsejodeSalud";
	}

	/**
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/listadoConsejos".
	 * Devuelve la vista "ConsejodeSalud" con un modelo que contiene una lista de consejos.
	 *
	 * @param model:el objeto de modelo al que se agrega la lista de consejos
	 * @return el nombre de vista "ConsejodeSalud"
	 **/
	@GetMapping("/listadoConsejos")
	public String getConsejoPage(Model model) {
		model.addAttribute("consejo", consejoService.getListaConsejos());
		model.addAttribute("autores",autorService.getListaAutores());
		model.addAttribute("categorias",categoriaService.getListaCategoria());
		return "ConsejodeSalud";
	}

	/**
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/nuevo".
	 * Devuelve la vista "nuevo_consejo" con un modelo que contiene un objeto "consejo".
	 *
	 * @param model:el objeto de modelo al que se agrega el objeto "consejo"
	 * @return el nombre de vista "nuevo_consejo"
	 **/
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", consejo);
		model.addAttribute("autores",autorService.getListaAutores());
		model.addAttribute("edicionConsejo", edicion);
		return "nuevo_consejo";
	}

	/**
	 * Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la ruta "/guardar".
	 * Agrega un objeto "consejo" a una lista de consejos".
	 * Devuelve la vista "ConsejodeSalud" con un modelo que contiene la lista actualizada de consejos.
	 *
	 * @param cons:el objeto "consejo" que se agrega a la lista de consejos
	 * @return el objeto ModelAndView que contiene la vista "ConsejodeSalud" y el modelo actualizado
	 **/
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejo(@Valid @ModelAttribute("consejo") Consejo cons, BindingResult result) {
		ModelAndView mav = new ModelAndView("ConsejodeSalud");
		if (result.hasErrors()) {
			mav.setViewName("nuevo_consejo");
			mav.addObject("consejo", cons);
			mav.addObject("autores", autorService.getListaAutores());
			return mav;
		}
		consejoService.guardar(cons);
		mav.addObject("consejo", consejoService.getListaConsejos());
		mav.addObject("autores", autorService.getListaAutores());
		return mav;
	}
	/**
	 * @method responde a la peticion de un boton de enlace de la pagina
	 * "Consejo" donde adjunta el titulo del objeto de la lista listado.
	 * el titulo es utilizado como parametro para realizar una busqueda
	 * dentro de la lista y poder enviarlo por el model a un formulario
	 * para poder modificarlo
	 *
	 */
	@GetMapping("/modificar/{titulo}")
	public String getModificarConsejo(Model model, @PathVariable(value = "titulo") Long titulo) {
		Consejo consejoencontrado = new Consejo();
		boolean edicion = true;
		consejoencontrado = consejoService.buscar(titulo);
		model.addAttribute("consejo", consejoencontrado);
		model.addAttribute("autores",autorService.getListaAutores());
		model.addAttribute("edicionConsejo", edicion);
		return "nuevo_consejo";

	}
	/**
	 * @method tras recibir el objeto, el objeto modificado este actualiza
	 * dicho objeto que pertence a la lista.
	 */
	@PostMapping("/modificar")
	public String modificarConsejo(@ModelAttribute("consejo") Consejo consejo,BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicionConsejo",edicion);
			model.addAttribute("autores",autorService.getListaAutores());
	     	model.addAttribute("consejo",consejo);
			return "nuevo_consejo";
		}
		consejoService.modificar(consejo);
		return "redirect:/consejos/listadoConsejos";
	}
	/**
	 * @method elimina un objeto dentro de la lista
	 */
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejo(@PathVariable(value="titulo")Long titulo) {
		consejoService.eliminar(consejoService.buscar(titulo));
		return "redirect:/consejos/listadoConsejos";
	}
}