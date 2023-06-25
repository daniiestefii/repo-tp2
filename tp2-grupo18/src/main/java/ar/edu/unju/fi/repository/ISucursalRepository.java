package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unju.fi.controller.entity.Provincia;
import ar.edu.unju.fi.controller.entity.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal,Long>{
    public List<Sucursal> findByEstado(boolean estado);
    @Query("SELECT e FROM Sucursal e WHERE e.fechainicio BETWEEN :startDate AND :endDate")
    List<Sucursal> findByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
