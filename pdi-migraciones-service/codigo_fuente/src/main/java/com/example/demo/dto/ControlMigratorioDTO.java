package com.example.demo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlMigratorioDTO {
    private Long id;
    private String rutViajero;
    private String tipoMovimiento;
    private boolean odenArrestoActiva;
    private String resultadoControl;
    private LocalDateTime fechaControl;
}