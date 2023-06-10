package ar.edu.unju.fi.service;

import ar.edu.unju.fi.controller.model.Consejo;
import jakarta.validation.Valid;

import java.util.List;

public interface IConsejoService {
    List<Consejo> getListaConsejo();
    void guardar(@Valid Consejo consejo);

    Consejo getBy(String titulo);

    void modificar(Consejo consejo);

    void eliminar(Consejo consejo);

    Consejo getConsejo();

}
