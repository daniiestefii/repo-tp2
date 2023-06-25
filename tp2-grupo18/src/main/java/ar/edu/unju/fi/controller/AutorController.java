package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.controller.entity.Autor;
import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.service.IAutorService;
import ar.edu.unju.fi.service.IProvinciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {
	/** servicio*/
	@Autowired
	private IAutorService autorService;
	
	@GetMapping("/listadoAutores")
	public String getAutorPage(Model model){
		model.addAttribute("autor",autorService.getListaAutores());
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoAutorPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("autor", autorService.getAutor());
		return "nuevo_autor";
	}
	
	
	@PostMapping("/guardar")
	public String getGuardarAutor(@Valid @ModelAttribute("autor") Autor autor, BindingResult result, Model model){
		boolean edicion = false;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("autor",autor);
			return "nuevo_autor";
		}
		autorService.guardar(autor);
		return "redirect:/gestionDatos";
	}
	
	
	@GetMapping("/modificar/{id}")
	public String getModificarAutorPage(Model model, @PathVariable(value="id")Long id){
		boolean edicion = true;
		Autor autorEncontrado = autorService.buscar(id);
		model.addAttribute("autor", autorEncontrado);
		model.addAttribute("edicion", edicion);	
		return "nuevo_autor";
	}
	
	@PostMapping("/modificar")
	public String modificarAutor(@Valid @ModelAttribute("autor")Autor autor, BindingResult result,Model model) {
		boolean edicion = false;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("autor",autor);
			return "nuevo_autor";
		}
		autorService.modificar(autor);
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarAutor(@PathVariable(value="id")Long id){
		autorService.eliminar(autorService.buscar(id));
		return "redirect:/gestionDatos";
	}
}