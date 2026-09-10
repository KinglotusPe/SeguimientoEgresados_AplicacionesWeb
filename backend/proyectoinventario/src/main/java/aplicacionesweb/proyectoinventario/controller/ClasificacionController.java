package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Clasificacion;
import aplicacionesweb.proyectoinventario.service.ClasificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clasificaciones")
@CrossOrigin(origins = "*")
public class ClasificacionController {

    private final ClasificacionService service;

    public ClasificacionController(ClasificacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Clasificacion>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clasificacion> crear(@RequestBody Clasificacion clasificacion) {
        Clasificacion nuevo = service.guardar(clasificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clasificacion> actualizar(@PathVariable Integer id, @RequestBody Clasificacion clasificacion) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    clasificacion.setIdClasificacion(id);
                    return ResponseEntity.ok(service.guardar(clasificacion));
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
