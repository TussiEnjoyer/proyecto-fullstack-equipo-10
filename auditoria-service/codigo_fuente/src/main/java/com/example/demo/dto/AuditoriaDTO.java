package com.example.demo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaDTO {
    private Long id;
    private String servicioOrigen;
    private String accion;
    private String detalle;
    private LocalDateTime fechaHora;
}