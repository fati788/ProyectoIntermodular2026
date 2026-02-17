package com.jaroso.proyectointermodular2026.dtos;

import java.time.LocalDateTime;

public record LecturaDto(Long id, Double valor, String unidad, LocalDateTime fechaHora, Long sensorId) {
}
