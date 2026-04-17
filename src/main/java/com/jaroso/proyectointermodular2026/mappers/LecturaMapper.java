package com.jaroso.proyectointermodular2026.mappers;


import com.jaroso.proyectointermodular2026.dtos.LecturaCreateDto;
import com.jaroso.proyectointermodular2026.dtos.LecturaDto;
import com.jaroso.proyectointermodular2026.entities.Lectura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LecturaMapper {
    @Mapping(target = "sensorId", source = "sensor.id")
    LecturaDto toDto(Lectura lectura);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaHora", ignore = true)
    @Mapping(target = "sensor", ignore = true)
    Lectura toEntity(LecturaCreateDto lecturaCreateDto);
}
