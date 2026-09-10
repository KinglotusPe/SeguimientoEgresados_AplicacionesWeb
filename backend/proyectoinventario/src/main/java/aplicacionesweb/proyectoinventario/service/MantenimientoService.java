package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Mantenimiento;
import aplicacionesweb.proyectoinventario.repository.MantenimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MantenimientoService {

    private final MantenimientoRepository repository;

    public MantenimientoService(MantenimientoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Mantenimiento> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Mantenimiento> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Mantenimiento> listarPorEquipo(Integer idEquipo) {
        return repository.findByEquipoIdEquipo(idEquipo);
    }

    public Mantenimiento guardar(Mantenimiento mantenimiento) {
        return repository.save(mantenimiento);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
