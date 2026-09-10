package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.EstadoEquipo;
import aplicacionesweb.proyectoinventario.repository.EstadoEquipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstadoEquipoService {

    private final EstadoEquipoRepository repository;

    public EstadoEquipoService(EstadoEquipoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<EstadoEquipo> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<EstadoEquipo> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public EstadoEquipo guardar(EstadoEquipo estadoEquipo) {
        return repository.save(estadoEquipo);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
