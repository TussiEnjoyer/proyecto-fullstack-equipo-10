package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.client.ViajeroClient;
import com.example.demo.dto.ViajeroDTO;

@Service
public class TramiteService {

    private final ViajeroClient viajeroClient;

    public TramiteService(ViajeroClient viajeroClient) {
        this.viajeroClient = viajeroClient;
    }

    public String generarResumenTramite(Long idViajero) {
        ViajeroDTO viajero = viajeroClient.obtenerViajeroPorId(idViajero);
        return "Trámite iniciado para el viajero: " + viajero.getNombre() + " (RUT: " + viajero.getRut() + ")";
    }
}