package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.AsignacionEquipo;
import aplicacionesweb.proyectoinventario.repository.AsignacionEquipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AsignacionEquipoService {

    private final AsignacionEquipoRepository repository;

    public AsignacionEquipoService(AsignacionEquipoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<AsignacionEquipo> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<AsignacionEquipo> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<AsignacionEquipo> listarPorEquipo(Integer idEquipo) {
        return repository.findByEquipoIdEquipo(idEquipo);
    }

    @Transactional(readOnly = true)
    public List<AsignacionEquipo> listarPorPersonal(Integer idPersonal) {
        return repository.findByPersonalIdPersonal(idPersonal);
    }

    @Transactional(readOnly = true)
    public List<AsignacionEquipo> listarPorDespacho(Integer idDespacho) {
        return repository.findByDespachoIdDespacho(idDespacho);
    }

    public AsignacionEquipo guardar(AsignacionEquipo asignacionEquipo) {
        return repository.save(asignacionEquipo);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
