package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.model.Consejo;
import jakarta.validation.Valid;

import java.util.List;

/**
 * @author DOrdonez
 */
public interface IConsejoService {
    /**
     * @method Devuelve una lista de todos los consejos existentes
     */
    List<Consejo> getListaConsejo();


    /**
     * @method Guarda un nuevo consejo
     */
    void guardar(@Valid Consejo consejo);

    /**
     * @method  Devuelve el consejo cuyo título coincide con el parámetro titulo.
     */
    Consejo getBy(String titulo);

    /**
     * @method Modifica un consejo existente
     */
    void modificar(Consejo consejo);

    /**
     * @method Elimina un consejo existente
     */
    void eliminar(Consejo consejo);

    /**
     * @method Devuelve un nuevo objeto Consejo
     */
    Consejo getConsejo();

}
