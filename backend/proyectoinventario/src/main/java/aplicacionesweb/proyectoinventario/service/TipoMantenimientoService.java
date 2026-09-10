package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.TipoMantenimiento;
import aplicacionesweb.proyectoinventario.repository.TipoMantenimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoMantenimientoService {

    private final TipoMantenimientoRepository repository;

    public TipoMantenimientoService(TipoMantenimientoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TipoMantenimiento> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TipoMantenimiento> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public TipoMantenimiento guardar(TipoMantenimiento tipoMantenimiento) {
        return repository.save(tipoMantenimiento);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
