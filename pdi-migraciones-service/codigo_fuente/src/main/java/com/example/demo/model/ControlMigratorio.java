package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ControlMigratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rutViajero;
    private String tipoMovimiento; // "INGRESO" o "EGRESO"
    private boolean odenArrestoActiva;
    private String resultadoControl; // "APROBADO" o "RECHAZADO"
    private LocalDateTime fechaControl;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRutViajero() { return rutViajero; }
    public void setRutViajero(String rutViajero) { this.rutViajero = rutViajero; }
    public String getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(String tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }
    public boolean isOdenArrestoActiva() { return odenArrestoActiva; }
    public void setOdenArrestoActiva(boolean odenArrestoActiva) { this.odenArrestoActiva = odenArrestoActiva; }
    public String getResultadoControl() { return resultadoControl; }
    public void setResultadoControl(String resultadoControl) { this.resultadoControl = resultadoControl; }
    public LocalDateTime getFechaControl() { return fechaControl; }
    public void setFechaControl(LocalDateTime fechaControl) { this.fechaControl = fechaControl; }
}