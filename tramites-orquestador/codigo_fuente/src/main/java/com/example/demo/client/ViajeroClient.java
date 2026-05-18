package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.dto.ViajeroDTO;

@FeignClient(name = "viajeros-service", url = "http://localhost:8081/api/viajeros")
public interface ViajeroClient {
    
    @GetMapping("/{id}")
    ViajeroDTO obtenerViajeroPorId(@PathVariable("id") Long id);
}