package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dto.AlertaDTO;
import com.example.demo.model.AlertaInternacional;
import com.example.demo.repository.AlertaRepository;

@Service
public class InternacionalService {

    private final AlertaRepository repo;

    public InternacionalService(AlertaRepository repo) {
        this.repo = repo;
    }

    public AlertaDTO consultarPasaporte(String pasaporte) {
        return repo.findByPasaporte(pasaporte)
            .map(a -> new AlertaDTO(a.getPasaporte(), a.getTipoAlerta(), a.getDescripcion()))
            .orElse(new AlertaDTO(pasaporte, "NINGUNA", "Sin alertas vigentes en Interpol."));
    }
}