package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AlertaDTO;
import com.example.demo.service.InternacionalService;

@RestController
@RequestMapping("/api/internacional")
public class InternacionalController {

    private final InternacionalService servicio;

    public InternacionalController(InternacionalService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/consultar/{pasaporte}")
    public AlertaDTO consultarAlerta(@PathVariable String pasaporte) {
        return servicio.consultarPasaporte(pasaporte);
    }
}