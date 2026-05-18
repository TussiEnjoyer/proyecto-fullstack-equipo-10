package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ControlMigratorioCreateDTO;
import com.example.demo.dto.ControlMigratorioDTO;
import com.example.demo.service.ControlMigratorioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pdi")
public class ControlMigratorioController {

    private final ControlMigratorioService servicio;

    public ControlMigratorioController(ControlMigratorioService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/control")
    public ControlMigratorioDTO procesarControl(@Valid @RequestBody ControlMigratorioCreateDTO dto) {
        return servicio.procesarControl(dto);
    }

    @GetMapping("/historial")
    public List<ControlMigratorioDTO> obtenerHistorial() {
        return servicio.listarHistorial();
    }
}