package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Provincia;
import jakarta.validation.Valid;

import java.util.List;

public interface IProvinciaService {
    /**
     * @method Devuelve una lista de todos las Provincias
     */
    List<Provincia> getListaProvincia();
    /**
     * @method Guarda una nueva Provincia
     */
    void guardar(@Valid Provincia provincia);
    /**
     * @method  Devuelve la Provincia cuyo id coincide con el parámetro id.
     */
    Provincia buscar(Long id);
    /**
     * @method Modifica una Provincia existente
     */
    void modificar(Provincia provincia);
    /**
     * @method Elimina una Provincia existente
     */
    void eliminar(Provincia provinciaEncontrado);
    /**
     * @method Devuelve un nuevo objeto Provincia
     */
    Provincia getProvincia();

}
