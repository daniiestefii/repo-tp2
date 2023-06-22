package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.controller.entity.Categoria;

import jakarta.validation.Valid;
public interface ICategoriaService {

    List<Categoria>getListaCategoria();
    
    void guardar(@Valid Categoria categoria);
    
    Categoria buscar(long id);
   
    void modificar(Categoria categoria);
    
    void eliminar(Categoria categoriaEncontrado);
    
    Categoria getCategoria();

}
