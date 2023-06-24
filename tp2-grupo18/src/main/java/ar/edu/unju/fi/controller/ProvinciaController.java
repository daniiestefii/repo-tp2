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
import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.service.IProvinciaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/provincias")
public class ProvinciaController{
    
	@Autowired
	private IProvinciaService provinciaService;
	
	@GetMapping("/listadoProvincia")
	public String getProvinciaPage(Model model){
		model.addAttribute("provincia",provinciaService.getListaProvincia());
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProvinciaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("provincia", provinciaService.getProvincia());
		return "nuevo_provincia";	
	}
	
	
	@PostMapping("/guardar")
	public String getGuardarProvincia(@Valid @ModelAttribute("provincia")Provincia prov, BindingResult result,Model model){
		boolean edicion = false;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("provincia",prov);
			return "nuevo_provincia";
		}
		provinciaService.guardar(prov);
		return "redirect:/gestionDatos";
	}
	
	
	@GetMapping("/modificar/{id}")
	public String getModificarProvinciaPage(Model model, @PathVariable(value="id")Long id){
		boolean edicion = true;
		Provincia provinciaEncontrado = provinciaService.buscar(id);
		model.addAttribute("provincia", provinciaEncontrado);
		model.addAttribute("edicion", edicion);	
		return "nuevo_provincia";
	}
	
	@PostMapping("/modificar")
	public String modificarProvincia(@Valid @ModelAttribute("provincia")Provincia prov, BindingResult result,Model model) {
		boolean edicion = false;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("provincia",prov);
			return "nuevo_provincia";
		}
		provinciaService.modificar(prov);
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(value="id")Long id){		
		provinciaService.eliminar(provinciaService.buscar(id));
		return "redirect:/gestionDatos";
	}
}