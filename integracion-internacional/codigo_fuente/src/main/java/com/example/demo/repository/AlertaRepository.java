package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AlertaInternacional;
import java.util.Optional;

public interface AlertaRepository extends JpaRepository<AlertaInternacional, Long> {
    Optional<AlertaInternacional> findByPasaporte(String pasaporte);
}