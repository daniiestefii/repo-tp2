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
    
	/** servicio*/
	@Autowired
	private ICategoriaService categoriaService;
	/** metodo getMapping que envia a la vista una lista de objetos de
	 * la base de datos, la vista es una redireccion*/
	@GetMapping("/listadoCategoria")
	public String getCategoriaPage(Model model){
		model.addAttribute("categorias",categoriaService.getListaCategoria());
		return "redirect:/gestionDatos";
	}
	/** metodo getMapping que retorna a una pagina de formulario, donde envia a
	 * la vista una lista de entidades y un parametro util para
	 * definir el uso del formulario */
	@GetMapping("/nuevo")
	public String getNuevoCategoriaPage(Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		model.addAttribute("categoria", categoriaService.getCategoria());
		return "nuevo_categoria";	
	}
	
	/** metodo postMapping que utiliza un objeto de la vista
	 * donde, si el objeto es enviado sin errores este se guarda en
	 * la tabla mediante el servicio. si el objeto viene con errores
	 * entonces retorna la vista al formulario*/
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
	
	/** metodo getMapping que utiliza una variable enviada por la peticion
	 * la cual es utilizada para identificar el objeto dentro de una lista de
	 * la base de datos, el objeto es enviado a la vista de otra pagina para
	 * ser modificado en un formulario*/
	@GetMapping("/modificar/{id}")
	public String getModificarCategoriaPage(Model model, @PathVariable(value="id")long id){
		boolean edicion = true;
		Categoria categoriaEncontrado = categoriaService.buscar(id);
		model.addAttribute("categoria", categoriaEncontrado);
		model.addAttribute("edicion", edicion);	
		return "nuevo_categoria";
	}
	/** metodo postMapping que utiliza un objeto de la vista a la cual
	 * realiza la peticion para modificar ese mismo objeto en su tabla
	 * correspondiente, si es que no es enviado con errores el objeto de lo
	 * contrario se vuelve a enviar el mismo objeto al formulario*/
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
	/** metodo getMapping que utiliza una variable enviada por peticion
	 * este metodo simplemente busca con el parametro identificador
	 * a un determinado objeto dentro de una tabla determinada y cambia
	 * su estado a false*/
	@GetMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(value="id")long id){		
		categoriaService.eliminar(categoriaService.buscar(id));
		return "redirect:/gestionDatos";
	}
}