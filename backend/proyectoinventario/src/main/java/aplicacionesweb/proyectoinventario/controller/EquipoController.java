package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Equipo;
import aplicacionesweb.proyectoinventario.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo-patrimonial/{codigo}")
    public ResponseEntity<Equipo> obtenerPorCodigoPatrimonial(@PathVariable String codigo) {
        return service.obtenerPorCodigoPatrimonial(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/serie/{serie}")
    public ResponseEntity<Equipo> obtenerPorNumeroSerie(@PathVariable String serie) {
        return service.obtenerPorNumeroSerie(serie)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> crear(@RequestBody Equipo equipo) {
        Equipo nuevo = service.guardar(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    equipo.setIdEquipo(id);
                    return ResponseEntity.ok(service.guardar(equipo));
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
