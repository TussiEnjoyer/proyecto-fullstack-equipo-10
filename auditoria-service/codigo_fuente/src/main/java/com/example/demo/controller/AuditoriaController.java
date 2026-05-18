import com.aduanas.auditoria.model.Auditoria;
import com.aduanas.auditoria.service.AuditoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    private final AuditoriaService service;

    public AuditoriaController(AuditoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Auditoria> registrar(@RequestBody Auditoria auditoria) {
        return ResponseEntity.ok(service.registrar(auditoria));
    }

    @GetMapping
    public ResponseEntity<List<Auditoria>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}