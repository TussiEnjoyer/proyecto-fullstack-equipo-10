package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/check")
    public String revisar() {
        return "¡Hola! Soy el API Gateway (El Recepcionista). Estoy listo para dirigir el tráfico.";
    }
}