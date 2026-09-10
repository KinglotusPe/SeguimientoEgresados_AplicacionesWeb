package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.TipoMantenimiento;
import aplicacionesweb.proyectoinventario.service.TipoMantenimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-mantenimiento")
@CrossOrigin(origins = "*")
public class TipoMantenimientoController {

    private final TipoMantenimientoService service;

    public TipoMantenimientoController(TipoMantenimientoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoMantenimiento>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMantenimiento> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoMantenimiento> crear(@RequestBody TipoMantenimiento tipoMantenimiento) {
        TipoMantenimiento nuevo = service.guardar(tipoMantenimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMantenimiento> actualizar(@PathVariable Integer id, @RequestBody TipoMantenimiento tipoMantenimiento) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    tipoMantenimiento.setIdTipoMantenimiento(id);
                    return ResponseEntity.ok(service.guardar(tipoMantenimiento));
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
