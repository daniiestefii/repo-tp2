package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Noticia;
import ar.edu.unju.fi.repository.INoticiaRepository;
import ar.edu.unju.fi.service.INoticiaService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NoticiaServiceImp")
public class NoticiaServiceImp implements INoticiaService{
	
	@Autowired
	private INoticiaRepository listaNoticia;
	@Autowired
	private Noticia noticia;
	/**
     * 
     */
	public List<Noticia> getListaNoticias(){
		return listaNoticia.findByEstado(true);
	}
	/**
     * 
     */
	public void guardar(@Valid Noticia noticia) {
		noticia.setEstado(true);
		listaNoticia.save(noticia);
	}
	/**
     * 
     */
	public Noticia buscar(Long id) {
		return listaNoticia.findById(id).get();
	}
	/**
     * 
     */
	public void modificar(Noticia noticia) {
		listaNoticia.save(noticia);
	}
	/**
     * 
     */
	public void eliminar(Noticia noticiaEncontrado) {
		noticiaEncontrado.setEstado(false);
		listaNoticia.save(noticiaEncontrado);
	}
	/**
     * 
     */
	public Noticia getNoticia(){
	  return noticia;
	}
}