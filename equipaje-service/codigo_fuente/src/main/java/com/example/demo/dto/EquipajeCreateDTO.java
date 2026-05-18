package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipajeCreateDTO {
    @NotBlank(message = "El código de etiqueta es obligatorio")
    private String codigoEtiqueta;

    @NotNull(message = "El peso es obligatorio")
    private Double peso;

    @NotBlank(message = "El tipo de equipaje es obligatorio")
    private String tipo;

    @NotNull(message = "El ID del viajero es obligatorio")
    private Long idViajero;
}