package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.Sede;
import aplicacionesweb.proyectoinventario.service.SedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
@CrossOrigin(origins = "*")
public class SedeController {

    private final SedeService service;

    public SedeController(SedeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Sede>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/distrito-fiscal/{idDistritoFiscal}")
    public ResponseEntity<List<Sede>> listarPorDistritoFiscal(@PathVariable Integer idDistritoFiscal) {
        return ResponseEntity.ok(service.listarPorDistritoFiscal(idDistritoFiscal));
    }

    @PostMapping
    public ResponseEntity<Sede> crear(@RequestBody Sede sede) {
        Sede nuevo = service.guardar(sede);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizar(@PathVariable Integer id, @RequestBody Sede sede) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    sede.setIdSede(id);
                    return ResponseEntity.ok(service.guardar(sede));
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
