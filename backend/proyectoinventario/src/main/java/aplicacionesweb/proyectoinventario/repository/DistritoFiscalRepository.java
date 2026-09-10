package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.DistritoFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoFiscalRepository extends JpaRepository<DistritoFiscal, Integer> {
}
