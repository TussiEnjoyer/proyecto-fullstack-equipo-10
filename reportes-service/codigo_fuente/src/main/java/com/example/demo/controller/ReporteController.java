package com.example.demo.controller;

import com.example.demo.model.Reporte;
import com.example.demo.service.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService service;

    public ReporteController(ReporteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reporte> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Reporte buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Reporte guardar(@RequestBody Reporte reporte) {
        return service.guardar(reporte);
    }

    @PutMapping("/{id}")
    public Reporte actualizar(@PathVariable Long id, @RequestBody Reporte reporte) {
        return service.actualizar(id, reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
