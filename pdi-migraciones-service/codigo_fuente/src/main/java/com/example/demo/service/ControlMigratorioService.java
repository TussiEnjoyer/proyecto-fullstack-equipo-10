package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ControlMigratorioCreateDTO;
import com.example.demo.dto.ControlMigratorioDTO;
import com.example.demo.model.ControlMigratorio;
import com.example.demo.repository.ControlMigratorioRepository;

@Service
public class ControlMigratorioService {

    private final ControlMigratorioRepository repo;

    public ControlMigratorioService(ControlMigratorioRepository repo) {
        this.repo = repo;
    }

    public ControlMigratorioDTO procesarControl(ControlMigratorioCreateDTO dto) {
        ControlMigratorio control = new ControlMigratorio();
        control.setRutViajero(dto.getRutViajero());
        control.setTipoMovimiento(dto.getTipoMovimiento().toUpperCase());
        control.setFechaControl(LocalDateTime.now());

        // Simulación: Si el RUT termina en '9', simulamos una orden de arresto activa
        boolean tieneOrden = dto.getRutViajero().trim().endsWith("9");
        control.setOdenArrestoActiva(tieneOrden);

        if (tieneOrden) {
            control.setResultadoControl("RECHAZADO - ALERTA PDI ALTIRO");
        } else {
            control.setResultadoControl("APROBADO");
        }

        ControlMigratorio guardado = repo.save(control);
        return toDTO(guardado);
    }

    public List<ControlMigratorioDTO> listarHistorial() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ControlMigratorioDTO toDTO(ControlMigratorio c) {
        return new ControlMigratorioDTO(c.getId(), c.getRutViajero(), c.getTipoMovimiento(), c.isOdenArrestoActiva(), c.getResultadoControl(), c.getFechaControl());
    }
}