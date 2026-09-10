package aplicacionesweb.proyectoinventario.repository;

import aplicacionesweb.proyectoinventario.entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {
    List<UsuarioRol> findByUsuarioIdUsuario(Integer idUsuario);
}
