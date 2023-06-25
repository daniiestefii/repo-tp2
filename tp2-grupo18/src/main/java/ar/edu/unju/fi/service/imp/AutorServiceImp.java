package ar.edu.unju.fi.service.imp;

import ar.edu.unju.fi.controller.entity.Autor;
import ar.edu.unju.fi.repository.IAutorRepository;
import ar.edu.unju.fi.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImp implements IAutorService {

    @Autowired
    private IAutorRepository autorRepository;
    @Autowired
    private Autor autor;
    @Override
    public List<Autor> getListaAutores() {return autorRepository.findByEstado(true);}

    @Override

    public void guardar(Autor autor) {
    	autor.setEstado(true);
        autorRepository.save(autor);
    }

    @Override
    public Autor buscar(Long id) {return autorRepository.findById(id).get();}

    @Override
    public void modificar(Autor autor) {autorRepository.save(autor);}

    @Override
    public void eliminar(Autor autor) {
        autor.setEstado(false);
        autorRepository.save(autor);
    }

    @Override
    public Autor getAutor() {return autor;}
}
