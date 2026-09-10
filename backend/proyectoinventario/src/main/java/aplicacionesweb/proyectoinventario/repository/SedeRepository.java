package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
    List<Sede> findByDistritoFiscalIdDistritoFiscal(Integer idDistritoFiscal);
}
