package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario guardar(Usuario u) {
        return repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    // 🔹 Método actualizar
    public Usuario actualizar(Long id, Usuario datos) {
        Usuario existente = repo.findById(id).orElse(null);
        if (existente != null) {
            existente.setUsername(datos.getUsername());
            existente.setPassword(datos.getPassword());
            existente.setCorreo(datos.getCorreo());
            existente.setRol(datos.getRol());
            return repo.save(existente);
        }
        return null;
    }

    // 🔹 Método extra para login
    public Usuario buscarPorUsername(String username) {
        return repo.findByUsername(username);
    }
}
