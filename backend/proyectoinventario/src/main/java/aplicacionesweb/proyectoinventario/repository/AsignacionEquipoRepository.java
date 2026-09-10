package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.AsignacionEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionEquipoRepository extends JpaRepository<AsignacionEquipo, Integer> {
    List<AsignacionEquipo> findByEquipoIdEquipo(Integer idEquipo);
    List<AsignacionEquipo> findByPersonalIdPersonal(Integer idPersonal);
    List<AsignacionEquipo> findByDespachoIdDespacho(Integer idDespacho);
}
