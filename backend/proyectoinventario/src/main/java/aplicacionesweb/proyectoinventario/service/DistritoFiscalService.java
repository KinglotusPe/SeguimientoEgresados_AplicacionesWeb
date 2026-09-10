package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.DistritoFiscal;
import aplicacionesweb.proyectoinventario.repository.DistritoFiscalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DistritoFiscalService {

    private final DistritoFiscalRepository repository;

    public DistritoFiscalService(DistritoFiscalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<DistritoFiscal> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<DistritoFiscal> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public DistritoFiscal guardar(DistritoFiscal distritoFiscal) {
        return repository.save(distritoFiscal);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
