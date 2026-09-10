package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    Optional<Equipo> findByCodigoPatrimonial(String codigoPatrimonial);
    Optional<Equipo> findByNumeroSerie(String numeroSerie);
}
