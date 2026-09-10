package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Modelo;
import aplicacionesweb.proyectoinventario.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ModeloService {

    private final ModeloRepository repository;

    public ModeloService(ModeloRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Modelo> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Modelo> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Modelo> listarPorMarca(Integer idMarca) {
        return repository.findByMarcaIdMarca(idMarca);
    }

    public Modelo guardar(Modelo modelo) {
        return repository.save(modelo);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
