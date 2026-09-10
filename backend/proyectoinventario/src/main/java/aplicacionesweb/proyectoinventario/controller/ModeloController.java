package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Modelo;
import aplicacionesweb.proyectoinventario.service.ModeloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {

    private final ModeloService service;

    public ModeloController(ModeloService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/marca/{idMarca}")
    public ResponseEntity<List<Modelo>> listarPorMarca(@PathVariable Integer idMarca) {
        return ResponseEntity.ok(service.listarPorMarca(idMarca));
    }

    @PostMapping
    public ResponseEntity<Modelo> crear(@RequestBody Modelo modelo) {
        Modelo nuevo = service.guardar(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> actualizar(@PathVariable Integer id, @RequestBody Modelo modelo) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    modelo.setIdModelo(id);
                    return ResponseEntity.ok(service.guardar(modelo));
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
