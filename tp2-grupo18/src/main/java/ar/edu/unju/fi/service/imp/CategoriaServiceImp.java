package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CategoriaServiceImp")
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Autowired
    private Categoria categoria;
    @Override
    public List<Categoria> getListaCategoria() {
        return categoriaRepository.findByEstado(true);
    }

    @Override
    public void guardar(Categoria categoria) {
       categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscar(long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public void modificar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminar(Categoria categoria) {
        categoria.setEstado(false);
        categoriaRepository.save(categoria);
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }
}
