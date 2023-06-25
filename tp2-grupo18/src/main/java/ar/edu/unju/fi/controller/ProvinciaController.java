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
import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.service.IProvinciaService;
import jakarta.validation.Valid;
/**
 * @model Provincia
 * @author DOrdonez, MiltonDelgado
 */
@Controller
@RequestMapping("/provincias")
public class ProvinciaController {

	@Autowired
	private IProvinciaService provinciaService;

	/**
	 * Muestra la página con el listado de provincias.
	 *
	 * @param model Modelo utilizado para enviar datos a la vista.
	 * @return La vista "gestionDatos".
	 */
	@GetMapping("/listadoProvincia")
	public String getProvinciaPage(Model model) {
		model.addAttribute("provincia", provinciaService.getListaProvincias());
		return "redirect:/gestionDatos";
	}

	/**
	 * Muestra la página para crear una nueva provincia.
	 *
	 * @param model Modelo utilizado para enviar datos a la vista.
	 * @return La vista "nuevo_provincia".
	 */
	@GetMapping("/nuevo")
	public String getNuevoProvinciaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("provincia", provinciaService.getProvincia());
		return "nuevo_provincia";
	}

	/**
	 * Guarda una nueva provincia o actualiza una existente.
	 *
	 * @param prov   El objeto Provincia a guardar o actualizar.
	 * @param result Objeto BindingResult que contiene los resultados de la validación.
	 * @param model  Modelo utilizado para enviar datos a la vista.
	 * @return Redirige a la vista "gestionDatos" si la operación es exitosa, de lo contrario, vuelve a la vista "nuevo_provincia".
	 */
	@PostMapping("/guardar")
	public String getGuardarProvincia(@Valid @ModelAttribute("provincia") Provincia prov, BindingResult result, Model model) {
		boolean edicion = false;
		if (result.hasErrors()) {
			model.addAttribute("edicion", edicion);
			model.addAttribute("provincia", prov);
			return "nuevo_provincia";
		}
		provinciaService.guardar(prov);
		return "redirect:/gestionDatos";
	}

	/**
	 * Muestra la página para modificar una provincia existente.
	 *
	 * @param model Modelo utilizado para enviar datos a la vista.
	 * @param id    ID de la provincia a modificar.
	 * @return La vista "nuevo_provincia".
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarProvinciaPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Provincia provinciaEncontrado = provinciaService.buscar(id);
		model.addAttribute("provincia", provinciaEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_provincia";
	}

	/**
	 * Modifica una provincia existente.
	 *
	 * @param prov   El objeto Provincia a modificar.
	 * @param result Objeto BindingResult que contiene los resultados de la validación.
	 * @param model  Modelo utilizado para enviar datos a la vista.
	 * @return Redirige a la vista "gestionDatos" si la operación es exitosa, de lo contrario, vuelve a la vista "nuevo_provincia".
	 */
	@PostMapping("/modificar")
	public String modificarProvincia(@Valid @ModelAttribute("provincia") Provincia prov, BindingResult result, Model model) {
		boolean edicion = false;
		if (result.hasErrors()) {
			model.addAttribute("edicion", edicion);
			model.addAttribute("provincia", prov);
			return "nuevo_provincia";
		}
		provinciaService.modificar(prov);
		return "redirect:/gestionDatos";
	}

	/**
	 * Elimina una provincia existente.
	 *
	 * @param id ID de la provincia a eliminar.
	 * @return Redirige a la vista "gestionDatos" después de eliminar la provincia.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarProvincia(@PathVariable(value = "id") Long id) {
		provinciaService.eliminar(provinciaService.buscar(id));
		return "redirect:/gestionDatos";
	}
}
