package aplicacionesweb.proyectoinventario.service;

import aplicacionesweb.proyectoinventario.entity.Usuario;
import aplicacionesweb.proyectoinventario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
