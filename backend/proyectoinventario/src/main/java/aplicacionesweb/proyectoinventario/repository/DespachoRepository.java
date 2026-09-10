package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Integer> {
    List<Despacho> findBySedeIdSede(Integer idSede);
}
