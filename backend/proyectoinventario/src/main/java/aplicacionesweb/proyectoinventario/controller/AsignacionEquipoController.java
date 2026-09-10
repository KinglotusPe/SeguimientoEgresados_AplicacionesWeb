package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.AsignacionEquipo;
import aplicacionesweb.proyectoinventario.service.AsignacionEquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@CrossOrigin(origins = "*")
public class AsignacionEquipoController {

    private final AsignacionEquipoService service;

    public AsignacionEquipoController(AsignacionEquipoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AsignacionEquipo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionEquipo> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipo/{idEquipo}")
    public ResponseEntity<List<AsignacionEquipo>> listarPorEquipo(@PathVariable Integer idEquipo) {
        return ResponseEntity.ok(service.listarPorEquipo(idEquipo));
    }

    @GetMapping("/personal/{idPersonal}")
    public ResponseEntity<List<AsignacionEquipo>> listarPorPersonal(@PathVariable Integer idPersonal) {
        return ResponseEntity.ok(service.listarPorPersonal(idPersonal));
    }

    @GetMapping("/despacho/{idDespacho}")
    public ResponseEntity<List<AsignacionEquipo>> listarPorDespacho(@PathVariable Integer idDespacho) {
        return ResponseEntity.ok(service.listarPorDespacho(idDespacho));
    }

    @PostMapping
    public ResponseEntity<AsignacionEquipo> crear(@RequestBody AsignacionEquipo asignacionEquipo) {
        AsignacionEquipo nuevo = service.guardar(asignacionEquipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionEquipo> actualizar(@PathVariable Integer id, @RequestBody AsignacionEquipo asignacionEquipo) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    asignacionEquipo.setIdAsignacion(id);
                    return ResponseEntity.ok(service.guardar(asignacionEquipo));
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
