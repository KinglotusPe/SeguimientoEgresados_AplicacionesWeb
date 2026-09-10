package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.TipoPersonal;
import aplicacionesweb.proyectoinventario.repository.TipoPersonalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoPersonalService {

    private final TipoPersonalRepository repository;

    public TipoPersonalService(TipoPersonalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TipoPersonal> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TipoPersonal> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public TipoPersonal guardar(TipoPersonal tipoPersonal) {
        return repository.save(tipoPersonal);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
