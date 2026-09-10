package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Mantenimiento;
import aplicacionesweb.proyectoinventario.service.MantenimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
@CrossOrigin(origins = "*")
public class MantenimientoController {

    private final MantenimientoService service;

    public MantenimientoController(MantenimientoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Mantenimiento>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantenimiento> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipo/{idEquipo}")
    public ResponseEntity<List<Mantenimiento>> listarPorEquipo(@PathVariable Integer idEquipo) {
        return ResponseEntity.ok(service.listarPorEquipo(idEquipo));
    }

    @PostMapping
    public ResponseEntity<Mantenimiento> crear(@RequestBody Mantenimiento mantenimiento) {
        Mantenimiento nuevo = service.guardar(mantenimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantenimiento> actualizar(@PathVariable Integer id, @RequestBody Mantenimiento mantenimiento) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    mantenimiento.setIdMantenimiento(id);
                    return ResponseEntity.ok(service.guardar(mantenimiento));
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
