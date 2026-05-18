package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipajeDTO {
    private Long id;
    private String codigoEtiqueta;
    private Double peso;
    private String tipo;
    private Long idViajero;
}