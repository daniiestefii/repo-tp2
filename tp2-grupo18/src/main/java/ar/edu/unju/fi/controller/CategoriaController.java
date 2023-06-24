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
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorias")

public class CategoriaController{
    
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/listadoCategoria")
	public String getCategoriaPage(Model model){
		model.addAttribute("categorias",categoriaService.getListaCategoria());
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoCategoriaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("categoria", categoriaService.getCategoria());
		return "nuevo_categoria";	
	}
	
	
	@PostMapping("/guardar")
	public String getGuardarCategoria(@Valid @ModelAttribute("categoria")Categoria cate, BindingResult result,Model model){
		boolean edicion = false;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("categoria",cate);
			return "nuevo_categoria";
		}
		categoriaService.guardar(cate);
		return "redirect:/gestionDatos";
	}
	
	
	@GetMapping("/modificar/{id}")
	public String getModificarCategoriaPage(Model model, @PathVariable(value="id")long id){
		boolean edicion = true;
		Categoria categoriaEncontrado = categoriaService.buscar(id);
		model.addAttribute("categoria", categoriaEncontrado);
		model.addAttribute("edicion", edicion);	
		return "nuevo_categoria";
	}
	
	@PostMapping("/modificar")
	public String modificarCategoria(@Valid @ModelAttribute("categoria")Categoria cate, BindingResult result,Model model) {
		boolean edicion = true;
		if(result.hasErrors()){
			model.addAttribute("edicion",edicion);
			model.addAttribute("categoria",cate);
			return "nuevo_categoria";
		}
		categoriaService.modificar(cate);
		return "redirect:/gestionDatos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(value="id")long id){		
		categoriaService.eliminar(categoriaService.buscar(id));
		return "redirect:/gestionDatos";
	}
}