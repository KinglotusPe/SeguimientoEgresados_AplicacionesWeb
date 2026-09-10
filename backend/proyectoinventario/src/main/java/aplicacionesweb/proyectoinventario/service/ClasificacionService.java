package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Clasificacion;
import aplicacionesweb.proyectoinventario.repository.ClasificacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClasificacionService {

    private final ClasificacionRepository repository;

    public ClasificacionService(ClasificacionRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Clasificacion> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Clasificacion> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Clasificacion guardar(Clasificacion clasificacion) {
        return repository.save(clasificacion);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
