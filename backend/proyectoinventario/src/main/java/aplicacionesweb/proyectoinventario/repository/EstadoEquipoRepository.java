package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.EstadoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEquipoRepository extends JpaRepository<EstadoEquipo, Integer> {
}
