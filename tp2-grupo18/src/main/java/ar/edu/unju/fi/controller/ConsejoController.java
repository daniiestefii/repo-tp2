package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.service.IConsejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.controller.entity.Consejo;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/consejos")
public class ConsejoController {
	@Autowired
	private Consejo consejo;

	@Autowired
	private IConsejoService consejoService;

	/**
	 * Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la ruta "/listadoConsejos".
	 * Devuelve la vista "ConsejodeSalud" con un modelo que contiene una lista de consejos.
	 *
	 * @param model:el objeto de modelo al que se agrega la lista de consejos
	 * @return el nombre de vista "ConsejodeSalud"
	 **/
	@GetMapping("/listadoConsejos")
	public String getConsejoPage(Model model) {
		model.addAttribute("consejo", consejoService.getListaConsejo());
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
			return mav;
		}
		consejoService.guardar(cons);
		mav.addObject("consejo", consejoService.getListaConsejo());
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
	public String getModificarConsejo(Model model, @PathVariable(value = "titulo") String titulo) {
		Consejo consejoencontrado = new Consejo();
		boolean edicion = true;
		consejoencontrado = consejoService.buscar(titulo);
		model.addAttribute("consejo", consejoencontrado);
		model.addAttribute("edicionConsejo", edicion);
		return "nuevo_consejo";

	}
	/**
	 * @method tras recibir el objeto, el objeto modificado este actualiza
	 * dicho objeto que pertence a la lista.
	 */
	@PostMapping("/modificar")
	public String modificarConsejo(@ModelAttribute("consejo") Consejo consejo) {
		consejoService.modificar(consejo);
		return "redirect:/consejos/listadoConsejos";
	}
	/**
	 * @method elimina un objeto dentro de la lista
	 */
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejo(@PathVariable(value="titulo")String titulo) {
		consejoService.eliminar(consejoService.buscar(titulo));
		return "redirect:/consejos/listadoConsejos";
	}
}