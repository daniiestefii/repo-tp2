package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.controller.entity.Provincia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinciaRepository extends CrudRepository<Provincia,Long> {
    public List<Provincia> findByEstado(boolean estado);
}
