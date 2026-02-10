package com.jaroso.proyectointermodular2026.mappers;
import com.jaroso.proyectointermodular2026.dtos.SensorCreatetoDto;
import com.jaroso.proyectointermodular2026.dtos.SensorDto;
import com.jaroso.proyectointermodular2026.entities.Sensor;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface SensorMapper {
     SensorDto toDto(Sensor sensor);
     Sensor toEntity(SensorCreatetoDto sensorDto);
}
