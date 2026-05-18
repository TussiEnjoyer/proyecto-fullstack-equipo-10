package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ControlMigratorio;

public interface ControlMigratorioRepository extends JpaRepository<ControlMigratorio, Long> {
}