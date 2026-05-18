package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertaDTO {
    private String pasaporte;
    private String tipoAlerta;
    private String descripcion;
}