package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.controller.entity.Noticia;

@Repository
public interface INoticiaRepository extends CrudRepository<Noticia,Long>{
     public List<Noticia> findByEstado(boolean estado);
}
