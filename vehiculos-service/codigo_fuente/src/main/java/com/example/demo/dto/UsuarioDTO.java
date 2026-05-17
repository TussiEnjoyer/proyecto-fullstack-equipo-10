package com.example.demo.dto;

public class UsuarioDTO {
    private Long id;        // Se genera automáticamente en la BD
    private String username; // Nombre de usuario para login
    private String email;    // Correo electrónico del usuario

    // Getters y Setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getUsername() { 
        return username; 
    }
    public void setUsername(String username) { 
        this.username = username; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
}
