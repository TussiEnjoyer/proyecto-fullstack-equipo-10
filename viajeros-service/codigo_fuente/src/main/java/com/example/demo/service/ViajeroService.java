// src/main/java/com/example/demo/service/ViajeroService.java
package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ViajeroCreateDTO;
import com.example.demo.dto.ViajeroDTO;
import com.example.demo.excepciones.RecursoNoEncontradoException;
import com.example.demo.model.Viajero;
import com.example.demo.repository.ViajeroRepository;

@Service
public class ViajeroService {

    private final ViajeroRepository repo;

    public ViajeroService(ViajeroRepository repo) {
        this.repo = repo;
    }

    // POST /api/viajeros
    public ViajeroDTO crearViajero(ViajeroCreateDTO dto) {
        // 1. DTO de entrada -> Entidad
        Viajero v = new Viajero();
        v.setRut(dto.getRut());
        v.setNombre(dto.getNombre());
        v.setCorreo(dto.getCorreo());
        v.setTelefono(dto.getTelefono());
        // El id lo asigna JPA/BD automáticamente

        // 2. Persistir
        Viajero guardado = repo.save(v);

        // 3. Entidad -> DTO de salida (ya con id generado)
        return toDTO(guardado);
    }

    // GET /api/viajeros/{id}
    public ViajeroDTO findDtoById(Long id) {
        Viajero v = repo.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException(
                "Viajero no encontrado con id: " + id));
        return toDTO(v);
    }

    // GET /api/viajeros
    public List<ViajeroDTO> listarDto() {
        return repo.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    // PUT /api/viajeros/{id}
    public ViajeroDTO actualizarDto(Long id, ViajeroCreateDTO dto) {
        Viajero existente = repo.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException(
                "Viajero no encontrado con id: " + id));

        existente.setRut(dto.getRut());
        existente.setNombre(dto.getNombre());
        existente.setCorreo(dto.getCorreo());
        existente.setTelefono(dto.getTelefono());

        Viajero actualizado = repo.save(existente);
        return toDTO(actualizado);
    }

    // DELETE /api/viajeros/{id}
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException(
                "Viajero no encontrado con id: " + id);
        }
        repo.deleteById(id);
    }

    // Helper privado: Entidad -> DTO
    private ViajeroDTO toDTO(Viajero v) {
        return new ViajeroDTO(
            v.getId(),
            v.getRut(),
            v.getNombre(),
            v.getCorreo(),
            v.getTelefono()
        );
    }
}