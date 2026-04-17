package com.jaroso.proyectointermodular2026.dtos;


import com.jaroso.proyectointermodular2026.entities.EstadoSensor;
import com.jaroso.proyectointermodular2026.entities.TipoSensor;

public record SensorDto(Long id, String nombre, TipoSensor tipo, EstadoSensor estado, String ubicacion,
                        String topicMQTT, String topicMQTTAct, Integer valorMin, Integer valorMax,
                        Boolean isActuador, Long sectorId) {
}
