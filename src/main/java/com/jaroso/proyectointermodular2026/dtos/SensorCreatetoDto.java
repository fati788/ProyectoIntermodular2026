package com.jaroso.proyectointermodular2026.dtos;

import com.jaroso.proyectointermodular2026.entities.EstadoSensor;
import com.jaroso.proyectointermodular2026.entities.TipoSensor;

public record SensorCreatetoDto(String nombre, String descripcion, String sector, TipoSensor tipo, EstadoSensor estado) {
}
