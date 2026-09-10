package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Sede;
import aplicacionesweb.proyectoinventario.repository.SedeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SedeService {

    private final SedeRepository repository;

    public SedeService(SedeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Sede> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Sede> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Sede> listarPorDistritoFiscal(Integer idDistritoFiscal) {
        return repository.findByDistritoFiscalIdDistritoFiscal(idDistritoFiscal);
    }

    public Sede guardar(Sede sede) {
        return repository.save(sede);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
