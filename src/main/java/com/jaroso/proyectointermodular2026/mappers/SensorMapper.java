package com.jaroso.proyectointermodular2026.mappers;


import com.jaroso.proyectointermodular2026.dtos.SensorCreateDto;
import com.jaroso.proyectointermodular2026.dtos.SensorDto;
import com.jaroso.proyectointermodular2026.entities.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    @Mapping(target = "sectorId", source = "sector.id")
    SensorDto toDto(Sensor sensor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sector", ignore = true)
    Sensor toEntity(SensorCreateDto sensorDto);
}
