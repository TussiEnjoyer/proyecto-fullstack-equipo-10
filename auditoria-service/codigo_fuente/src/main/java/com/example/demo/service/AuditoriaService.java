package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AuditoriaCreateDTO;
import com.example.demo.dto.AuditoriaDTO;
import com.example.demo.model.Auditoria;
import com.example.demo.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

    private final AuditoriaRepository repo;

    public AuditoriaService(AuditoriaRepository repo) {
        this.repo = repo;
    }

    public AuditoriaDTO registrarLog(AuditoriaCreateDTO dto) {
        Auditoria aud = new Auditoria();
        aud.setServicioOrigen(dto.getServicioOrigen());
        aud.setAccion(dto.getAccion());
        aud.setDetalle(dto.getDetalle());
        aud.setFechaHora(LocalDateTime.now()); // Guarda el momento exacto automáticamente

        Auditoria guardado = repo.save(aud);
        return toDTO(guardado);
    }

    public List<AuditoriaDTO> listarLogs() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private AuditoriaDTO toDTO(Auditoria aud) {
        return new AuditoriaDTO(aud.getId(), aud.getServicioOrigen(), aud.getAccion(), aud.getDetalle(), aud.getFechaHora());
    }
}