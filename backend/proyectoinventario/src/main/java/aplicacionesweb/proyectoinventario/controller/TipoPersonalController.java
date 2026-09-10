package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.TipoPersonal;
import aplicacionesweb.proyectoinventario.service.TipoPersonalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-personal")
@CrossOrigin(origins = "*")
public class TipoPersonalController {

    private final TipoPersonalService service;

    public TipoPersonalController(TipoPersonalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TipoPersonal>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonal> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPersonal> crear(@RequestBody TipoPersonal tipoPersonal) {
        TipoPersonal nuevo = service.guardar(tipoPersonal);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonal> actualizar(@PathVariable Integer id, @RequestBody TipoPersonal tipoPersonal) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    tipoPersonal.setIdTipoPersonal(id);
                    return ResponseEntity.ok(service.guardar(tipoPersonal));
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
