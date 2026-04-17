package com.jaroso.proyectointermodular2026.dtos;


import com.jaroso.proyectointermodular2026.entities.EstadoSensor;
import com.jaroso.proyectointermodular2026.entities.TipoSensor;

public record SensorCreateDto(Long sectorId, String nombre, String descripcion,
                              String ubicacion, String topicMQTT, String topicMQTTAct,
                              Integer valorMin, Integer valorMax, Boolean isActuador,
                              TipoSensor tipo, EstadoSensor estado) {
}
