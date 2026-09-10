package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Marca;
import aplicacionesweb.proyectoinventario.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Marca> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Marca> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Marca guardar(Marca marca) {
        return repository.save(marca);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
