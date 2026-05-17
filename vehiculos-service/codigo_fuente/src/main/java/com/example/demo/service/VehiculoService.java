package com.example.demo.service;

import com.example.demo.dto.VehiculoDTO;
import com.example.demo.dto.VehiculoCreateDTO;
import com.example.demo.model.Vehiculo;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.exception.VehiculoNoEncontradoException;
import com.example.demo.client.ViajeroClient;
import com.example.demo.client.AuthClient;
import com.example.demo.dto.ViajeroDTO;
import com.example.demo.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService {
    private final VehiculoRepository repo;
    private final ViajeroClient viajeroClient;
    private final AuthClient authClient;

    public VehiculoService(VehiculoRepository repo, ViajeroClient viajeroClient, AuthClient authClient) {
        this.repo = repo;
        this.viajeroClient = viajeroClient;
        this.authClient = authClient;
    }

    // Crear vehículo validando viajero y usuario
    public VehiculoDTO crear(VehiculoCreateDTO dto) {
        ViajeroDTO viajero = viajeroClient.obtenerViajeroPorId(dto.getViajeroId());
        if (viajero == null) throw new VehiculoNoEncontradoException("Viajero no encontrado");

        UsuarioDTO usuario = authClient.obtenerUsuarioPorId(dto.getUsuarioId());
        if (usuario == null) throw new VehiculoNoEncontradoException("Usuario no encontrado");

        Vehiculo v = new Vehiculo();
        v.setPatente(dto.getPatente());
        v.setMarca(dto.getMarca());
        v.setModelo(dto.getModelo());
        v.setColor(dto.getColor());
        v.setViajeroId(dto.getViajeroId());
        v.setUsuarioId(dto.getUsuarioId());

        return toDTO(repo.save(v));
    }

    // Listar todos los vehículos
    public List<VehiculoDTO> listar() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Buscar vehículo por ID
    public VehiculoDTO buscarPorId(Long id) {
        Vehiculo v = repo.findById(id)
            .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado"));
        return toDTO(v);
    }

    // Listar vehículos por viajero
    public List<VehiculoDTO> listarPorViajero(Long viajeroId) {
        return repo.findByViajeroId(viajeroId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    // Actualizar vehículo
    public VehiculoDTO actualizar(Long id, VehiculoCreateDTO dto) {
        Vehiculo v = repo.findById(id)
            .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado"));

        v.setPatente(dto.getPatente());
        v.setMarca(dto.getMarca());
        v.setModelo(dto.getModelo());
        v.setColor(dto.getColor());
        v.setViajeroId(dto.getViajeroId());
        v.setUsuarioId(dto.getUsuarioId());

        return toDTO(repo.save(v));
    }

    // Eliminar vehículo
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new VehiculoNoEncontradoException("Vehículo no encontrado");
        repo.deleteById(id);
    }

    // Conversión a DTO
    private VehiculoDTO toDTO(Vehiculo v) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(v.getId());
        dto.setPatente(v.getPatente());
        dto.setMarca(v.getMarca());
        dto.setModelo(v.getModelo());
        dto.setColor(v.getColor());
        dto.setViajeroId(v.getViajeroId());
        dto.setUsuarioId(v.getUsuarioId());
        return dto;
    }
}
