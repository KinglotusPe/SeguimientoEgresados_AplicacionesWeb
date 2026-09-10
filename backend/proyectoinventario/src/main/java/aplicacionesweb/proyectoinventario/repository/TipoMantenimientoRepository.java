package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.TipoMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMantenimientoRepository extends JpaRepository<TipoMantenimiento, Integer> {
}
