package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Noticia;
import jakarta.validation.Valid;

import java.util.List;


public interface INoticiaService{
	/**
     * @method Devuelve una lista de todas las noticias
     */
	List<Noticia> getListaNoticias();
	/**
     * @method Guarda una noticia
     */
	void guardar(@Valid Noticia noticia);
	/**
     * @method  Devuelve la noticia cuyo nombre coincide con el parámetro nombre.
     */
	Noticia buscar(Long id);
	/**
     * @method Modifica una noticia existente
     */
	void modificar(Noticia noticia);
	/**
     * @method Elimina una noticia existente
     */
	void eliminar(Noticia noticiaEncontrado);
	/**
     * @method Devuelve un nuevo objeto noticia
     */
	Noticia getNoticia();
	
}
