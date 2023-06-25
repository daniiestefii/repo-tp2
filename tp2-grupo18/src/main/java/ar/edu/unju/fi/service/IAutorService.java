package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Autor;

import java.util.List;

public interface IAutorService {
    /**
     * @method Devuelve una lista de todos los Autores
     */
    List<Autor> getListaAutores();
    /**
     * @method Guarda un nuevo Autor
     */
    void guardar(Autor autor);
    /**
     * @method  Devuelve el Autor cuyo id coincide con el parámetro id.
     */
    Autor buscar(Long id);
    /**
     * @method Modifica un Autor existente
     */
    void modificar(Autor autor);
    /**
     * @method Elimina un Autor existente
     */
    void eliminar(Autor autorEncontrado);
    /**
     * @method Devuelve un nuevo objeto Autor
     */
    Autor getAutor();

}
