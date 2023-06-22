package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.controller.entity.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado,Long> {
    public List<Empleado> findByEstado(boolean estado);
}
