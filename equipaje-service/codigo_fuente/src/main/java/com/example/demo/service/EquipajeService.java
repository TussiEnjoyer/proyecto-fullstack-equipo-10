package com.example.demo.service;

import com.example.demo.model.Equipaje;
import com.example.demo.repository.EquipajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipajeService {

    private final EquipajeRepository repository;

    public EquipajeService(EquipajeRepository repository) {
        this.repository = repository;
    }

    public List<Equipaje> listar() {
        return repository.findAll();
    }

    public Optional<Equipaje> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Equipaje guardar(Equipaje equipaje) {
        return repository.save(equipaje);
    }

    public Equipaje actualizar(Long id, Equipaje nuevo) {
        return repository.findById(id)
                .map(e -> {
                    e.setPeso(nuevo.getPeso());
                    e.setTipo(nuevo.getTipo());
                    e.setPropietario(nuevo.getPropietario());
                    return repository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Equipaje no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
