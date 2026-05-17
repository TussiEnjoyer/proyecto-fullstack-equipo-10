package com.example.demo.controller;

import com.example.demo.model.Equipaje;
import com.example.demo.service.EquipajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipajes")
public class EquipajeController {

    private final EquipajeService service;

    public EquipajeController(EquipajeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipaje> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Equipaje buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Equipaje no encontrado con id " + id));
    }

    @PostMapping
    public Equipaje guardar(@RequestBody Equipaje equipaje) {
        return service.guardar(equipaje);
    }

    @PutMapping("/{id}")
    public Equipaje actualizar(@PathVariable Long id, @RequestBody Equipaje equipaje) {
        return service.actualizar(id, equipaje);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
