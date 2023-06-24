package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Noticia;
import jakarta.validation.Valid;

import java.util.List;

public interface INoticiaService {
    /**
     * @method Devuelve una lista de todos los Noticias
     */
    List<Noticia> getListaNoticias();
    /**
     * @method Guarda un nuevo Noticia
     */
    void guardar(@Valid Noticia noticia);
    /**
     * @method  Devuelve una Noticia cuyo id coincide con el parámetro id.
     */
    Noticia buscar(long id);
    /**
     * @method Modifica un Noticia existente
     */
    void modificar(Noticia noticia);
    /**
     * @method Elimina una noticia existente
     */
    void eliminar(Noticia noticiaEncontrado);
    /**
     * @method Devuelve un nuevo objeto Noticia
     */
    Noticia getNoticia();

}
