// src/main/java/com/example/demo/controller/ViajeroController.java
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ViajeroCreateDTO;
import com.example.demo.dto.ViajeroDTO;
import com.example.demo.service.ViajeroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/viajeros")
public class ViajeroController {

    private final ViajeroService servicio;

    public ViajeroController(ViajeroService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ViajeroDTO crear(@Valid @RequestBody ViajeroCreateDTO dto) {
        return servicio.crearViajero(dto);
    }

    @GetMapping
    public List<ViajeroDTO> listar() {
        return servicio.listarDto();
    }

    @GetMapping("/{id}")
    public ViajeroDTO obtener(@PathVariable Long id) {
        return servicio.findDtoById(id);
    }

    @PutMapping("/{id}")
    public ViajeroDTO actualizar(@PathVariable Long id, @Valid @RequestBody ViajeroCreateDTO dto) {
        return servicio.actualizarDto(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}