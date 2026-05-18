# Proyecto de Arquitectura de Microservicios - Sistema Aduana

Este proyecto consiste en un ecosistema de 10 microservicios interconectados mediante una arquitectura orientada a servicios, corriendo completamente sobre contenedores Docker.

## 👥 Integrantes
* Grupo de Desarrollo - Sección 003D

## 🛠️ Arquitectura y Puertos Mapeados
El sistema utiliza el **API Gateway** en el puerto raíz para enrutar el tráfico de forma dinámica hacia los servicios correspondientes utilizando nombres de red de Docker.

| # | Microservicio | Puerto Interno/Host | Base de Datos |
|---|---|---|---|
| 1 | `api-gateway` | 8080 | db_gateway |
| 2 | `auth-service` | 8085 | db_auth |
| 3 | `viajeros-service` | 8081 | db_viajeros |
| 4 | `vehiculos-service` | 8082 | db_vehiculos |
| 5 | `equipaje-service` | 8083 | db_equipaje |
| 6 | `auditoria-service` | 8084 | db_auditoria |
| 7 | `pdi-migraciones-service` | 8086 | db_pdi |
| 8 | `integracion-internacional`| 8087 | db_internacional |
| 9 | `reportes-service` | 8088 | db_reportes |
| 10| `tramites-orquestador` | 8089 | N/A (Feign Client) |

## 🚀 Requisitos y Pasos para la Ejecución

### Prerrequisitos
* Docker y Docker Compose instalados en la máquina host (EC2 o Local).
* Maven (incluido dentro de las imágenes de desarrollo).

### Instrucciones de Despliegue
1. Clonar este repositorio.
2. Situarse en la raíz del proyecto donde se encuentra el archivo `docker-compose.yml`.
3. Levantar la infraestructura de contenedores en segundo plano:
   ```bash
   docker compose up -d
