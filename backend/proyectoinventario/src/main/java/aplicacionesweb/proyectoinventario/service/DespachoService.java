package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Despacho;
import aplicacionesweb.proyectoinventario.repository.DespachoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DespachoService {

    private final DespachoRepository repository;

    public DespachoService(DespachoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Despacho> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Despacho> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Despacho> listarPorSede(Integer idSede) {
        return repository.findBySedeIdSede(idSede);
    }

    public Despacho guardar(Despacho despacho) {
        return repository.save(despacho);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
