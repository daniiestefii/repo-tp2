package ar.edu.unju.fi.repository;

import java.util.List;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.controller.entity.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal,Long>{
    public List<Sucursal> findByEstado(boolean estado);
    public List<Sucursal> findByProvinciaAndEstado(Provincia provincia, boolean estado);
}
