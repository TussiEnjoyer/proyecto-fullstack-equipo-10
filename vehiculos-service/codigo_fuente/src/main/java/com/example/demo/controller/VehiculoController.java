package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.dto.VehiculoDTO;
import com.example.demo.dto.VehiculoCreateDTO;
import com.example.demo.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    private final VehiculoService servicio;

    public VehiculoController(VehiculoService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public VehiculoDTO crear(@RequestBody VehiculoCreateDTO dto) {
        return servicio.crear(dto);
    }

    @GetMapping
    public List<VehiculoDTO> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public VehiculoDTO obtener(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    @GetMapping("/viajero/{viajeroId}")
    public List<VehiculoDTO> listarPorViajero(@PathVariable Long viajeroId) {
        return servicio.listarPorViajero(viajeroId);
    }

    @PutMapping("/{id}")
    public VehiculoDTO actualizar(@PathVariable Long id, @RequestBody VehiculoCreateDTO dto) {
        return servicio.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
