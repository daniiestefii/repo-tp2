package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.controller.entity.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends CrudRepository<Autor,Long> {
    public List<Autor> findByEstado(boolean estado);
}
