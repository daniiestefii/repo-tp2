package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.controller.entity.Categoria;
public interface ICategoriaService {
	/**
     * @method Devuelve una lista de todos los categoria
     */
    List<Categoria>getListaCategoria();
    /**
     * @method Guarda una nueva categoria
     */
    void guardar(Categoria categoria);
    /**
     * @method  Devuelve una categoria cuyo id coincide con el parámetro id.
     */
    Categoria buscar(long id);
    /**
     * @method Modifica una categoria existente
     */
    void modificar(Categoria categoria);
    /**
     * @method Elimina una categoria existente
     */
    void eliminar(Categoria categoriaEncontrado);
    /**
     * @method Devuelve un nuevo objeto categoria
     */
    Categoria getCategoria();

}
