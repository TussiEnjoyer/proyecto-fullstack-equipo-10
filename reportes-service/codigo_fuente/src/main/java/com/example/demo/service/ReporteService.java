package com.example.demo.service;

import com.example.demo.model.Reporte;
import com.example.demo.repository.ReporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository repository;

    public ReporteService(ReporteRepository repository) {
        this.repository = repository;
    }

    public List<Reporte> listar() {
        return repository.findAll();
    }

    public Reporte buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    public Reporte guardar(Reporte reporte) {
        return repository.save(reporte);
    }

    public Reporte actualizar(Long id, Reporte reporte) {
        Reporte existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        existente.setTitulo(reporte.getTitulo());
        existente.setDescripcion(reporte.getDescripcion());
        existente.setTipo(reporte.getTipo());
        existente.setAutor(reporte.getAutor());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Reporte no encontrado");
        }
        repository.deleteById(id);
    }
}
