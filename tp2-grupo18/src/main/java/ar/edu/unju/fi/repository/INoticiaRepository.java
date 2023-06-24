package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.controller.entity.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoticiaRepository extends CrudRepository<Noticia,Long>{
    List<Noticia> findByEstado(boolean estado);
    //public List<Sucursal> findByProvinciaAndEstado(Provincia provincia, boolean estado);
}
