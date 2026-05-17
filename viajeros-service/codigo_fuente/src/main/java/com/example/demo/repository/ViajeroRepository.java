
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Viajero;

public interface ViajeroRepository extends JpaRepository<Viajero, Long> {
}
