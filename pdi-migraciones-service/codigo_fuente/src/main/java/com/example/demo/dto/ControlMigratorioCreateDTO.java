package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlMigratorioCreateDTO {
    @NotBlank(message = "El RUT del viajero es obligatorio")
    private String rutViajero;
    
    @NotBlank(message = "El tipo de movimiento (INGRESO/EGRESO) es obligatorio")
    private String tipoMovimiento;
}