package aplicacionesweb.proyectoinventario.controller;

import aplicacionesweb.proyectoinventario.entity.DistritoFiscal;
import aplicacionesweb.proyectoinventario.service.DistritoFiscalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distritos-fiscales")
@CrossOrigin(origins = "*")
public class DistritoFiscalController {

    private final DistritoFiscalService service;

    public DistritoFiscalController(DistritoFiscalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DistritoFiscal>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistritoFiscal> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DistritoFiscal> crear(@RequestBody DistritoFiscal distritoFiscal) {
        DistritoFiscal nuevo = service.guardar(distritoFiscal);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistritoFiscal> actualizar(@PathVariable Integer id, @RequestBody DistritoFiscal distritoFiscal) {
        return service.obtenerPorId(id)
                .map(existente -> {
                    distritoFiscal.setIdDistritoFiscal(id);
                    return ResponseEntity.ok(service.guardar(distritoFiscal));
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
