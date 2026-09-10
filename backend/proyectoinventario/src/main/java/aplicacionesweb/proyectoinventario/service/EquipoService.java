package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Equipo;
import aplicacionesweb.proyectoinventario.repository.EquipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipoService {

    private final EquipoRepository repository;

    public EquipoService(EquipoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Equipo> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Equipo> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Equipo> obtenerPorCodigoPatrimonial(String codigoPatrimonial) {
        return repository.findByCodigoPatrimonial(codigoPatrimonial);
    }

    @Transactional(readOnly = true)
    public Optional<Equipo> obtenerPorNumeroSerie(String numeroSerie) {
        return repository.findByNumeroSerie(numeroSerie);
    }

    public Equipo guardar(Equipo equipo) {
        return repository.save(equipo);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
