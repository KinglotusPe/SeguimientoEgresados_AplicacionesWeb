package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.UsuarioRol;
import aplicacionesweb.proyectoinventario.service.UsuarioRolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-roles")
@CrossOrigin(origins = "*")
public class UsuarioRolController {

    private final UsuarioRolService service;

    public UsuarioRolController(UsuarioRolService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRol>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<UsuarioRol>> listarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(service.listarPorUsuario(idUsuario));
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> crear(@RequestBody UsuarioRol usuarioRol) {
        UsuarioRol nuevo = service.guardar(usuarioRol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRol> actualizar(@PathVariable Integer id, @RequestBody UsuarioRol usuarioRol) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    usuarioRol.setIdUsuarioRol(id);
                    return ResponseEntity.ok(service.guardar(usuarioRol));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
