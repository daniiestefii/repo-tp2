package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.entity.Provincia;
import java.util.List;

public interface IProvinciaService {
    /**
     * @method Devuelve una lista de todos los Provincias
     */
    List<Provincia> getListaProvincias();
    /**
     * @method Guarda un nuevo Provincia
     */
    void guardar(Provincia provincia);
    /**
     * @method  Devuelve el Provincia cuyo id coincide con el parámetro id.
     */
    Provincia buscar(Long id);
    /**
     * @method Modifica un Provincia existente
     */
    void modificar(Provincia provincia);
    /**
     * @method Elimina un Provincia existente
     */
    void eliminar(Provincia provinciaEncontrado);
    /**
     * @method Devuelve un nuevo objeto Provincia
     */
    Provincia getProvincia();

}
