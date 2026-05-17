package com.example.demo.dto;

public class VehiculoCreateDTO {
    private String patente;
    private String marca;
    private String modelo;
    private String color;
    private Long viajeroId;
    private Long usuarioId;

    // Getters y Setters
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Long getViajeroId() { return viajeroId; }
    public void setViajeroId(Long viajeroId) { this.viajeroId = viajeroId; }
    
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
