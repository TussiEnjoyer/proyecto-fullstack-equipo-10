package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaCreateDTO {
    @NotBlank(message = "El servicio de origen es obligatorio")
    private String servicioOrigen;
    
    @NotBlank(message = "La acción realizada es obligatoria")
    private String accion;
    
    @NotBlank(message = "El detalle de la auditoría es obligatorio")
    private String detalle;
}