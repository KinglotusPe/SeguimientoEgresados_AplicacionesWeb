package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Personal;
import aplicacionesweb.proyectoinventario.repository.PersonalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonalService {

    private final PersonalRepository repository;

    public PersonalService(PersonalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Personal> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Personal> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Personal> obtenerPorDni(String dni) {
        return repository.findByDni(dni);
    }

    public Personal guardar(Personal personal) {
        return repository.save(personal);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
