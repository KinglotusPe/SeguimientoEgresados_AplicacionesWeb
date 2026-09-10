package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Despacho;
import aplicacionesweb.proyectoinventario.service.DespachoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despachos")
@CrossOrigin(origins = "*")
public class DespachoController {

    private final DespachoService service;

    public DespachoController(DespachoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Despacho>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despacho> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sede/{idSede}")
    public ResponseEntity<List<Despacho>> listarPorSede(@PathVariable Integer idSede) {
        return ResponseEntity.ok(service.listarPorSede(idSede));
    }

    @PostMapping
    public ResponseEntity<Despacho> crear(@RequestBody Despacho despacho) {
        Despacho nuevo = service.guardar(despacho);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despacho> actualizar(@PathVariable Integer id, @RequestBody Despacho despacho) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    despacho.setIdDespacho(id);
                    return ResponseEntity.ok(service.guardar(despacho));
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
