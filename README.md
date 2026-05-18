# Proyecto de Arquitectura de Microservicios - Sistema Aduana

Este proyecto consiste en un ecosistema de 10 microservicios independientes e interconectados mediante una arquitectura orientada a servicios, corriendo completamente sobre contenedores aislados en Docker.

## 👥 Integrantes
* Renato Soto, Joaquin orellana Grupo de Desarrollo - Sección 003D

## 🛠️ Arquitectura y Mapeo de Puertos Oficial
El sistema distribuye sus responsabilidades en los siguientes componentes, configurados con sus respectivas bases de datos y puertos expuestos:

| Microservicio | Puerto | DB Name | Funcionalidad |
|---|---|---|---|
| **Usuarios** | 8080 | `db_usuario` | Registro de usuarios, gestión de roles y administración de perfiles. |
| **Vehículos** | 8081 | `db_vehiculo` | CRUD de vehículos, control de patentes y validación de números de chasis (VIN). |
| **Mascotas** | 8082 | `db_mascota` | Registro de mascotas, trazabilidad de microchips y control sanitario (vacunas). |
| **Menores** | 8083 | `db_menor` | Validación de permisos de viaje y registro de actas notariales. |
| **Declaraciones**| 8084 | `db_declaracion` | Declaración jurada de mercancías y valoración aduanera (USD). |
| **Aduanas** | 8085 | `db_aduana` | Registro de cruces fronterizos, tracking de complejos y validación de ingresos/egresos con ms-usuario. |
| **Correos** | 8086 | `db_correo` | Registro de encomiendas internacionales, tracking de paquetes, control de peso y gestión de estado aduanero (Retenido/Liberado). |
| **Códigos QR** | 8087 | `db_qr` | Generación y validación de Pases QR de aduana para ciudadanos, con verificación de identidad mediante ms-usuario. |
| **Turnos** | 8088 | `db_turno` | Gestión de horarios y asignaciones de funcionarios a puestos de control fronterizo, con validación de identidad mediante ms-usuario. |
| **Reportes** | 8089 | `db_reporte` | Registro y gestión de incidentes, contrabando o fiscalizaciones aduaneras con validación mediante ms-usuario. |

## 🚀 Requisitos y Pasos para la Ejecución

### Prerrequisitos
* Docker y Docker Compose instalados en la máquina host (EC2 o entorno local).
* SDK de Java 21 y Maven.

### Instrucciones de Despliegue de la Infraestructura
1. Asegurarse de estar situado en la raíz del proyecto donde reside el archivo `docker-compose.yml`.
2. Levantar la suite completa de contenedores de las bases de datos y entornos en segundo plano:
   ```bash
   docker compose up -d
