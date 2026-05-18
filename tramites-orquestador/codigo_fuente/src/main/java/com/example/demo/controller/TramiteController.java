package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TramiteService;

@RestController
@RequestMapping("/api/tramites")
public class TramiteController {

    private final TramiteService tramiteService;

    public TramiteController(TramiteService tramiteService) {
        this.tramiteService = tramiteService;
    }

    @PostMapping("/iniciar/{idViajero}")
    public String iniciarTramite(@PathVariable Long idViajero) {
        return tramiteService.generarResumenTramite(idViajero);
    }
}