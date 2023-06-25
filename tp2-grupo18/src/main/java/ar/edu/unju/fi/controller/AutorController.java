package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.controller.entity.Autor;
import ar.edu.unju.fi.service.IAutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
/**
 * @model Autores
 * @author DOrdonez,MiltonDelgado
 */
@Controller
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private IAutorService autorService;

	/**
	 * Muestra la página con el listado de autores.
	 *
	 * @param model Modelo utilizado para enviar datos a la vista.
	 * @return La vista "gestionDatos".
	 */
	@GetMapping("/listadoAutores")
	public String getAutorPage(Model model) {
		model.addAttribute("autor", autorService.getListaAutores());
		return "redirect:/gestionDatos";
	}

	/**
	 * Muestra la página para crear un nuevo autor.
	 *
	 * @param model Modelo utilizado para enviar datos a la vista.
	 * @return La vista "nuevo_autor".
	 */
	@GetMapping("/nuevo")
	public String getNuevoAutorPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("autor", autorService.getAutor());
		return "nuevo_autor";
	}

	/**
	 * Guarda un nuevo autor o actualiza uno existente.
	 *
	 * @param autor  El objeto Autor a guardar o actualizar.
	 * @param result Objeto BindingResult que contiene los resultados de la validación.
	 * @param model  Modelo utilizado para enviar datos a la vista.
	 * @return Redirige a la vista "gestionDatos" si la operación es exitosa, de lo contrario, vuelve a la vista "nuevo_autor".
	 */
	@PostMapping("/guardar")
	public String getGuardarAutor(@Valid @ModelAttribute("autor") Autor autor, BindingResult result, Model model) {
		boolean edicion = false;
		if (result.hasErrors()) {
			model.addAttribute("edicion", edicion);
			model.addAttribute("autor", autor);
			return "nuevo_autor";
		}
		autorService.guardar(autor);
		return "redirect:/gestionDatos";
	}

	/**
	 * Muestra la página para modificar un autor existente.
	 *
	 * @param model Modelo utilizado para enviar datos a la vista.
	 * @param id    ID del autor a modificar.
	 * @return La vista "nuevo_autor".
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarAutorPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Autor autorEncontrado = autorService.buscar(id);
		model.addAttribute("autor", autorEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_autor";
	}

	/**
	 * Modifica un autor existente.
	 *
	 * @param autor  El objeto Autor a modificar.
	 * @param result Objeto BindingResult que contiene los resultados de la validación.
	 * @param model  Modelo utilizado para enviar datos a la vista.
	 * @return Redirige a la vista "gestionDatos" si la operación es exitosa, de lo contrario, vuelve a la vista "nuevo_autor".
	 */
	@PostMapping("/modificar")
	public String modificarAutor(@Valid @ModelAttribute("autor") Autor autor, BindingResult result, Model model) {
		boolean edicion = false;
		if (result.hasErrors()) {
			model.addAttribute("edicion", edicion);
			model.addAttribute("autor", autor);
			return "nuevo_autor";
		}
		autorService.modificar(autor);
		return "redirect:/gestionDatos";
	}

	/**
	 * Elimina un autor existente.
	 *
	 * @param id ID del autor a eliminar.
	 * @return Redirige a la vista "gestionDatos" después de eliminar el autor.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarAutor(@PathVariable(value = "id") Long id) {
		autorService.eliminar(autorService.buscar(id));
		return "redirect:/gestionDatos";
	}
}
