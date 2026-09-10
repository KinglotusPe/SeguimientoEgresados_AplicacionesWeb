package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Personal;
import aplicacionesweb.proyectoinventario.service.PersonalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal")
@CrossOrigin(origins = "*")
public class PersonalController {

    private final PersonalService service;

    public PersonalController(PersonalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Personal>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Personal> obtenerPorDni(@PathVariable String dni) {
        return service.obtenerPorDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personal> crear(@RequestBody Personal personal) {
        Personal nuevo = service.guardar(personal);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> actualizar(@PathVariable Integer id, @RequestBody Personal personal) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    personal.setIdPersonal(id);
                    return ResponseEntity.ok(service.guardar(personal));
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
