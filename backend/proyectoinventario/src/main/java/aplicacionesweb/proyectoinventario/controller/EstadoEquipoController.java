package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.EstadoEquipo;
import aplicacionesweb.proyectoinventario.service.EstadoEquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-equipo")
@CrossOrigin(origins = "*")
public class EstadoEquipoController {

    private final EstadoEquipoService service;

    public EstadoEquipoController(EstadoEquipoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstadoEquipo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEquipo> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoEquipo> crear(@RequestBody EstadoEquipo estadoEquipo) {
        EstadoEquipo nuevo = service.guardar(estadoEquipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoEquipo> actualizar(@PathVariable Integer id, @RequestBody EstadoEquipo estadoEquipo) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    estadoEquipo.setIdEstadoEquipo(id);
                    return ResponseEntity.ok(service.guardar(estadoEquipo));
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
