package com.example.demo.client;

import com.example.demo.dto.ViajeroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viajeros-service", url = "http://viajeros-service:8080")
public interface ViajeroClient {
    @GetMapping("/api/viajeros/{id}")
    ViajeroDTO obtenerViajeroPorId(@PathVariable("id") Long id);
}
