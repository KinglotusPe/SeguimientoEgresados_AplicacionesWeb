package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.UsuarioRol;
import aplicacionesweb.proyectoinventario.repository.UsuarioRolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioRolService {

    private final UsuarioRolRepository repository;

    public UsuarioRolService(UsuarioRolRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioRol> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<UsuarioRol> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<UsuarioRol> listarPorUsuario(Integer idUsuario) {
        return repository.findByUsuarioIdUsuario(idUsuario);
    }

    public UsuarioRol guardar(UsuarioRol usuarioRol) {
        return repository.save(usuarioRol);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
