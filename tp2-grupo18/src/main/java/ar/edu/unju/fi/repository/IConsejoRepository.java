package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.controller.entity.Consejo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConsejoRepository extends CrudRepository<Consejo,Long>{
    public List<Consejo> findByEstado(boolean estado);
    //public List<Consejo> findByProvinciaAndEstado(Provincia provincia, boolean estado);
}
