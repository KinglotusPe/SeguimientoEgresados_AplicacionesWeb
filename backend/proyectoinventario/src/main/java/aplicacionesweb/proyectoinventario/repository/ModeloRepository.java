package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
    List<Modelo> findByMarcaIdMarca(Integer idMarca);
}
