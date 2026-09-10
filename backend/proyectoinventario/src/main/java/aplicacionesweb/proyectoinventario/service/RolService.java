package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Rol;
import aplicacionesweb.proyectoinventario.repository.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Rol> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Rol> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Rol guardar(Rol rol) {
        return repository.save(rol);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
