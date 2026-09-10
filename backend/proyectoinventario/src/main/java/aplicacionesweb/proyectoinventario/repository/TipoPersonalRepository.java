package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.TipoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPersonalRepository extends JpaRepository<TipoPersonal, Integer> {
}
